package com.at.service.catalogs;

import com.at.model.entity.catalogs.CatalogEntity;
import com.at.service.GenericService;

import java.io.Serializable;

public interface CatalogService<T extends CatalogEntity<ID>, ID extends Serializable>
    extends GenericService<T, ID>
{
}
