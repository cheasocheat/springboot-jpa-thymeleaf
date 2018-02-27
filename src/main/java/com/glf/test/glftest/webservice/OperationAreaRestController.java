package com.glf.test.glftest.webservice;

import com.glf.test.glftest.domain.OperationArea;
import com.glf.test.glftest.service.OperationAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 16:34
 */
@RestController
@RequestMapping(value = "/api/v1")
public class OperationAreaRestController {

    @Autowired
    private OperationAreaService service;

    @GetMapping(value = "/operationareas/", produces = "application/json")
    public ResponseEntity<OperationArea> getListOperationAreas(){
        List<OperationArea> lstOperations = service.getListOperationAreas();
        if (lstOperations != null && !lstOperations.isEmpty()) {
            return new ResponseEntity(lstOperations, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @GetMapping(value = "/operationareas", produces = "application/json")
    public ResponseEntity<OperationArea> getOperationAreasByOperationId(@RequestParam("operate_id") Long operateId){
        List<OperationArea> lstOperations = service.getListOperationAreasByOperationId(operateId);
        if (lstOperations != null && !lstOperations.isEmpty()) {
            return new ResponseEntity(lstOperations, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @PostMapping(value = "/operationarea", produces = "application/json")
    public ResponseEntity<Void> addOperation(@RequestBody OperationArea operationArea) {
      /*  OperationArea dbOperation = service.findByProvinceId(operationArea.getProvinceId());
        if(dbOperation != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }*/
        boolean success = service.saveOperationArea(operationArea);
        if (success) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/operationareas/{id}", produces = "application/json")
    public ResponseEntity<OperationArea> updateOperation(@PathVariable("id") Long id, @RequestBody OperationArea operationArea) {
        OperationArea dbOperationArea = service.findById(id);
        if(dbOperationArea == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dbOperationArea.setProvinceId(operationArea.getProvinceId());
        dbOperationArea.setDltCharge(operationArea.getDltCharge());
        dbOperationArea.setWage(operationArea.getWage());
        dbOperationArea.setStatus(operationArea.getStatus());
        dbOperationArea.setUpdatedAt(new Date());
        dbOperationArea.setUpdatedUser("Socheat");
        boolean success = service.saveOperationArea(operationArea);
        if(success){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping(value = "/operationareas/{id}", produces = "application/json")
    public ResponseEntity<OperationArea> deleteOperation(@PathVariable("id") Long id) {
        OperationArea operationArea = service.findById(id);
        if(operationArea == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteOperationAreaById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
