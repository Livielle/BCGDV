package com.checkoutapi.springbootdocker.checkout.business.watchvalidator;

import com.checkoutapi.springbootdocker.checkout.business.processor.WatchNotFoundException;
import com.checkoutapi.springbootdocker.orm.watches.Watch;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.stream.Stream;

@Component
public class WatchIdsValidator implements Validator
{
    public void validateWatchIds(String[] watchIds, Map<String, Watch> watches) throws WatchNotFoundException
    {
        String[] missingWatchIds = Stream.of(watchIds)
                .distinct()
                .filter(x->!watches.containsKey(x))
                .toArray(String[]::new);

        if(missingWatchIds.length > 0) {
            String message = String.format("Watch not found: %s", String.join(",", missingWatchIds));
            throw new WatchNotFoundException(message);
        }
    }
}
