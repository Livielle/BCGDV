package com.checkoutapi.springbootdocker.checkout.business.watchvalidator;

import com.checkoutapi.springbootdocker.checkout.business.processor.WatchNotFoundException;
import com.checkoutapi.springbootdocker.orm.watches.Watch;

import java.util.Map;

public interface Validator
{
    public void validateWatchIds(String[] watchIds, Map<String, Watch> watches) throws WatchNotFoundException;
}
