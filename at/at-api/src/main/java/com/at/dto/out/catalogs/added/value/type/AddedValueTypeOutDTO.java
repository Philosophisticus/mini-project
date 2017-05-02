package com.at.dto.out.catalogs.added.value.type;

import com.at.dto.out.catalogs.TitledCatalogOutDTO;

public class AddedValueTypeOutDTO
    extends TitledCatalogOutDTO<Long>
{

    private Long value;

    public Long getValue()
    {
        return value;
    }

    public void setValue(Long value)
    {
        this.value = value;
    }
}
