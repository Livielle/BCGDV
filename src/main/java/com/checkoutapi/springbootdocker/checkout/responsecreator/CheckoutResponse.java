package com.checkoutapi.springbootdocker.checkout.responsecreator;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CheckoutResponse
{
    Integer price;
    String errorMessage;
}
