package com.checkoutapi.springbootdocker.checkout.business;

import com.checkoutapi.springbootdocker.checkout.business.processor.CheckoutProcessor;
import com.checkoutapi.springbootdocker.checkout.business.processor.WatchNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckoutFacade
{
    @Autowired
    private CheckoutProcessor checkoutProcessor;

    public Integer getTotalOrderPrice(String[] watchIds) throws WatchNotFoundException {
        return checkoutProcessor.getTotalOrderPrice(watchIds);
    }
}
