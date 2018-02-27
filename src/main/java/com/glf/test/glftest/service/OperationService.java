package com.glf.test.glftest.service;

import com.glf.test.glftest.domain.Operation;

import java.util.List;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 14:42
 */
public interface OperationService {
    List<Operation> getListOperation();
    boolean saveOperation(Operation operation);
    void deleteOperationById(Long id);
    Operation findById(Long id);
    Operation findByCode(String code);
}
