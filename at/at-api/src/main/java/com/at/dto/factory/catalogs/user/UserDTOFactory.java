package com.at.dto.factory.catalogs.user;

import com.at.dto.factory.DTOFactoryMethods;
import com.at.dto.in.catalogs.user.UserInDTO;
import com.at.dto.out.catalogs.user.UserOutDTO;
import com.at.model.entity.catalogs.user.User;

public interface UserDTOFactory
        extends DTOFactoryMethods.CreateModel<User, UserInDTO>,
                DTOFactoryMethods.CreateOutDTO<User, UserOutDTO>,
                DTOFactoryMethods.CreateListOutDTO<User, UserOutDTO>,
                DTOFactoryMethods.CreateIdentifierOutDTO<User>,
                DTOFactoryMethods.FillPrimaryInfo<User, UserOutDTO>,
                DTOFactoryMethods.UpdateModel<User, UserInDTO>
{
}
