package com.glf.test.glftest.domain;

import com.glf.test.glftest.domain.base.BaseEntity;

import javax.persistence.*;

/**
 * Developer : cheasocheat
 * Created on 2/27/18 11:01
 */
@Entity(name = "tb_receipt")
public class Receipt extends BaseEntity {
    private String code;
    private Operation operation;

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recpt_id")
    public Long getId() {
        return super.getId();
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
    }

    @Column(nullable = false, name = "recpt_code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @OneToOne
    @PrimaryKeyJoinColumn
    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
