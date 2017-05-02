package com.at.service.catalogs;

import com.at.exception.AppException;
import com.at.model.entity.catalogs.CatalogEntity;
import com.at.repository.catalogs.CatalogRepository;
import com.at.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class CatalogServiceImpl<
        T extends CatalogEntity<ID>,
        ID extends Serializable,
        NotFoundException extends AppException>
    extends GenericServiceImpl<T, ID, NotFoundException>
        implements CatalogService<T, ID>
{

    @Autowired
    private CatalogRepository<T, ID> repository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> findAll()
    {
        return repository.findAllEntities();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(T model)
    {
        repository.deleteEntity(model.getId());
    }

}
