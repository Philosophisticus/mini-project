package com.at.model.entity.invoice.product;

import com.at.model.entity.enums.Placement;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "ACTUAL_PRODUCT")
public class ActualProduct extends AbstractProduct
{

    @Enumerated(EnumType.STRING)
    @Column(name = "PLACEMENT", nullable = false)
    private Placement placement;

    public Placement getPlacement()
    {
        return placement;
    }

    public void setPlacement(Placement placement)
    {
        this.placement = placement;
    }

}
