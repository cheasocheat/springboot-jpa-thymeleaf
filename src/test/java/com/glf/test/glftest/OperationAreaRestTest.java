package com.glf.test.glftest;

import com.glf.test.glftest.domain.Operation;
import com.glf.test.glftest.domain.OperationArea;
import com.glf.test.glftest.service.OperationAreaService;
import com.glf.test.glftest.service.OperationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperationAreaRestTest {

    @Autowired
    private OperationAreaService service;

    @Autowired
    private OperationService operationService;

    @Test
    public void addOperationAreas(){
        for (int i = 1; i <= 9; i++) {
            OperationArea operationArea = new OperationArea();
            operationArea.setProvinceId(70l);
            operationArea.setWage(9.0);
            operationArea.setDltCharge(9.0);
            operationArea.setOperation(operationService.findById(101l));
            service.saveOperationArea(operationArea);
        }
    }

    @Test
    public void getListOperationAreas(){
       List<OperationArea> operationAreaList = service.getListOperationAreas();
       operationAreaList.forEach(element -> System.out.println(element.getOperation().getCode()));
    }
}
