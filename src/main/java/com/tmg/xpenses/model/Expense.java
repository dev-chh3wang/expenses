package com.tmg.xpenses.model;

import org.joda.money.BigMoney;

import java.time.LocalDateTime;
import java.time.YearMonth;

public class Expense {

    private Integer id;

    /**
     * expense description
     */
    private String description;
    private User user;
    /**
     * expense amount
     */
    private BigMoney amount;

    private LocalDateTime timestamp;
    private YearMonth yearMonth;

    public Expense(String description, User user, BigMoney amount, LocalDateTime timestamp) {
        this.description = description;
        this.user = user;
        this.amount = amount;
        this.timestamp = timestamp;
        this.yearMonth = YearMonth.of(this.timestamp.getYear(),this.timestamp.getMonth());
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public User getUser() {
        return user;
    }

    public BigMoney getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public YearMonth getYearMonth() {
        return yearMonth;
    }
}
