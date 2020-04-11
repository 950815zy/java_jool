package com.itlize.Project1.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.annotations.GenericGenerator;

/**
 * FormulaList
 */
@Entity
@Table(name = "formulalist")
public class FormulaList {
    @Id
    @GenericGenerator(name="asc_gen", strategy = "increment")
    @GeneratedValue(generator = "asc_gen")
    @Column(name = "fid")
    Integer fid;

    @Column(name = "formula_name")
    String formula_name;

    @Column(name = "description") 
    String description;

    public FormulaList(String formula_name) {
        this.formula_name = formula_name;
    }

    @Override
    public String toString() {
        return "FormulaList [description=" + description + ", fid=" + fid + ", formula_name=" + formula_name + "]";
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getformula_name() {
        return formula_name;
    }

    public void setformula_name(String formula_name) {
        this.formula_name = formula_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public FormulaList(){}
}
