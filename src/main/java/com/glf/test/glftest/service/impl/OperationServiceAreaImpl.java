package com.glf.test.glftest.service.impl;

import com.glf.test.glftest.domain.OperationArea;
import com.glf.test.glftest.repository.OperationAreaRepository;
import com.glf.test.glftest.service.OperationAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 16:07
 */
@Service
public class OperationServiceAreaImpl implements OperationAreaService {

    @Autowired
    private OperationAreaRepository repository;

    @Override
    public List<OperationArea> getListOperationAreas() {
        return repository.findAll();
    }

    @Override
    public List<OperationArea> getListOperationAreasByOperationId(Long operateId) {
        return repository.getListOperationAreasByOperationId(operateId);
    }

    @Override
    public boolean saveOperationArea(OperationArea operationArea) {
        repository.save(operationArea);
        return operationArea.getId() > 0 ? true : false;
    }


    @Override
    public void deleteOperationAreaById(Long id) {
        repository.delete(id);
    }

    @Override
    public OperationArea findByProvinceId(Long id) {
        return repository.findByProvinceId(id);
    }

    @Override
    public OperationArea findById(Long id) {
        return repository.findOne(id);
    }
}
