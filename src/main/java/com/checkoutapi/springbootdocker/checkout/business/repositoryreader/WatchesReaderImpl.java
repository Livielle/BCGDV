package com.checkoutapi.springbootdocker.checkout.business.repositoryreader;

import com.checkoutapi.springbootdocker.orm.watches.Watch;
import com.checkoutapi.springbootdocker.orm.watches.WatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class WatchesReaderImpl implements Reader<Watch>
{
    @Autowired
    WatchRepository watchRepository;

    public Map<String, Watch> find(String[] ids)
    {
        Iterable<Watch> watches =  watchRepository.findAllById(Arrays.asList(ids));
        HashMap<String, Watch> result = new HashMap<>();
        for(Watch watch : watches) {
            result.put(watch.getWatchId(), watch);
        }

        return result;
    }
}
