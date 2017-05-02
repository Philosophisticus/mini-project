package com.at.dto.in.catalogs.measure.unit;

import com.at.constants.ValidationConstants;
import com.at.dto.in.catalogs.ITitledCatalogInDTO;
import org.hibernate.validator.constraints.Length;

public class MeasureUnitInDTO
    implements ITitledCatalogInDTO
{

    @Length(max = 255, message = ValidationConstants.MAXLENGTH)
    private String title;

    @Override
    public String getTitle()
    {
        return title;
    }

    @Override
    public void setTitle(String title)
    {
        this.title = title;
    }

}
