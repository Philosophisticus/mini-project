package com.at.service.catalogs.organization;

import com.at.dto.factory.catalogs.organization.OrganizationDTOFactory;
import com.at.dto.in.catalogs.organization.OrganizationInDTO;
import com.at.dto.out.IdentifiedOutDTO;
import com.at.dto.out.catalogs.organization.OrganizationOutDTO;
import com.at.exception.AppException;
import com.at.exception.catalogs.organization.OrganizationNotFoundException;
import com.at.exception.catalogs.organization.OrganizationWithTitleExistsException;
import com.at.exception.factory.AppExceptionFactory;
import com.at.model.entity.catalogs.organization.Organization;
import com.at.model.enums.DictionaryStatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrganizationLightWeightServiceImpl
    implements OrganizationLightWeightService
{

    @Autowired
    protected AppExceptionFactory appExceptionFactory;

    @Autowired
    protected OrganizationService catalogService;

    @Autowired
    private OrganizationDTOFactory dtoFactory;

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public List<OrganizationOutDTO> findAll()
    {
        return dtoFactory.createListOutDTO(catalogService.findAll());
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public OrganizationOutDTO findById(Long id)
            throws AppException
    {
        final Organization model = catalogService.findById(id);
        return dtoFactory.createOutDTO(model);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public IdentifiedOutDTO<Long> delete(Long id)
            throws AppException
    {
        final Organization model = catalogService.findById(id);
        catalogService.delete(model);
        return dtoFactory.createIdentifierOutDTO(model);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public OrganizationOutDTO createNew(OrganizationInDTO inDTO)
    {

        Organization model = catalogService.findByTitleIgnoreCase(inDTO.getTitle());
        if (model == null)
        {
            model = dtoFactory.createModel(inDTO);
        }
        else
        {
            if (model.getDictionaryStatusType().equals(DictionaryStatusType.DELETED))
            {
                model.setDictionaryStatusType(DictionaryStatusType.ACTIVE);
            }
            else
            {
                throw appExceptionFactory.getAppException(OrganizationWithTitleExistsException.class);
            }
        }
        return dtoFactory.createOutDTO(catalogService.save(model));

    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public OrganizationOutDTO update(Long id, OrganizationInDTO inDTO)
            throws AppException
    {

        final Organization model = catalogService.findById(id);
        final Organization modelByTitle = catalogService.findByTitleIgnoreCase(inDTO.getTitle());

        if (model == null)
            throw appExceptionFactory.getAppException(OrganizationNotFoundException.class);

        if (modelByTitle != null)
        {
            if (!modelByTitle.getId().equals(model.getId()))
            {
                throw appExceptionFactory.getAppException(OrganizationWithTitleExistsException.class);
            }
        }
        dtoFactory.updateModel(inDTO, model);
        return dtoFactory.createOutDTO(catalogService.save(model));

    }

}
