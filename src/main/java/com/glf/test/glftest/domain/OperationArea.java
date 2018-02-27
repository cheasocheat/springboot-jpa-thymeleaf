package com.glf.test.glftest.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.glf.test.glftest.domain.base.BaseEntity;
import com.glf.test.glftest.util.RecordStatus;
import groovy.transform.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 10:54
 */
@Entity(name = "tb_operation_area")
public class OperationArea extends BaseEntity {
    private Long provinceId;
    private Double dltCharge;
    private Double wage;
    private Operation operation;

    public OperationArea(){
        this.setCreatedUser("Socheat");
        this.setCreatedAt(new Date());
        this.setUpdatedUser("Socheat");
        this.setUpdatedAt(new Date());
        this.setStatus(RecordStatus.PUB);
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "op_area_id")
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Column(name = "op_prvin_id", nullable = false)
    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }


    @Column(name = "op_dlt_charge", nullable = false)
    public Double getDltCharge() {
        return dltCharge;
    }

    public void setDltCharge(Double dltCharge) {
        this.dltCharge = dltCharge;
    }


    @Column(name = "op_wage")
    public Double getWage() {
        return wage;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "op_id")
    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
