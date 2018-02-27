package com.glf.test.glftest;


import com.glf.test.glftest.domain.Province;
import com.glf.test.glftest.service.ProvinceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProvinceRestTest {

    @Autowired
    private ProvinceService service;

    @Test
    public void saveProvince() {
        for (int i = 1; i <= 9; i++) {
            Province province = new Province();
            province.setDesc("Province "+i);
            service.saveProvince(province);
        }
    }
}
