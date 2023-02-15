package com.tmg.xpenses.users;


import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Table(value = "users_by_group")
public class User implements Serializable {

    @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.CLUSTERED)
    private Integer id;
    private String name;
    @PrimaryKeyColumn(name = "group_id",type = PrimaryKeyType.PARTITIONED)
    private Integer groupId;

    public User(Integer id, String name, Integer groupId) {
        this.id = id;
        this.name = name;
        this.groupId = groupId;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}
