package com.glf.test.glftest.webservice;

import com.glf.test.glftest.domain.Province;
import com.glf.test.glftest.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class ProvinceRestController {

    @Autowired
    private ProvinceService service;

    @GetMapping(value = "/provinces", produces = "application/json")
    public ResponseEntity<Province> getListProvinces() {
        List<Province> lstReceipts = service.getListProvinces();
        if (lstReceipts != null && !lstReceipts.isEmpty()) {
            return new ResponseEntity(lstReceipts, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}