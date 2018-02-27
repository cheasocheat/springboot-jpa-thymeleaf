package com.glf.test.glftest.webservice;

import com.glf.test.glftest.domain.Operation;
import com.glf.test.glftest.webservice.configuration.RestConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 11:31
 */
@RestController
@RequestMapping(value = RestConfig.REST_URL + RestConfig.REST_OPERATION)
public class OperationRestController {

    @GetMapping(value = {"","/"})
    public String getRest(){
        return "Hello GLTest!";
    }

    public ResponseEntity<Operation> getListOperation(){
        return null;
    }

}
