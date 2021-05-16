package com.checkoutapi.springbootdocker.checkout.business.orderpricecalculation;

import com.checkoutapi.springbootdocker.orm.watches.Watch;

import java.util.Map;

public class WatchTestData
{
    public WatchTestData(Watch[] watches, Map<String, Integer> quantityPerWatchId, int expectedTotalPrice)
    {
        this.watches = watches;
        this.quantityPerWatchId = quantityPerWatchId;
        this.expectedTotalPrice = expectedTotalPrice;
    }

    Watch[] watches;
    Map<String, Integer> quantityPerWatchId;
    int expectedTotalPrice;

    public Watch[] getWatches() {
        return watches;
    }

    public Map<String, Integer> getQuantityPerWatchId() {
        return quantityPerWatchId;
    }

    public int getExpectedTotalPrice() {
        return expectedTotalPrice;
    }
}
