package com.glf.test.glftest.webservice;

import com.glf.test.glftest.domain.Receipt;
import com.glf.test.glftest.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 11:36
 */
@RestController
@RequestMapping(value = "/api/v1")
public class ReceiptRestController {

    @Autowired
    private ReceiptService service;

    @GetMapping(value = "/receipts")
    public ResponseEntity<Receipt> getListReceipt() {
        List<Receipt> lstReceipts = service.getListReceipt();
        if (lstReceipts != null && !lstReceipts.isEmpty()) {
            return new ResponseEntity(lstReceipts, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    /*@GetMapping(value = "/receipts")
    public ResponseEntity<Receipt> getListReceiptPagination(@RequestParam("limit") int limit, @RequestParam("offset") int offset) {
        try {
            List<Receipt> lstReceipts = service.getListReceiptWithPagination(limit, offset);
            if (lstReceipts != null && !lstReceipts.isEmpty()) {
                return new ResponseEntity(lstReceipts, HttpStatus.OK);
            }
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }*/


    @GetMapping(value = "/receipts/{id}", produces = "application/json")
    public ResponseEntity<Receipt> getReceiptById(@PathVariable("id") Long id) {
        Receipt receipt = service.findById(id);
        if(receipt != null){
            return new ResponseEntity(receipt, HttpStatus.OK);
        }
        return new ResponseEntity(receipt, HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/receipts", produces = "application/json")
    public ResponseEntity<String> addReceipt(@RequestBody Receipt receipt) {
        Receipt dbReceipt  = service.findByCode(receipt.getCode());
        if(dbReceipt != null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        boolean success = service.saveReceipt(receipt);
        if (success) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping(value = "/receipts/{id}", produces = "application/json")
    public ResponseEntity<String> updateReceipt(@PathVariable("id") Long id, @RequestBody Receipt receipt) {
        Receipt dbReceipt = service.findById(id);
        if(dbReceipt == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        dbReceipt.setCode(receipt.getCode());
        dbReceipt.setStatus(receipt.getStatus());
        dbReceipt.setUpdatedAt(new Date());
        dbReceipt.setUpdatedUser("Socheat");
        boolean success = service.saveReceipt(receipt);
        if(success){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(value = "/receipts/{id}", produces = "application/json")
    public ResponseEntity<String> deleteReceipt(@PathVariable("id") Long id) {
        Receipt operationArea = service.findById(id);
        if(operationArea == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteReceipt(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
