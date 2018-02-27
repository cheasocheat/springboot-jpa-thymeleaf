package com.glf.test.glftest.service.impl;

import com.glf.test.glftest.domain.Province;
import com.glf.test.glftest.repository.ProvinceRepository;
import com.glf.test.glftest.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService{

    @Autowired
    private ProvinceRepository repository;

    @Override
    public List<Province> getListProvinces() {
        return repository.findAll();
    }

    @Override
    public boolean saveProvince(Province province) {
        repository.save(province);
        return province.getId() > 0 ? true : false;
    }
}
