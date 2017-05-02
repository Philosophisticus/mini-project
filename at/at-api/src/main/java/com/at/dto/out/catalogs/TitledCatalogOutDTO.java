package com.at.dto.out.catalogs;


import com.at.dto.out.ITitledOutDTO;

import java.io.Serializable;

public abstract class TitledCatalogOutDTO<
        ID extends Serializable>
    extends CatalogOutDTO<ID>
    implements ITitledOutDTO
{

    private String title;


    // ********************************************************************************************************** start
    // *** public methods ***

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

    // ********************************************************************************************************** end


}
