package com.at.model.entity.invoice.product;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "SOLD_PRODUCT")
public class SoldProduct extends AbstractProduct
{

    @Column(name = "DATE_OF_SALE", nullable = false)
    private DateTime dateOfSale;

    public DateTime getDateOfSale()
    {
        return dateOfSale;
    }

    public void setDateOfSale(DateTime dateOfSale)
    {
        this.dateOfSale = dateOfSale;
    }

}
