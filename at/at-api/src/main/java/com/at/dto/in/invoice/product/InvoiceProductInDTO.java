package com.at.dto.in.invoice.product;

public class InvoiceProductInDTO
{

    private String title;

    private String code;

    private Long amount;

    private Long singleCost;

    private Long vat;

    private String placement;

    private Long measureUnitId;

    private Long addedValueTypeId;


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

    public String getPlacement()
    {
        return placement;
    }

    public void setPlacement(String placement)
    {
        this.placement = placement;
    }

    public Long getMeasureUnitId()
    {
        return measureUnitId;
    }

    public void setMeasureUnitId(Long measureUnitId)
    {
        this.measureUnitId = measureUnitId;
    }

    public Long getAddedValueTypeId()
    {
        return addedValueTypeId;
    }

    public void setAddedValueTypeId(Long addedValueTypeId)
    {
        this.addedValueTypeId = addedValueTypeId;
    }

}
