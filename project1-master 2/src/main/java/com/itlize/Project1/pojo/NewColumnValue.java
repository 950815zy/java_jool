package com.itlize.Project1.pojo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import org.hibernate.annotations.CascadeType;
import javax.persistence.JoinColumn;  
import javax.persistence.ManyToOne; 
/**
 * newColumnValue
 */
@Entity
@Table(name = "newcolumnvalue")
public class NewColumnValue implements Serializable {
    
	@Id
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cid", referencedColumnName="cid")
    private NewColumnName name;


    @Column(name = "column_value")
    private String column_value;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cost_code",referencedColumnName = "cost_code")
    private ResourcePool pool;
    

    public ResourcePool getPool() {
		return pool;
	}


	public void setPool(ResourcePool pool) {
		this.pool = pool;
	}


	public NewColumnName getName() {
		return name;
	}


	public void setName(NewColumnName name) {
		this.name = name;
	}


//	public NewColumnValue(String column_value, String cost_code) {
//    	
//        this.column_value = column_value;
//        this.cost_code = cost_code;
//    
//    }

//
//    public Integer getCid() {
//        return cid;
//    }
//
//    public void setCid(Integer cid) {
//        this.cid = cid;
//    }

    public String getColumn_value() {
        return column_value;
    }
//
//    public String getCost_code() {
//		return cost_code;
//	}
//
//
//	public void setCost_code(String cost_code) {
//		this.cost_code = cost_code;
//	}


	public void setColumn_value(String column_value) {
        this.column_value = column_value;
    }

//   @Override
//    public String toString() {
//        return "NewColumnValue [cid=" + cid + ", column_value=" + column_value + ", cost_code=" + cost_code + "]";
//    }

    public NewColumnValue(){}
    
}

