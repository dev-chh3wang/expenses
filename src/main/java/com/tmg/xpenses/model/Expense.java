package com.tmg.xpenses.model;

import org.joda.money.BigMoney;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;
import java.time.YearMonth;

@Table(value = "expenses_by_user")
public class Expense {


    @PrimaryKey
    private Integer id;

    /**
     * expense description
     */
    private String description;

    private Integer userId;
    /**
     * expense amount
     */
    @CassandraType(type = CassandraType.Name.DOUBLE)
    private BigMoney amount;

    @CassandraType(type = CassandraType.Name.TIMESTAMP)
    private LocalDateTime timestamp;

    @CassandraType(type = CassandraType.Name.DATE)
    private YearMonth yearMonth;

    public Expense(String description, Integer userId, BigMoney amount, LocalDateTime timestamp) {
        this.description = description;
        this.userId = userId;
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

    public Integer getUserId() {
        return userId;
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
