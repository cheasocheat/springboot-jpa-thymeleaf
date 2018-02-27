package com.glf.test.glftest.domain;

import com.glf.test.glftest.domain.base.BaseEntity;

import javax.persistence.*;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 09:42
 */
@Entity(name = "tb_province")
public class Province extends BaseEntity{
    private String desc;

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prvin_id", nullable = false, unique = true)
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Column(name = "prvin_desc", nullable = false)
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
