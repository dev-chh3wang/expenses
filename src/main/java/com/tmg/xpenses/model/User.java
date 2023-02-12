package com.tmg.xpenses.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "user_by_group")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;




/*
    public User(Integer id, String name, Group group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }*/



    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

 /*   public Group getGroup() {
        return group;
    }*/

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public void setGroup(Group group) {
        this.group = group;
    }*/
}
