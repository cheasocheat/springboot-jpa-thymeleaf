package com.glf.test.glftest.webservice;

import com.glf.test.glftest.domain.Operation;
import com.glf.test.glftest.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 11:31
 */
@RestController
@RequestMapping(value = "/api/v1")
public class OperationRestController {

    @Autowired
    private OperationService service;

    @GetMapping(value = "/operations", produces = "application/json")
    public ResponseEntity<Operation> getListOperation(){
        List<Operation> lstOperations = service.getListOperation();
        if (lstOperations != null && !lstOperations.isEmpty()) {
            return new ResponseEntity(lstOperations, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @GetMapping(value = "/operations/{id}", produces = "application/json")
    public ResponseEntity<Operation> getListOperationById(@PathVariable("id") Long id){
        Operation operation = service.findById(id);
        if (operation != null) {
            return new ResponseEntity(operation, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "/operation", produces = "application/json")
    public ResponseEntity<Void> addOperation(@RequestBody Operation operation) {
       Operation dbOperation = service.findByCode(operation.getCode());
        if(dbOperation != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        boolean success = service.saveOperation(operation);
        if (success) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/operation/{id}", produces = "application/json")
    public ResponseEntity<Operation> deleteOperation(@PathVariable("id") Long id) {
        Operation operation = service.findById(id);
        if(operation != null){
            service.deleteOperationById(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
