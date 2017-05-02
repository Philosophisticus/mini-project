package com.at.model.entity.catalogs;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class TitledCatalogEntity<PK extends Serializable>
        extends CatalogEntity<PK>
{

    @Column(name = "TITLE", nullable = false, unique = true)
    private String title;


    // ********************************************************************************************************** start
    // *** public methods ***

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    // ********************************************************************************************************** end

}
