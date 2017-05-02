package com.at.dto.in.catalogs;

import java.io.Serializable;

public interface ITitledCatalogIdentifiedInDTO<ID extends Serializable>
    extends ITitledCatalogInDTO
{

    ID getId();

    void setId(
            ID title);

}
