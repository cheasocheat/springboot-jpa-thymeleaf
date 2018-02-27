package com.glf.test.glftest.service.impl;

import com.glf.test.glftest.domain.Receipt;
import com.glf.test.glftest.repository.ReceiptRepository;
import com.glf.test.glftest.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 14:50
 */
@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    private ReceiptRepository repository;


    @Override
    public List<Receipt> getListReceipt() {
        return repository.findAll();
    }

    @Override
    public List<Receipt> getListReceiptWithPagination(int limit, int offset) {
        return repository.getListReceiptWithPagination(limit, offset);
    }

    @Override
    public boolean saveReceipt(Receipt receipt) {
        repository.save(receipt);
        return receipt.getId() > 0 ? true : false;
    }

    @Override
    public Receipt findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Receipt findByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public void deleteReceipt(Long id) {
        repository.delete(id);
    }
}
