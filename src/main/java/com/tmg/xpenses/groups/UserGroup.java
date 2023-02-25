package com.tmg.xpenses.groups;

import com.tmg.xpenses.users.User;
import jakarta.persistence.*;

/**
 *
 *  association table joining Many-to-one User Group, Many-to-One Group-User using composite key
 * with the use of @IdClass , @MapsId
 *
 *
 */
@Entity
@Table(name = "user_groups")
@IdClass(UserGroupId.class)
public class UserGroup {


    @ManyToOne
    @Id
    private User user;

    @ManyToOne
    @Id
    private Group group;

    private Boolean isAdmin;

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

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}
