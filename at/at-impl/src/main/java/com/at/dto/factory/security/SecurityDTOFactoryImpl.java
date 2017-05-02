package com.at.dto.factory.security;


import com.at.dto.out.security.SecurityInfoOutDTO;
import com.at.helper.system.SecurityHelper;
import com.at.model.entity.catalogs.user.User;
import org.springframework.stereotype.Component;


@Component
public class SecurityDTOFactoryImpl implements SecurityDTOFactory
{


    // ********************************************************************************************************** start
    // *** public methods ***

    @Override
    public SecurityInfoOutDTO createOutDTO()
    {
        final SecurityInfoOutDTO outDTO = new SecurityInfoOutDTO();

        final User user = SecurityHelper.currentUser();

        outDTO.setLogin(user.getLogin());
        outDTO.setName(user.getName());
        outDTO.setSurname(user.getSurname());

        return outDTO;
    }

    // ********************************************************************************************************** end


}