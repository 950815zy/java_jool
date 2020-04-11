package com.itlize.Project1.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * newColumnName
 */
@Entity
@Table(name = "newcolumnname")
public class NewColumnName {
    @Id
    @GenericGenerator(name="asc_gen", strategy = "increment")
    @GeneratedValue(generator = "asc_gen")
    @Column(name = "cid")
    Integer cid;

    @Column(name = "column_name")
    String column_name;

    public NewColumnName(String column_name) {
        this.column_name = column_name;
    }

    @Override
    public String toString() {
        return "newColumnName [cid=" + cid + ", column_name=" + column_name + "]";
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
    public String getColumn_name() {
        return column_name;
    }

    public void setColumn_name(String column_name) {
        this.column_name = column_name;
    }

    public NewColumnName(){}
    
}
