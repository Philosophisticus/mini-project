package com.at.dto.in.invoice;

import org.joda.time.DateTime;

public class InvoiceInDTO
{

    private DateTime dateOfArrival;

    private DateTime maxDateOfPayment;

    private String number;

    private Long organizationId;


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

    public Long getOrganizationId()
    {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId)
    {
        this.organizationId = organizationId;
    }
}
