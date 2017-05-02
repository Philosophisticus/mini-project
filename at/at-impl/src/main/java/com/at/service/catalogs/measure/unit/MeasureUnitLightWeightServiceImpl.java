package com.at.service.catalogs.measure.unit;

import com.at.dto.factory.catalogs.measure.unit.MeasureUnitDTOFactory;
import com.at.dto.in.catalogs.measure.unit.MeasureUnitInDTO;
import com.at.dto.out.IdentifiedOutDTO;
import com.at.dto.out.catalogs.measure.unit.MeasureUnitOutDTO;
import com.at.exception.AppException;
import com.at.exception.catalogs.measure.unit.MeasureUnitNotFoundException;
import com.at.exception.catalogs.measure.unit.MeasureUnitWithTitleExistsException;
import com.at.exception.factory.AppExceptionFactory;
import com.at.model.entity.catalogs.measure.unit.MeasureUnit;
import com.at.model.enums.DictionaryStatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MeasureUnitLightWeightServiceImpl
    implements MeasureUnitLightWeightService
{

    @Autowired
    protected AppExceptionFactory appExceptionFactory;

    @Autowired
    protected MeasureUnitService catalogService;

    @Autowired
    private MeasureUnitDTOFactory dtoFactory;

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public List<MeasureUnitOutDTO> findAll()
    {
        return dtoFactory.createListOutDTO(catalogService.findAll());
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public MeasureUnitOutDTO findById(Long id)
            throws AppException
    {
        final MeasureUnit model = catalogService.findById(id);
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
        final MeasureUnit model = catalogService.findById(id);
        catalogService.delete(model);
        return dtoFactory.createIdentifierOutDTO(model);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public MeasureUnitOutDTO createNew(MeasureUnitInDTO inDTO)
    {

        MeasureUnit model = catalogService.findByTitleIgnoreCase(inDTO.getTitle());
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
                throw appExceptionFactory.getAppException(MeasureUnitWithTitleExistsException.class);
            }
        }
        return dtoFactory.createOutDTO(catalogService.save(model));

    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public MeasureUnitOutDTO update(Long id, MeasureUnitInDTO inDTO)
            throws AppException
    {

        final MeasureUnit model = catalogService.findById(id);
        final MeasureUnit modelByTitle = catalogService.findByTitleIgnoreCase(inDTO.getTitle());

        if (model == null)
            throw appExceptionFactory.getAppException(MeasureUnitNotFoundException.class);

        if (modelByTitle != null)
        {
            if (!modelByTitle.getId().equals(model.getId()))
            {
                throw appExceptionFactory.getAppException(MeasureUnitWithTitleExistsException.class);
            }
        }
        dtoFactory.updateModel(inDTO, model);
        return dtoFactory.createOutDTO(catalogService.save(model));

    }
}
