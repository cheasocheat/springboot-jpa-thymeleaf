package com.glf.test.glftest.service;

import com.glf.test.glftest.domain.Province;

import java.util.List;

public interface ProvinceService {
    /**
     *
     * @return
     */
    List<Province> getListProvinces();

    /**
     * saveProvince
     * @param province
     * @return
     */
    boolean saveProvince(Province province);
}
