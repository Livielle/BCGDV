package com.checkoutapi.springbootdocker.checkout.business.quantityperitemcalculator;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class QuantityPerItemCalculator implements QuantityCalculator
{
    public Map<String, Integer> calculate(String[] watchIds)
    {
        HashMap<String, Integer> watchIdToQuantity = new HashMap<>();
        for (String id : watchIds) {
            Integer quantity = 1;
            if(watchIdToQuantity.containsKey(id)) {
                quantity += watchIdToQuantity.get(id);
            }

            watchIdToQuantity.put(id, quantity);
        }

        return watchIdToQuantity;
    }
}
