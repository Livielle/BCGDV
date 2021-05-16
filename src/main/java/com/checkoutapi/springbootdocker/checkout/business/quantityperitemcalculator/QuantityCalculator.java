package com.checkoutapi.springbootdocker.checkout.business.quantityperitemcalculator;

import java.util.Map;

public interface QuantityCalculator
{
    public Map<String, Integer> calculate(String[] watchIds);
}
