package com.tmg.xpenses.users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



//@Entity(name = "user_groups")
/*public class UserGroup {


   *//* @Id
    @GeneratedValue(strategy = GenerationType.AUTO)*//*
    private Integer id;

    private Integer groupId;
    private Integer userId;
    private Boolean isAdmin;

    public UserGroup(Integer id, Integer groupId, Integer userId) {
        this.id = id;
        this.groupId = groupId;
        this.userId = userId;
        this.isAdmin = false;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}*/
