package com.glf.test.glftest;

import com.glf.test.glftest.domain.Operation;
import com.glf.test.glftest.service.OperationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperationRestTest {

    @Autowired
    private OperationService service;

    @Test
    public void findOperationById() {
        Operation operation = service.findById(90l);
        System.out.println(operation.toString());
    }

    @Test
    public void deleteOperationById() {
        service.deleteOperationById(101l);
    }

    @Test
    public void findOperationByCode() {
        Operation operation = service.findByCode("code");
        System.out.println(">>>> " + operation.getId());
    }

    @Test
    public void findAllOperation() {
        List<Operation> lstOperations = service.getListOperation();
        lstOperations.forEach(element -> System.out.println(element.getId() + " == " + element.getDesc()));
    }
}
