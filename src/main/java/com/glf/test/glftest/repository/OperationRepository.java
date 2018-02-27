package com.glf.test.glftest.repository;

import com.glf.test.glftest.domain.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
    Operation findByCode(String code);
}
