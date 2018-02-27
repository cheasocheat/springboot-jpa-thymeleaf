package com.glf.test.glftest.repository;

import com.glf.test.glftest.domain.OperationArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationAreaRepository extends JpaRepository<OperationArea, Long>{
    OperationArea findByProvinceId(Long provinceId);
    List<OperationArea> getListOperationAreasByOperationId(Long operation);
}
