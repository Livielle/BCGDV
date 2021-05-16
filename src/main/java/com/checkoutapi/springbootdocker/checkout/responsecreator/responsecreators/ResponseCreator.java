package com.checkoutapi.springbootdocker.checkout.responsecreator.responsecreators;

import com.checkoutapi.springbootdocker.checkout.responsecreator.CheckoutResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseCreator implements ResponseGenerator
{
    public ResponseEntity<CheckoutResponse> getResponse(Integer totalPrice)
    {
        CheckoutResponse checkoutResponse = new CheckoutResponse();
        checkoutResponse.setPrice(totalPrice);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");

        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(checkoutResponse);
    }
}
