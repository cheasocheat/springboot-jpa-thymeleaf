package com.glf.test.glftest.service;

import com.glf.test.glftest.domain.Receipt;

import java.util.List;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 14:50
 */
public interface ReceiptService {
    /**
     * getListReceipt
     * @return
     */
    List<Receipt> getListReceipt();

    /**
     * getListReceiptWithPagination
     * @param limit
     * @param offset
     * @return
     */
    List<Receipt> getListReceiptWithPagination(int limit, int offset);

    /**
     * saveReceipt
     * @param receipt
     */
    boolean saveReceipt(Receipt receipt);

    /**
     * FindById
     * @param id
     * @return
     */
    Receipt findById(Long id);

    /**
     * updateReceipt
     * @param receipt
     */
    void updateReceipt(Long id, Receipt receipt);


    /**
     * deleteReceipt
     * @param id
     */
    void deleteReceipt(Long id);
}
