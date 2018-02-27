package com.glf.test.glftest.webservice;

import com.glf.test.glftest.domain.Receipt;
import com.glf.test.glftest.service.ReceiptService;
import com.glf.test.glftest.webservice.configuration.RestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 11:36
 */
@RestController
@RequestMapping(value = RestConfig.REST_URL + RestConfig.REST_RECEIPT)
public class ReceiptRestController {

    @Autowired
    private ReceiptService service;

    @GetMapping(value = {"", "/"})
    public String getRest() {
        return "Hello RECEIPT!";
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Receipt> getListReceipt() {
        try {
            List<Receipt> lstReceipts = service.getListReceipt();
            if (lstReceipts != null && !lstReceipts.isEmpty()) {
                return new ResponseEntity(lstReceipts, HttpStatus.OK);
            }
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }


    @GetMapping(value = "/list_receipt")
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
    }


    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Receipt> getReceiptById(@PathVariable("id") Long id) {
        try {
            Receipt receipt = service.findById(id);
            return new ResponseEntity(receipt, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(value = "/add", produces = "application/json")
    public ResponseEntity<String> addReceipt(@RequestBody Receipt receipt) {
        try {
            if (receipt != null) {
                boolean success = service.saveReceipt(receipt);
                if (success) {
                    return ResponseEntity.ok().body("Receipt added successfully");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.badRequest().build();
    }


    @PostMapping(value = "/update/{id}", produces = "application/json")
    public ResponseEntity<String> updateReceipt(@PathVariable("id") Long id, @RequestBody Receipt receipt) {
        try {
            if (id != null && id > 0 && receipt != null) {
                service.updateReceipt(id, receipt);
                ResponseEntity.ok().body("Receipt update successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping(value = "/delete/{id}", produces = "application/json")
    public ResponseEntity<String> deleteReceipt(@PathVariable("id") Long id) {
        try {
            if (id != null && id > 0) {
                service.deleteReceipt(id);
                ResponseEntity.ok().body("Receipt deleted successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
