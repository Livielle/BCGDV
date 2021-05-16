package com.checkoutapi.springbootdocker.checkout.business.orderpricecalculation;

import com.checkoutapi.springbootdocker.orm.watches.Watch;

import java.util.Map;

public interface PriceCalculator
{
    public Integer getOrderTotalPrice(Map<String, Watch> watchIdToWatchData, Map<String, Integer> watchIdToQuantity);
}
