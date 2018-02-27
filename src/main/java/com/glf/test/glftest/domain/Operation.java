package com.glf.test.glftest.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.glf.test.glftest.domain.base.BaseEntity;
import com.glf.test.glftest.util.RecordStatus;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.List;
import java.util.Set;

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
    private Double defDltCharge;
    private Double defWage;
    private Long receiptId;
    private Set<OperationArea> operationAreas;

    public Operation(){
        this.setCreatedUser("Socheat");
        this.setUpdatedUser("Socheat");
        this.setCreatedAt(new Date());
        this.setUpdatedAt(new Date());
        this.setStatus(RecordStatus.PUB);
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "op_id", nullable = false , unique = true)
    @Value("#{target.id}")
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


    @Column(name = "def_dlt_charge", nullable = false)
    public Double getDefDltCharge() {
        return defDltCharge;
    }

    public void setDefDltCharge(Double defDltCharge) {
        this.defDltCharge = defDltCharge;
    }


    @Column(name = "def_wage", nullable = false)
    public Double getDefWage() {
        return defWage;
    }

    public void setDefWage(Double defWage) {
        this.defWage = defWage;
    }

    @Column(name = "receipt_id")
    public Long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Long receiptId) {
        this.receiptId = receiptId;
    }

    @OneToMany(fetch = FetchType.LAZY, targetEntity = OperationArea.class, mappedBy = "operation", cascade = CascadeType.ALL)
    public Set<OperationArea> getOperationAreas() {
        return operationAreas;
    }

    public void setOperationAreas(Set<OperationArea> operationAreas) {
        this.operationAreas = operationAreas;
    }
}
