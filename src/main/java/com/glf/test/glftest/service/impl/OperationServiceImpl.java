package com.glf.test.glftest.service.impl;

import com.glf.test.glftest.domain.Operation;
import com.glf.test.glftest.repository.OperationRepository;
import com.glf.test.glftest.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 14:43
 */
@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepository repository;

    @Override
    public List<Operation> getListOperation() {
        return repository.findAll();
    }

    @Override
    public boolean saveOperation(Operation operation) {
        repository.save(operation);
        return operation.getId() > 0 ? true : false;
    }

    @Override
    public void deleteOperationById(Long id) {
        repository.delete(id);
    }

    @Override
    public Operation findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Operation findByCode(String code) {
        return repository.findByCode(code);
    }
}
