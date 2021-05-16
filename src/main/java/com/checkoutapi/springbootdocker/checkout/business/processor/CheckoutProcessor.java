package com.checkoutapi.springbootdocker.checkout.business.processor;

import com.checkoutapi.springbootdocker.checkout.business.orderpricecalculation.OrderPriceCalculator;
import com.checkoutapi.springbootdocker.checkout.business.quantityperitemcalculator.QuantityPerItemCalculator;
import com.checkoutapi.springbootdocker.checkout.business.repositoryreader.WatchesReader;
import com.checkoutapi.springbootdocker.checkout.business.watchvalidator.Validator;
import com.checkoutapi.springbootdocker.orm.watches.Watch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class CheckoutProcessor
{
    @Autowired
    private WatchesReader watchesReader;

    @Autowired
    private QuantityPerItemCalculator quantityPerItemCalculator;

    @Autowired
    private OrderPriceCalculator orderPriceCalculator;

    @Autowired
    Validator validator;

    public Integer getTotalOrderPrice(String[] watchIds) throws WatchNotFoundException {
        if(watchIds.length == 0) {
            return 0;
        }

        Map<String, Watch> watches = watchesReader.find(watchIds);
        validator.validateWatchIds(watchIds, watches);
        Map<String, Integer> watchIdToQuantity = quantityPerItemCalculator.calculate(watchIds);

        return orderPriceCalculator.getOrderTotalPrice(watches, watchIdToQuantity);
    }

}
