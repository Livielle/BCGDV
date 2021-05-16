package com.checkoutapi.springbootdocker.checkout;

import com.checkoutapi.springbootdocker.checkout.business.CheckoutFacade;
import com.checkoutapi.springbootdocker.checkout.business.processor.WatchNotFoundException;
import com.checkoutapi.springbootdocker.checkout.responsecreator.CheckoutResponse;
import com.checkoutapi.springbootdocker.checkout.responsecreator.ResponseCreatorFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CheckoutController
{
    @Autowired
    CheckoutFacade checkoutFacade;

    @Autowired
    private ResponseCreatorFacade responseCreatorFacade;

    @PostMapping(path = "checkout", consumes = "application/json", produces = "application/json")
    public ResponseEntity<CheckoutResponse> checkout(@RequestBody String[] watchIds) throws WatchNotFoundException {
        Integer totalPrice = 0;
        if(watchIds.length == 0) {
            return responseCreatorFacade.getResponse(totalPrice);
        }

        try {
            totalPrice = checkoutFacade.getTotalOrderPrice(watchIds);
        }
        catch(Throwable ex)
        {
            return responseCreatorFacade.getBadRequestResponse(ex);
        }

        return responseCreatorFacade.getResponse(totalPrice);
    }
}
