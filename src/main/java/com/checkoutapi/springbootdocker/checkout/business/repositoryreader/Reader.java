package com.checkoutapi.springbootdocker.checkout.business.repositoryreader;

import java.util.Map;

public interface Reader<T>
{
    Map<String, T> find(String[] ids);
}
