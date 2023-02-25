package com.tmg.xpenses.groups;


import com.tmg.xpenses.users.User;

import java.io.Serializable;

/**
 * Composite key , important to make it Serializable
 */
public class UserGroupId implements Serializable {


    private User user;
    private Group group;


    public UserGroupId() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
