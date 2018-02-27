package com.glf.test.glftest.service;

import com.glf.test.glftest.domain.Receipt;

import java.util.List;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 14:50
 */
public interface ReceiptService {
    List<Receipt> getListReceipt();
    boolean saveReceipt(Receipt receipt);
    Receipt findById(Long id);
    Receipt findByCode(String code);
    void deleteReceipt(Long id);
    List<Receipt> getListReceiptWithPagination(int limit, int offset);
}
