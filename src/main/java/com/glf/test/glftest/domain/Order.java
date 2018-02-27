package com.glf.test.glftest.domain;

import com.glf.test.glftest.domain.base.BaseEntity;
import com.glf.test.glftest.util.RecordStatus;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "tb_order")
public class Order extends BaseEntity{
    private Double amount;
    private Double totalAmount;
    private Boolean taxExtension;
    private Long operationId;

    public Order(){
        this.taxExtension = false;
        this.setCreatedUser("Socheat");
        this.setCreatedAt(new Date());
        this.setUpdatedUser("Socheat");
        this.setUpdatedAt(new Date());
        this.setStatus(RecordStatus.PUB);
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ord_id")
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Column(name = "amount")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Column(name = "total_amount")
    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Column(name = "tax_extension")
    public Boolean getTaxExtension() {
        return taxExtension;
    }

    public void setTaxExtension(Boolean taxExtension) {
        this.taxExtension = taxExtension;
    }

    @Column(name = "opera_id")
    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }
}
