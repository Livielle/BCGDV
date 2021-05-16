package com.checkoutapi.springbootdocker.checkout.business.watchvalidator;

import com.checkoutapi.springbootdocker.checkout.business.processor.WatchNotFoundException;
import com.checkoutapi.springbootdocker.orm.watches.Watch;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WatchIdsValidatorTests
{
    @Test
    void validate_exception_thrown()
    {
        String[] watchIds = {"001", "002", "001"};

        Watch watch = new Watch();
        watch.setWatchId("001");

        Map<String, Watch> watches = new HashMap<>() {{
            put("001", watch);
        }};

        assertThrows(WatchNotFoundException.class, () -> {
            WatchIdsValidatorImpl watchIdsValidator = new WatchIdsValidatorImpl();
            watchIdsValidator.validateWatchIds(watchIds, watches);
        });
    }

    @Test
    void validate_exception_not_thrown()
    {
        String[] watchIds = {"001", "002", "001"};

        Watch watch1 = new Watch();
        watch1.setWatchId("001");

        Watch watch2 = new Watch();
        watch2.setWatchId("002");

        Map<String, Watch> watches = new HashMap<>() {{
            put("001", watch1);
            put("002", watch2);
        }};

        assertDoesNotThrow(() -> {
            WatchIdsValidatorImpl watchIdsValidator = new WatchIdsValidatorImpl();
            watchIdsValidator.validateWatchIds(watchIds, watches);
        });
    }
}
