package com.checkoutapi.springbootdocker.checkout.business.processor;

public interface CheckoutProcessor
{
    public Integer getTotalOrderPrice(String[] watchIds) throws WatchNotFoundException;
}
