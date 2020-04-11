package com.itlize.Project1.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * User
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GenericGenerator(name="asc_gen", strategy = "increment")
    @GeneratedValue(generator = "asc_gen")
    // @Column(name = "id")
    Integer id;
    
    // @Column(name = "uname", nullable = false)
    String uname;

    // @Column(name = "pass", nullable = false)
    String pass;

    // @Column(name = "register_date", nullable = true)
    String register_date;

    public User(){}

    public User(String uname, String pass) {
        this.uname=uname;
        this.pass=pass;
    }

    public User(String uname, String pass, Integer id) {
        this.uname = uname;
        this.pass = pass;
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getregister_date() {
        return register_date;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", pass=" + pass + ", register_date=" + register_date + ", uname=" + uname + "]";
    }

}