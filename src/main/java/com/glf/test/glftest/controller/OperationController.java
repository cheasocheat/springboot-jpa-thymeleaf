package com.glf.test.glftest.controller;

import com.glf.test.glftest.domain.Operation;
import com.glf.test.glftest.domain.OperationArea;
import com.glf.test.glftest.domain.Province;
import com.glf.test.glftest.domain.Receipt;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletContext;
import javax.validation.Valid;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 09:42
 */
@Controller
@RequestMapping()
public class OperationController {

    @Autowired
    private HttpHeaders header;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ServletContext servletContext;

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Operation home page
     *
     * @param model
     * @return
     */
    @GetMapping(value = {"", "/operation"})
    public String getOperationView(Model model) {

        //Init Object
        Operation operation = new Operation();
        operation.setDefDltCharge(0.0);
        operation.setDefWage(0.0);

        //Get Receipt code
        List<Receipt> lstReceipts = new ArrayList<>();
        List<Province> lstProvinces = new ArrayList<>();
        List<Operation> lstOperations = new ArrayList<>();

        //String endPoint = servletContext.getContextPath();

        //logger.info("End Point = " + endPoint);

        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(header);

        //Request to receipt endpoint to get receipt data
        ResponseEntity<List<Receipt>> receiptResponse = restTemplate.exchange("http://localhost:8080/gltest/api/v1/receipts", HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Receipt>>() {
        });
        if (receiptResponse != null && receiptResponse.getStatusCode() == HttpStatus.OK) {
            lstReceipts = receiptResponse.getBody();
        }

        //Request to province endpoint to get province data
        ResponseEntity<List<Province>> provinceResponse = restTemplate.exchange("http://localhost:8080/gltest/api/v1/provinces", HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Province>>() {
        });
        if (provinceResponse != null && provinceResponse.getStatusCode() == HttpStatus.OK) {
            lstProvinces = provinceResponse.getBody();
        }

        //Request operation data
        ResponseEntity<List<Operation>> operationResponse =
                restTemplate.exchange("http://localhost:8080/gltest/api/v1/operations", HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Operation>>() {
                });
        if (operationResponse != null && operationResponse.getStatusCode() == HttpStatus.OK) {
            lstOperations = operationResponse.getBody();
        }

        //Bind to model to display
        model.addAttribute("operation", operation);
        model.addAttribute("operationArea", new OperationArea());
        model.addAttribute("lstReceipts", lstReceipts);
        model.addAttribute("lstProvinces", lstProvinces);
        model.addAttribute("lstOperations", lstOperations);
        return "operation";
    }


    /**
     * Add new operation
     *
     * @param operation
     * @param result
     * @param model
     * @return
     */
    @PostMapping(value = "/operation")
    public String addOperation(@ModelAttribute("operation") @Valid Operation operation,
                               BindingResult result, Model model) {
        if (operation != null) {
            header.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Operation> requestEntity = new HttpEntity<>(operation, header);
            try {
                ResponseEntity<Operation> responseEntity =
                        restTemplate.exchange("http://localhost:8080/gltest/api/v1/operation", HttpMethod.POST, requestEntity, Operation.class);
                if (responseEntity != null) {
                    if (responseEntity.getStatusCode().equals(HttpStatus.CREATED)) {
                        return "redirect:/operation";
                    } else if (responseEntity.getStatusCode().equals(HttpStatus.CONFLICT)) {
                        return "redirect:/error";
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "redirect:/error";
            }
        }
        return "redirect:/error";
    }

    @PostMapping(value = "/operationarea")
    public String updateOperatoin(@ModelAttribute("operationArea") @Valid OperationArea operationArea,
                                  @RequestParam(value = "operation") Long operationId) {
        if (operationArea != null) {
            header.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Operation> entity = new HttpEntity<>(header);
            if (operationId > 0) {
                ResponseEntity<Operation> operationResponseEntity = restTemplate.exchange("http://localhost:8080/gltest/api/v1/operations/" + operationId, HttpMethod.GET, entity, new ParameterizedTypeReference<Operation>() {
                });
                if (operationResponseEntity != null && operationResponseEntity.getStatusCode() == HttpStatus.OK) {
                    Operation operation = operationResponseEntity.getBody();
                    if (operation != null) {


                        Set<OperationArea> operationAreaSet = new HashSet<OperationArea>() {{
                            add(operationArea);
                        }};

                        operation.setOperationAreas(operationAreaSet);

                        //Save to OperationArea
                        operationArea.setOperation(operation);
                        HttpEntity<OperationArea> reqEntity = new HttpEntity<>(operationArea, header);
                        ResponseEntity<OperationArea> resEntity =
                                restTemplate.exchange("http://localhost:8080/gltest/api/v1/operationarea?operation_id=" + operationId, HttpMethod.POST, reqEntity, OperationArea.class);
                        if (resEntity != null) {
                            if (resEntity.getStatusCode().equals(HttpStatus.CREATED)) {
                                return "redirect:/operation";
                            }
                        }
                    }
                }
            }
        }
        return "redirect:/error";
    }


    @GetMapping(value = "/error")
    public String displayError() {
        return "error";
    }
}
