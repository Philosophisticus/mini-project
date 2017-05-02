package com.at.model.entity.invoice.product;

import com.at.model.entity.enums.Placement;
import com.at.model.entity.invoice.Invoice;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "INVOICE_PRODUCT")
public class InvoiceProduct extends AbstractProduct
{

    @Enumerated(EnumType.STRING)
    @Column(name = "PLACEMENT", nullable = false)
    private Placement placement;

    @ManyToOne(
            cascade = CascadeType.ALL,
            optional = false)
    @JoinColumn(name = "INVOICE_ID", nullable = false)
    private Invoice invoice;

    public Placement getPlacement()
    {
        return placement;
    }

    public void setPlacement(Placement placement)
    {
        this.placement = placement;
    }

    public Invoice getInvoice()
    {
        return invoice;
    }

    public void setInvoice(Invoice invoice)
    {
        this.invoice = invoice;
    }

}
