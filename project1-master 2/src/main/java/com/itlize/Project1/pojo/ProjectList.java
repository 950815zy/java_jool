package com.itlize.Project1.pojo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.GenericGenerator;

/**
 * Project
 */
@Entity
@Table(name = "projectlist")
public class ProjectList {
    @Id
    @GenericGenerator(name="asc_gen", strategy = "increment")
    @GeneratedValue(generator = "asc_gen")
    @Column(name = "pid")
    Integer pid;
    String project_name;
    Integer fid;

    public ProjectList(String project_name) {
        this.project_name = project_name;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "projectId", fetch = FetchType.LAZY)
    private Set<ResourcePool> resourceCode;

    

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getproject_name() {
        return project_name;
    }

    public void setproject_name(String project_name) {
        this.project_name = project_name;
    }


    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public ProjectList(Integer pid, String project_name, Integer fid) {
        this.pid = pid;
        this.project_name = project_name;
        this.fid = fid;
    }

    public ProjectList(Integer pid, String project_name) {
        this.pid = pid;
        this.project_name = project_name;
    }

    public ProjectList(ProjectList projectlist) {
        this.fid=projectlist.getFid();
        this.pid=projectlist.getPid();
        this.project_name=projectlist.getproject_name();
    }

    public ProjectList() {
    }

    @Override
    public String toString() {
        return "ProjectList [fid=" + fid + ", pid=" + pid + ", project_name=" + project_name + ", resourceCode="
                + resourceCode + "]";
    }

    public Set<ResourcePool> getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(Set<ResourcePool> resourceCode) {
        this.resourceCode = resourceCode;
    }
    
}
