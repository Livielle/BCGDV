package com.checkoutapi.springbootdocker.orm.watches;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "watches")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Watch
{
    @Id
    @Column(name="watch_id")
    private String watchId;

    @Column(name="watch_name")
    private String watchName;

    @Column(name="unit_price")
    private Integer unitPrice;

    @Column(name="quantity_for_discount")
    private Integer quantityForDiscount;

    @Column(name="discount_price")
    private Integer discountPrice;
}
