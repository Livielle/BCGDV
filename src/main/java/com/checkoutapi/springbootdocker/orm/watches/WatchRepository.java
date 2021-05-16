package com.checkoutapi.springbootdocker.orm.watches;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchRepository extends CrudRepository<Watch, String>
{
}