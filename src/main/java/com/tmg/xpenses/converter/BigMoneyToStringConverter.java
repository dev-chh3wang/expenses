package com.tmg.xpenses.converter;

import org.joda.money.BigMoney;
import org.springframework.core.convert.converter.Converter;

public class BigMoneyToStringConverter implements Converter<BigMoney,Double> {

    @Override
    public Double convert(BigMoney source) {
        return source.toMoney().getAmount().doubleValue();
    }
}
