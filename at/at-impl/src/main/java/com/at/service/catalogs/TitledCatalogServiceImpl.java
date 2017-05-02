package com.at.service.catalogs;

import com.at.exception.AppException;
import com.at.model.entity.catalogs.TitledCatalogEntity;
import com.at.repository.catalogs.TitledCatalogRepository;
import org.hibernate.criterion.MatchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.io.Serializable;
import java.util.List;


public abstract class TitledCatalogServiceImpl<
        T extends TitledCatalogEntity<ID>,
        ID extends Serializable,
        NotFoundException extends AppException>
        extends CatalogServiceImpl<T, ID, NotFoundException>
        implements TitledCatalogService<T, ID>
{

    @Autowired
    private TitledCatalogRepository<T, ID> repository;


    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> findAll()
    {
        return repository.findAllByOrderByTitleAsc();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T findByTitleIgnoreCase(String title)
    {
        return repository.findByTitleIgnoreCase(title);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> findByTitleIgnoreCaseContaining(
            String title)
    {
        return repository.findActiveByTitleIgnoreCaseContaining(
                MatchMode.ANYWHERE.toMatchString(title),
                new PageRequest(0, 20));
    }

}
