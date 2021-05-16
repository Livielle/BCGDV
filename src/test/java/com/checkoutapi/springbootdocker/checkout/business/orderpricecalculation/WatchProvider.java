package com.checkoutapi.springbootdocker.checkout.business.orderpricecalculation;

import com.checkoutapi.springbootdocker.orm.watches.Watch;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.HashMap;
import java.util.stream.Stream;

public class WatchProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                new WatchTestData(
                        new Watch[]{
                                new Watch("001", "Best Watch", 100, 3, 200)
                        },
                        new HashMap<>() {{
                            put("001", 1);
                        }},
                        100
                ),
                new WatchTestData(
                        new Watch[]{
                                new Watch("001", "Best Watch", 100, 3, 200),
                        },
                        new HashMap<>() {{
                            put("001", 3);
                        }},
                        200
                ),
                new WatchTestData(
                        new Watch[]{
                                new Watch("001", "Best Watch", 100, 3, 200),
                                new Watch("002", "Worst Watch", 200, null, null),
                        },
                        new HashMap<>() {{
                            put("001", 3);
                            put("002", 1);
                        }},
                        400
                ),
                new WatchTestData(
                        new Watch[]{
                                new Watch("001", "Best Watch", 100, null, null),
                        },
                        new HashMap<>() {{
                            put("001", 2);
                        }},
                        200
                ),
                new WatchTestData(
                        new Watch[]{
                                new Watch("001", "Best Watch", 100, 0, 0),
                        },
                        new HashMap<>() {{
                            put("001", 2);
                        }},
                        200
                ),
                new WatchTestData(
                        new Watch[]{
                        },
                        new HashMap<>() {{
                            put("002", 1);
                        }},
                        0
                ),
                new WatchTestData(
                        new Watch[]{
                                new Watch("001", "Best Watch", 100, 3, 200),
                                new Watch("002", "Worst Watch", 200, null, null),
                        },
                        new HashMap<>() {{
                            put("001", 4);
                            put("002", 1);
                        }},
                        500
                ),
                new WatchTestData(
                        new Watch[]{
                                new Watch("001", "Best Watch", 100, 3, 200),
                        },
                        new HashMap<>() {{
                            put("001", 7);
                        }},
                        500
                )
        ).map(Arguments::of);
    }
}
