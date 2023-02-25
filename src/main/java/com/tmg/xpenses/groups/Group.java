package com.tmg.xpenses.groups;

import com.tmg.xpenses.users.User;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tbl_group")
public class Group extends BaseEntity {


    private String name;

    @ManyToOne
    private User createdBy;

    public Group() {
    }


    public Group(Long id, String name, User createdBy){
        this.name = name;
        setId(id);
        this.createdBy = createdBy;
    }

    public static Group of(Long id, String name,User createdBy) {
        return new Group(id,name,createdBy);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return getId() != null && getId().equals(group.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }
}
