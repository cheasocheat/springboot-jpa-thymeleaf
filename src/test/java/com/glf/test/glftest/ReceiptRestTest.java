package com.glf.test.glftest;

import com.glf.test.glftest.domain.Receipt;
import com.glf.test.glftest.service.ReceiptService;

import java.util.Date;
import java.util.List;

import com.glf.test.glftest.util.RecordStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 15:23
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReceiptRestTest {
    @Autowired
    private ReceiptService service;

    @Test
    public void getListOfReceipts() {
        List<Receipt> lstReceipts = service.getListReceipt();
        lstReceipts.forEach(System.out::println);
    }

    @Test
    public void saveReceipt() {
        for (int i = 1; i <= 9; i++) {
            Receipt receipt = new Receipt();
            receipt.setCode("RECEIPT00" + i);
            receipt.setCreatedUser("Socheat");
            receipt.setCreatedAt(new Date());
            receipt.setUpdatedUser("Socheat");
            receipt.setUpdatedAt(new Date());
            receipt.setStatus(RecordStatus.PUB);
            service.saveReceipt(receipt);
        }
    }
}
