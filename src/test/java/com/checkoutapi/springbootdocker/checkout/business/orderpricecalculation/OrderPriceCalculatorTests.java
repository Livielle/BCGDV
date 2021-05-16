package com.checkoutapi.springbootdocker.checkout.business.orderpricecalculation;

import com.checkoutapi.springbootdocker.orm.watches.Watch;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderPriceCalculatorTests
{
    @ParameterizedTest
    @ArgumentsSource(WatchProvider.class)
    void priceCalculation(WatchTestData watchTestData)
    {
        HashMap<String, Watch> watchIdToWatchData = new HashMap<>();
        for(Watch watch : watchTestData.getWatches()) {
            watchIdToWatchData.put(watch.getWatchId(), watch);
        }

        Map<String, Integer> watchIdToOrderedQuantity = watchTestData.getQuantityPerWatchId();

        OrderPriceCalculatorImpl orderPriceCalculator = new OrderPriceCalculatorImpl();
        Integer price = orderPriceCalculator.getOrderTotalPrice(watchIdToWatchData, watchIdToOrderedQuantity);
        assertEquals(watchTestData.getExpectedTotalPrice(), price);
    }
}
