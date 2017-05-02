package com.at.dto.out.invoice.product;

import com.at.dto.out.IdentifierOutDTO;
import com.at.dto.out.catalogs.added.value.type.AddedValueTypeOutDTO;
import com.at.dto.out.catalogs.measure.unit.MeasureUnitOutDTO;

public class InvoiceProductOutDTO extends IdentifierOutDTO
{

    private Long invoiceId;

    private String title;

    private String code;

    private Long amount;

    private Long singleCost;

    private Long vat;

    private MeasureUnitOutDTO measureUnit;

    private AddedValueTypeOutDTO addedValueType;


    public Long getInvoiceId()
    {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId)
    {
        this.invoiceId = invoiceId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public Long getAmount()
    {
        return amount;
    }

    public void setAmount(Long amount)
    {
        this.amount = amount;
    }

    public Long getSingleCost()
    {
        return singleCost;
    }

    public void setSingleCost(Long singleCost)
    {
        this.singleCost = singleCost;
    }

    public Long getVat()
    {
        return vat;
    }

    public void setVat(Long vat)
    {
        this.vat = vat;
    }

    public MeasureUnitOutDTO getMeasureUnit()
    {
        return measureUnit;
    }

    public void setMeasureUnit(MeasureUnitOutDTO measureUnit)
    {
        this.measureUnit = measureUnit;
    }

    public AddedValueTypeOutDTO getAddedValueType()
    {
        return addedValueType;
    }

    public void setAddedValueType(AddedValueTypeOutDTO addedValueType)
    {
        this.addedValueType = addedValueType;
    }
}
