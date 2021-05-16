package com.checkoutapi.springbootdocker.checkout.business.orderpricecalculation;

import com.checkoutapi.springbootdocker.orm.watches.Watch;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OrderPriceCalculatorImpl implements PriceCalculator
{
    public Integer getOrderTotalPrice(Map<String, Watch> watchIdToWatchData, Map<String, Integer> watchIdToOrderedQuantity)
    {
        Integer totalOrderPrice = 0;
        for (Map.Entry<String, Integer> entry : watchIdToOrderedQuantity.entrySet()) {
            String watchId = entry.getKey();
            Integer orderedQuantity = entry.getValue();

            if(!watchIdToWatchData.containsKey(watchId)) {
                continue;
            }

            Watch watch = watchIdToWatchData.get(watchId);

            Integer totalUnitPrice = 0;
            if(!isDiscountApplicable(orderedQuantity, watch)) {
                totalUnitPrice = calculatePriceNoDiscountApplicable(orderedQuantity, watch);
                totalOrderPrice += totalUnitPrice;
                continue;
            }

            totalUnitPrice = calculatePriceDiscountApplicable(orderedQuantity, watchIdToWatchData.get(watchId));

            totalOrderPrice += totalUnitPrice;
        }

        return totalOrderPrice;
    }

    private boolean isDiscountApplicable(Integer orderedQuantity, Watch watch)
    {
        Integer quantityForDiscount = watch.getQuantityForDiscount();
        return (quantityForDiscount != null && quantityForDiscount != 0 && orderedQuantity >= quantityForDiscount);
    }

    private Integer calculatePriceNoDiscountApplicable(Integer orderedQuantity, Watch watch)
    {
        return orderedQuantity * watch.getUnitPrice();
    }

    private Integer calculatePriceDiscountApplicable(Integer orderedQuantity, Watch watch)
    {
        Integer timesToApplyDiscount = orderedQuantity / watch.getQuantityForDiscount();

        Integer currentDiscountPrice = calculatePriceForItemsWithDiscount(timesToApplyDiscount, watch.getDiscountPrice());
        Integer currentRemainPrice = calculatePriceForItemsWithoutDiscount(orderedQuantity, timesToApplyDiscount, watch);

        return currentDiscountPrice + currentRemainPrice;
    }

    private Integer calculatePriceForItemsWithDiscount(Integer timesToApplyDiscount, Integer discountPrice)
    {
        return timesToApplyDiscount * discountPrice;
    }

    private Integer calculatePriceForItemsWithoutDiscount(Integer orderedQuantity, Integer timesToApplyDiscount, Watch watch)
    {
        Integer discountedItems = timesToApplyDiscount * watch.getQuantityForDiscount();
        Integer itemsWithoutDiscount = orderedQuantity - discountedItems;
        return itemsWithoutDiscount * watch.getUnitPrice();
    }
}
