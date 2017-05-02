package com.at.service.catalogs.user;

import com.at.dto.factory.catalogs.user.UserDTOFactory;
import com.at.dto.in.catalogs.user.UserInDTO;
import com.at.dto.out.IdentifiedOutDTO;
import com.at.dto.out.catalogs.user.UserOutDTO;
import com.at.exception.AppException;
import com.at.exception.catalogs.user.UserNotFoundException;
import com.at.exception.catalogs.user.UserWithLoginExistsException;
import com.at.exception.factory.AppExceptionFactory;
import com.at.model.entity.catalogs.user.User;
import com.at.model.enums.DictionaryStatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserLightWeightServiceImpl
    implements UserLightWeightService
{

    @Autowired
    protected AppExceptionFactory appExceptionFactory;

    @Autowired
    protected UserService catalogService;

    @Autowired
    private UserDTOFactory dtoFactory;

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public List<UserOutDTO> findAll()
    {
        return dtoFactory.createListOutDTO(catalogService.findAll());
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public UserOutDTO findById(Long id)
            throws AppException
    {
        final User model = catalogService.findById(id);
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
        final User model = catalogService.findById(id);
        catalogService.delete(model);
        return dtoFactory.createIdentifierOutDTO(model);
    }

    /**
     * {@inheritDoc}
     */
    @Transactional
    @Override
    public UserOutDTO createNew(UserInDTO inDTO)
    {

        User model = catalogService.findByLoginIgnoreCase(inDTO.getLogin());
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
                throw appExceptionFactory.getAppException(UserWithLoginExistsException.class);
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
    public UserOutDTO update(Long id, UserInDTO inDTO)
            throws AppException
    {

        final User model = catalogService.findById(id);
        final User modelByTitle = catalogService.findByLoginIgnoreCase(inDTO.getLogin());

        if (model == null)
            throw appExceptionFactory.getAppException(UserNotFoundException.class);

        if (modelByTitle != null)
        {
            if (!modelByTitle.getId().equals(model.getId()))
            {
                throw appExceptionFactory.getAppException(UserWithLoginExistsException.class);
            }
        }
        dtoFactory.updateModel(inDTO, model);
        return dtoFactory.createOutDTO(catalogService.save(model));

    }

}
