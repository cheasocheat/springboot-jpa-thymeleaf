package com.glf.test.glftest.domain;

import com.glf.test.glftest.domain.base.BaseEntity;
import com.glf.test.glftest.util.RecordStatus;

import javax.persistence.*;
import java.util.Date;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 09:42
 */
@Entity(name = "tb_province")
public class Province extends BaseEntity{
    private String desc;

    public Province(){
        this.setCreatedUser("Socheat");
        this.setCreatedAt(new Date());
        this.setUpdatedUser("Socheat");
        this.setUpdatedAt(new Date());
        this.setStatus(RecordStatus.PUB);
    }

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
