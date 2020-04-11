package com.itlize.Project1.pojo;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
/**
 * ResourcePool
 */
@Entity
@Table(name = "resourcepool")
public class ResourcePool {
	
    @Id
    @Column(name = "cost_code",nullable = false)
    String cost_code;
    
    @Column(name = "name", nullable = false)
	String name;
	
	// @OneToMany(fetch = FetchType.EAGER)
	// Set<NewColumnValue> colvals;
	
	@JsonBackReference
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "resourcecast", joinColumns = {@JoinColumn(name = "cost_code")},
    inverseJoinColumns = {@JoinColumn(name = "pid")})
    private Set<ProjectList> projectId;

    //This constructor is for insert new resource purpose
    
    public ResourcePool(String cost_code, String name) {
        this.cost_code = cost_code;
		this.name = name;
    }
    
    //Empty Constructor
    
    public ResourcePool(){
    }
    // Auto generate getter and setter based on the field
    
	public String getCost_code() {
		return cost_code;
	}
	public void setCost_code(String cost_code) {
		this.cost_code = cost_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// Generate toString() for display
	
	// public Set<NewColumnValue> getColvals() {
	// 	return colvals;
	// }

	// public void setColvals(Set<NewColumnValue> colvals) {
	// 	this.colvals = colvals;
	// }

	public Set<ProjectList> getProjectId() {
		return projectId;
	}

	public void setProjectId(Set<ProjectList> projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "ResourcePool [cost_code=" + cost_code + ", name=" + name + ", projectId="
				+ projectId + "]";
	}

	
}