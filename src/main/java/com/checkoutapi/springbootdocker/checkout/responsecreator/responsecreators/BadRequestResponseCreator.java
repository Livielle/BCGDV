package com.checkoutapi.springbootdocker.checkout.responsecreator.responsecreators;

import com.checkoutapi.springbootdocker.checkout.responsecreator.CheckoutResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class BadRequestResponseCreator implements ResponseGenerator
{
    public ResponseEntity<CheckoutResponse> getResponse(Throwable exception)
    {
        CheckoutResponse checkoutResponse = new CheckoutResponse();
        checkoutResponse.setErrorMessage(exception.getMessage());

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");

        return ResponseEntity.badRequest()
                .headers(responseHeaders)
                .body(checkoutResponse);
    }
}
