package com.at.model.entity.invoice.product;

import com.at.model.entity.IdentifiedEntity;
import com.at.model.entity.catalogs.added.value.type.AddedValueType;
import com.at.model.entity.catalogs.measure.unit.MeasureUnit;

import javax.persistence.*;

@MappedSuperclass
public class AbstractProduct extends IdentifiedEntity<Long>
{

    /*
    наименование
    код
    ед. измерения
    цена одного изделия
    НДС
    вид добавочной стоимости
     */

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "CODE", nullable = false)
    private String code;

    @Column(name = "AMOUNT", nullable = false)
    private Long amount;

    @Column(name = "SINGLE_COST", nullable = false)
    private Long singleCost;

    @Column(name = "VAT", nullable = false)
    private Long vat;

    @ManyToOne(
            cascade = CascadeType.ALL,
            optional = false)
    @JoinColumn(name = "MEASURE_UNIT_ID", nullable = false)
    private MeasureUnit measureUnit;

    @ManyToOne(
            cascade = CascadeType.ALL,
            optional = false)
    @JoinColumn(name = "ADDED_VALUE_TYPE", nullable = false)
    private AddedValueType addedValueType;

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

    public MeasureUnit getMeasureUnit()
    {
        return measureUnit;
    }

    public void setMeasureUnit(MeasureUnit measureUnit)
    {
        this.measureUnit = measureUnit;
    }

    public AddedValueType getAddedValueType()
    {
        return addedValueType;
    }

    public void setAddedValueType(AddedValueType addedValueType)
    {
        this.addedValueType = addedValueType;
    }
}
