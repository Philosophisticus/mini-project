package com.at.dto.in.catalogs.organization;

import com.at.constants.ValidationConstants;
import com.at.dto.in.catalogs.ITitledCatalogInDTO;
import org.hibernate.validator.constraints.Length;

public class OrganizationInDTO
    implements ITitledCatalogInDTO
{

    private Long id;

    @Length(max = 255, message = ValidationConstants.MAXLENGTH)
    private String title;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
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
