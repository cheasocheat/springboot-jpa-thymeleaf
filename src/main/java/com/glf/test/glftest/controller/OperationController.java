package com.glf.test.glftest.controller;

import com.glf.test.glftest.domain.Operation;
import com.glf.test.glftest.domain.OperationArea;
import com.glf.test.glftest.domain.Province;
import com.glf.test.glftest.domain.Receipt;

import java.util.ArrayList;
import java.util.List;

import com.glf.test.glftest.webservice.configuration.RestConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.servlet.ServletContext;
import javax.validation.Valid;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 09:42
 */
@Controller
@RequestMapping(value = "/operation")
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
    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String getOperationView(Model model) {
        //Get Receipt code
        List<Receipt> lstReceipts = new ArrayList<>();
        List<Province> lstProvinces = new ArrayList<>();

        String endPoint = servletContext.getContextPath() + RestConfig.REST_URL + RestConfig.REST_RECEIPT + "/list";

        logger.info("End Point = " + endPoint);

        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> requestEntity = new HttpEntity<>(header);

        //Request to receipt endpoint to get receipt data
        ResponseEntity<List<Receipt>> receiptResponse = restTemplate.exchange("http://localhost:8080/gltest/api/v1/receipt/list", HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Receipt>>() {});
        if(receiptResponse != null && receiptResponse.getStatusCode() == HttpStatus.OK){
            lstReceipts = receiptResponse.getBody();
        }

        //Request to province endpoint to get province data
        ResponseEntity<List<Province>> provinceResponse = restTemplate.exchange("http://localhost:8080/gltest/api/v1/province/list", HttpMethod.GET, requestEntity, new ParameterizedTypeReference<List<Province>>() {});
        if(provinceResponse != null && provinceResponse.getStatusCode() == HttpStatus.OK){
            lstProvinces = provinceResponse.getBody();
        }

        //Bind to model to display
        model.addAttribute("operation", new Operation());
        model.addAttribute("operationArea", new OperationArea());
        model.addAttribute("lstReceipts", lstReceipts);
        model.addAttribute("lstProvinces", lstReceipts);
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
    @RequestMapping(value = "/add")
    public String addOperation(@ModelAttribute("operation") @Valid Operation operation,
                               BindingResult result, Model model) {
        System.out.println(model);
        System.out.println(result);
        if (operation != null) {

        }

        return "redirect:/operation";
    }
}
