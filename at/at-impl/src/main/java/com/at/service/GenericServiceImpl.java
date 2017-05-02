package com.at.service;

import com.at.exception.AppException;
import com.at.exception.factory.AppExceptionFactory;
import com.at.helper.ReflectionHelper;
import com.at.model.entity.IdentifiedEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;

public abstract class GenericServiceImpl<
        T extends IdentifiedEntity<ID>,
        ID extends Serializable,
        NotFoundException extends AppException>
    implements GenericService<T, ID>
{

    @Autowired
    protected AppExceptionFactory appExceptionFactory;

    @Autowired
    private JpaRepository<T, ID> repository;

    @Autowired
    private ReflectionHelper reflectionHelper;


    private Class<? extends AppException> notFoundExceptionClazz;



    @SuppressWarnings("unchecked")
    @PostConstruct
    private void init()
    {
        notFoundExceptionClazz = (Class<NotFoundException>)reflectionHelper.getGenericArgumentType(getClass(), 2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> findAll()
    {
        return repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T findById(
            final ID id)
    {

        final T model = repository.findOne(id);
        if (model == null)
        {
            throw appExceptionFactory.getAppException(notFoundExceptionClazz);
        }
        return model;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T save(T model)
    {
        validate(model);
        return repository.save(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(T model)
    {
        checkBeforeDelete(model);
        repository.delete(model.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void validate(T model)
    {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void checkBeforeDelete(T model)
    {
    }

}
