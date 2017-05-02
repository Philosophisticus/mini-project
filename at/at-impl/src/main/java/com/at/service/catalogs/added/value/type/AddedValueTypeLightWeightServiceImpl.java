package com.at.service.catalogs.added.value.type;

import com.at.dto.factory.catalogs.added.value.type.AddedValueTypeDTOFactory;
import com.at.dto.in.catalogs.added.value.type.AddedValueTypeInDTO;
import com.at.dto.out.IdentifiedOutDTO;
import com.at.dto.out.catalogs.added.value.type.AddedValueTypeOutDTO;
import com.at.exception.AppException;
import com.at.exception.catalogs.added.value.type.AddedValueTypeNotFoundException;
import com.at.exception.catalogs.added.value.type.AddedValueTypeWithTitleExistsException;
import com.at.exception.factory.AppExceptionFactory;
import com.at.model.entity.catalogs.added.value.type.AddedValueType;
import com.at.model.enums.DictionaryStatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddedValueTypeLightWeightServiceImpl
    implements AddedValueTypeLightWeightService
{

    @Autowired
    protected AppExceptionFactory appExceptionFactory;

    @Autowired
    protected AddedValueTypeService catalogService;

    @Autowired
    private AddedValueTypeDTOFactory dtoFactory;

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public List<AddedValueTypeOutDTO> findAll()
    {
        return dtoFactory.createListOutDTO(catalogService.findAll());
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public AddedValueTypeOutDTO findById(Long id)
            throws AppException
    {
        final AddedValueType model = catalogService.findById(id);
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
        final AddedValueType model = catalogService.findById(id);
        catalogService.delete(model);
        return dtoFactory.createIdentifierOutDTO(model);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public AddedValueTypeOutDTO createNew(AddedValueTypeInDTO inDTO)
    {

        AddedValueType model = catalogService.findByTitleIgnoreCase(inDTO.getTitle());
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
                throw appExceptionFactory.getAppException(AddedValueTypeWithTitleExistsException.class);
            }
        }
        dtoFactory.updateModel(inDTO, model);
        return dtoFactory.createOutDTO(catalogService.save(model));

    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public AddedValueTypeOutDTO update(Long id, AddedValueTypeInDTO inDTO)
            throws AppException
    {

        final AddedValueType model = catalogService.findById(id);
        final AddedValueType modelByTitle = catalogService.findByTitleIgnoreCase(inDTO.getTitle());

        if (model == null)
            throw appExceptionFactory.getAppException(AddedValueTypeNotFoundException.class);

        if (modelByTitle != null)
        {
            if (!modelByTitle.getId().equals(model.getId()))
            {
                throw appExceptionFactory.getAppException(AddedValueTypeWithTitleExistsException.class);
            }
        }
        dtoFactory.updateModel(inDTO, model);
        return dtoFactory.createOutDTO(catalogService.save(model));

    }

}
