package com.checkoutapi.springbootdocker.checkout.business.processor;

import com.checkoutapi.springbootdocker.checkout.business.orderpricecalculation.PriceCalculator;
import com.checkoutapi.springbootdocker.checkout.business.quantityperitemcalculator.QuantityCalculator;
import com.checkoutapi.springbootdocker.checkout.business.repositoryreader.Reader;
import com.checkoutapi.springbootdocker.checkout.business.watchvalidator.Validator;
import com.checkoutapi.springbootdocker.orm.watches.Watch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class CheckoutProcessorImpl implements CheckoutProcessor
{
    @Autowired
    private Reader<Watch> watchesReader;

    @Autowired
    private QuantityCalculator quantityPerItemCalculator;

    @Autowired
    private PriceCalculator orderPriceCalculator;

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
