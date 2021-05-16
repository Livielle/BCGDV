package com.checkoutapi.springbootdocker.checkout.responsecreator;

import com.checkoutapi.springbootdocker.checkout.responsecreator.responsecreators.BadRequestResponseCreatorImpl;
import com.checkoutapi.springbootdocker.checkout.responsecreator.responsecreators.ResponseCreatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseCreatorFacade
{
    @Autowired
    private ResponseCreatorImpl responseCreator;

    @Autowired
    private BadRequestResponseCreatorImpl badRequestResponseCreator;

    public ResponseEntity<CheckoutResponse> getResponse(Integer totalPrice)
    {
        return responseCreator.getResponse(totalPrice);
    }

    public ResponseEntity<CheckoutResponse> getBadRequestResponse(Throwable exception)
    {
        return badRequestResponseCreator.getResponse(exception);
    }
}
