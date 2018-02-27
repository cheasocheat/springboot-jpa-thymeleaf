package com.glf.test.glftest.domain;

import com.glf.test.glftest.domain.base.BaseEntity;

import javax.persistence.*;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 10:54
 */
@Entity(name = "tb_operation_area")
public class OperationArea extends BaseEntity{
    private Long provinceId;
    private Double dtlChange;
    private Double dtlWage;
    private Operation operation;

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

    @Column(name = "op_prvin_id",nullable = false)
    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    @Column(name = "op_dtl_change")
    public Double getDtlChange() {
        return dtlChange;
    }

    public void setDtlChange(Double dtlChange) {
        this.dtlChange = dtlChange;
    }

    @Column(name = "op_dtl_wage")
    public Double getDtlWage() {
        return dtlWage;
    }

    public void setDtlWage(Double dtlWage) {
        this.dtlWage = dtlWage;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "op_id", nullable = false)
    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
