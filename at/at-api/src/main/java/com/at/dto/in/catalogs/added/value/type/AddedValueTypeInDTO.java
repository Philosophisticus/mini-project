package com.at.dto.in.catalogs.added.value.type;

import com.at.constants.ValidationConstants;
import com.at.dto.in.catalogs.ITitledCatalogInDTO;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class AddedValueTypeInDTO
    implements ITitledCatalogInDTO
{

    @NotNull(message = ValidationConstants.REQUIRED)
    private Long value;

    @Length(max = 255, message = ValidationConstants.MAXLENGTH)
    private String title;

    public Long getValue()
    {
        return value;
    }

    public void setValue(Long value)
    {
        this.value = value;
    }

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
