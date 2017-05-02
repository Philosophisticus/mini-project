package com.at.service.catalogs;

import com.at.dto.in.catalogs.ITitledCatalogInDTO;
import com.at.dto.out.IdentifiedOutDTO;
import com.at.dto.out.catalogs.CatalogOutDTO;
import com.at.exception.AppException;

import java.io.Serializable;
import java.util.List;

public interface CatalogLightWeightService<
        ID extends Serializable,
        OutDTO extends CatalogOutDTO<ID>,
        InDTO extends ITitledCatalogInDTO>
{

    /**
     * Find all catalog items
     *
     * @return {@link List<OutDTO>}
     */
    List<OutDTO> findAll();

    /**
     * Find catalog item by id
     *
     * @return {@link OutDTO}
     * @throws AppException
     */
    OutDTO findById(
            final ID id)
            throws
            AppException;

    /**
     * Add new catalog item in system
     *
     * @param inDTO - DTO with description for new catalog item
     * @return {@link OutDTO}
     * @throws AppException
     */
    OutDTO createNew(
            final InDTO inDTO);

    /**
     * Update catalog item in system
     *
     * @param id - id of catalog item
     * @param inDTO - DTO with description for updated catalog item
     * @return {@link OutDTO}
     * @throws AppException
     */
    OutDTO update(
            final ID id,
            final InDTO inDTO)
            throws
            AppException;

    /**
     * Delete catalog item from system
     *
     * @param id - id of chosen catalog item
     * @return {@link IdentifiedOutDTO<ID>}
     * @throws AppException
     */
    IdentifiedOutDTO<ID> delete(
            final ID id)
            throws
            AppException;

}
