package com.at.model.entity.invoice;

import com.at.model.entity.IdentifiedEntity;
import com.at.model.entity.catalogs.organization.Organization;
import com.at.model.entity.invoice.product.InvoiceProduct;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.List;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "INVOICE")
public class Invoice extends IdentifiedEntity<Long>
{

    @Column(name = "DATE_OF_ARRIVAL", nullable = false)
    private DateTime dateOfArrival;

    @Column(name = "MAX_DATE_OF_PAYMENT", nullable = false)
    private DateTime maxDateOfPayment;

    @Column(name = "NUMBER", nullable = false)
    private String number;

    @Column(name = "TOTAL_COST", nullable = false)
    private Long totalCost;

    @Column(name = "PAID_COST", nullable = false)
    private Long paidCost;

    @Column(name = "IS_CONFIRMED", nullable = false)
    private Boolean confirmed;

    @Column(name = "IS_PAID", nullable = false)
    private Boolean paid;

    @ManyToOne(
            cascade = CascadeType.ALL,
            optional = false)
    @JoinColumn(name = "ORGANIZATION_ID", nullable = false)
    private Organization organization;

    @OneToMany(
            mappedBy = "invoice",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<InvoiceProduct> invoiceProducts;

    public DateTime getDateOfArrival()
    {
        return dateOfArrival;
    }

    public void setDateOfArrival(DateTime dateOfArrival)
    {
        this.dateOfArrival = dateOfArrival;
    }

    public DateTime getMaxDateOfPayment()
    {
        return maxDateOfPayment;
    }

    public void setMaxDateOfPayment(DateTime maxDateOfPayment)
    {
        this.maxDateOfPayment = maxDateOfPayment;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public Long getTotalCost()
    {
        return totalCost;
    }

    public void setTotalCost(Long totalCost)
    {
        this.totalCost = totalCost;
    }

    public Long getPaidCost()
    {
        return paidCost;
    }

    public void setPaidCost(Long paidCost)
    {
        this.paidCost = paidCost;
    }

    public Boolean getConfirmed()
    {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed)
    {
        this.confirmed = confirmed;
    }

    public Boolean getPaid()
    {
        return paid;
    }

    public void setPaid(Boolean paid)
    {
        this.paid = paid;
    }

    public Organization getOrganization()
    {
        return organization;
    }

    public void setOrganization(Organization organization)
    {
        this.organization = organization;
    }

    public List<InvoiceProduct> getInvoiceProducts()
    {
        return invoiceProducts;
    }

    public void setInvoiceProducts(List<InvoiceProduct> invoiceProducts)
    {
        this.invoiceProducts = invoiceProducts;
    }
}
