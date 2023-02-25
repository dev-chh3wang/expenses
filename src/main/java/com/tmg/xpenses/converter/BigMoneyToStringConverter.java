package com.tmg.xpenses.converter;

import jakarta.persistence.AttributeConverter;
import org.joda.money.BigMoney;
import org.joda.money.CurrencyUnit;

import java.math.BigDecimal;

public class BigMoneyToStringConverter implements AttributeConverter<BigMoney, BigDecimal> {

    @Override
    public BigDecimal convertToDatabaseColumn(BigMoney bigMoney) {
        return bigMoney.getAmount();
    }

    @Override
    public BigMoney convertToEntityAttribute(BigDecimal bigDecimal) {
        return BigMoney.of(CurrencyUnit.EUR,bigDecimal);
    }
}
