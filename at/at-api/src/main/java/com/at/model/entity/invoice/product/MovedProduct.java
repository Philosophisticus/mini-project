package com.at.model.entity.invoice.product;

import com.at.model.entity.enums.Placement;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "MOVED_PRODUCT")
public class MovedProduct extends AbstractProduct
{

    @Enumerated(EnumType.STRING)
    @Column(name = "FROM", nullable = false)
    private Placement from;

    @Enumerated(EnumType.STRING)
    @Column(name = "TO", nullable = false)
    private Placement to;

    @ManyToOne(
            cascade = CascadeType.ALL,
            optional = false)
    @JoinColumn(name = "ACTUAL_PRODUCT_ID", nullable = false)
    private ActualProduct actualProduct;

    public Placement getFrom()
    {
        return from;
    }

    public void setFrom(Placement from)
    {
        this.from = from;
    }

    public Placement getTo()
    {
        return to;
    }

    public void setTo(Placement to)
    {
        this.to = to;
    }

    public ActualProduct getActualProduct()
    {
        return actualProduct;
    }

    public void setActualProduct(ActualProduct actualProduct)
    {
        this.actualProduct = actualProduct;
    }
}
