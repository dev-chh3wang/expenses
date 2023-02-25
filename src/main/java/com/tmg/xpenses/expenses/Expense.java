package com.tmg.xpenses.expenses;

import com.tmg.xpenses.converter.BigMoneyToStringConverter;
import com.tmg.xpenses.groups.Group;
import com.tmg.xpenses.users.User;
import jakarta.persistence.*;
import org.joda.money.BigMoney;

import java.time.LocalDateTime;

@Table(name = "expenses")
@Entity
public class Expense {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Group group;
    /**
     * expense description
     */
    private String description;

    /**
     * expense amount
     */
    @Convert(converter = BigMoneyToStringConverter.class)
    private BigMoney amount;


    private LocalDateTime timestamp;


    public Expense() {
    }

    public Expense(Integer id, String description, User userId, BigMoney amount, LocalDateTime timestamp) {
        this.description = description;
        this.id = id;
        this.user = userId;
        this.amount = amount;
        this.timestamp = timestamp;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setAmount(BigMoney amount) {
        this.amount = amount;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }


    public BigMoney getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
