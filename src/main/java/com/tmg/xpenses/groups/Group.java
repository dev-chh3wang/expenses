package com.tmg.xpenses.groups;

import com.tmg.xpenses.users.User;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tbl_group")
public class Group extends BaseEntity {


    private String name;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "group_users",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;

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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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
