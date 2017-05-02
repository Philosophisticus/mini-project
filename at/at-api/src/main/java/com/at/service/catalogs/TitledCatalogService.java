package com.at.service.catalogs;

import com.at.model.entity.catalogs.TitledCatalogEntity;

import java.io.Serializable;
import java.util.List;

public interface TitledCatalogService<T extends TitledCatalogEntity<ID>, ID extends Serializable>
    extends CatalogService<T, ID>
{

    /**
     * Find catalog item by title ignore case
     *
     * @param title - title of catalog item
     * @return {@link T}
     */
    T findByTitleIgnoreCase(
            final String title);

    /**
     * Find catalog item containing title ignore case
     *
     * @param title - title of catalog item
     * @return {@link T}
     */
    List<T> findByTitleIgnoreCaseContaining(
            final String title);

}
