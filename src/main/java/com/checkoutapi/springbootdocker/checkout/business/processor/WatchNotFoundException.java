package com.checkoutapi.springbootdocker.checkout.business.processor;

public class WatchNotFoundException extends Throwable {
    public WatchNotFoundException(String message) {
        super(message);
    }
}
