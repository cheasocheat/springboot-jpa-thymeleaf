package com.glf.test.glftest.service;

import com.glf.test.glftest.domain.OperationArea;

import java.util.List;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 16:07
 */
public interface OperationAreaService {
    List<OperationArea> getListOperationAreas();
    List<OperationArea> getListOperationAreasByOperationId(Long operateId);
    boolean saveOperationArea(OperationArea operationArea);
    void deleteOperationAreaById(Long id);
    OperationArea findByProvinceId(Long id);
    OperationArea findById(Long id);
}
