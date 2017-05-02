package com.at.service;

import com.at.exception.AppException;
import com.at.model.entity.IdentifiedEntity;

import java.io.Serializable;
import java.util.List;

public interface GenericService<T extends IdentifiedEntity<ID>, ID extends Serializable>
{

    /**
     * Find all items
     *
     * @return {@link List <T>}
     */
    List<T> findAll();

    /**
     * Find item by ID
     *
     * @param id - id of item
     * @return {@link T}
     * @throws AppException
     */
    T findById(
            final ID id)
            throws
            AppException;

    /**
     * Add save item in system
     *
     * @param newModel - new data
     * @return {@link T}
     */
    T save(
            T newModel)
            throws
            AppException;

    /**
     * Delete item from system
     *
     * @param model - item to delete
     * @return {@link T}
     */
    void delete(
            T model);

    /**
     * Validate item
     *
     * @param model - item to validate
     */
    void validate(
            T model)
            throws
            AppException;

    /**
     * Check item before removal
     *
     * @param model - item for check
     */
    void checkBeforeDelete(
            T model)
            throws
            AppException;

}
