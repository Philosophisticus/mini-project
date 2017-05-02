package com.at.dto.out.invoice;

import com.at.dto.out.IdentifierOutDTO;
import com.at.dto.out.catalogs.organization.OrganizationOutDTO;
import org.joda.time.DateTime;

public class InvoiceOutDTO extends IdentifierOutDTO
{

    private DateTime dateOfArrival;

    private DateTime maxDateOfPayment;

    private String number;

    private Long totalCost;

    private Long paidCost;

    private Boolean confirmed;

    private Boolean paid;

    private OrganizationOutDTO organization;


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

    public OrganizationOutDTO getOrganization()
    {
        return organization;
    }

    public void setOrganization(OrganizationOutDTO organization)
    {
        this.organization = organization;
    }

}
