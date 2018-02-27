package com.glf.test.glftest.domain;

import com.glf.test.glftest.domain.base.BaseEntity;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 09:42
 */
@Entity(name = "tb_operation")
public class Operation extends BaseEntity{
    private String code;
    private String desc;
    private Double price;
    private Double defDtlChange;
    private double defDtlWage;
    private Receipt receipt;
    private List<OperationArea> lstOpeAreas;

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "op_id", nullable = false , unique = true)
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Column(name = "op_code", nullable = false, unique = true)
    @Size(max = 200)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "op_desc", nullable = false)
    @Size(max = 255)
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Column(name = "op_price", nullable = false)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Column(name = "def_dtl_change", nullable = false)
    public Double getDefDtlChange() {
        return defDtlChange;
    }

    public void setDefDtlChange(Double defDtlChange) {
        this.defDtlChange = defDtlChange;
    }

    @Column(name = "def_dtl_wage", nullable = false)
    public double getDefDtlWage() {
        return defDtlWage;
    }

    public void setDefDtlWage(double defDtlWage) {
        this.defDtlWage = defDtlWage;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "operation")
    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "operation")
    public List<OperationArea> getLstOpeAreas() {
        return lstOpeAreas;
    }

    public void setLstOpeAreas(List<OperationArea> lstOpeAreas) {
        this.lstOpeAreas = lstOpeAreas;
    }
}
