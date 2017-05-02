package com.at.dto.factory.catalogs.user;

import com.at.dto.in.catalogs.user.UserInDTO;
import com.at.dto.out.IdentifiedOutDTO;
import com.at.dto.out.IdentifierOutDTO;
import com.at.dto.out.catalogs.user.UserOutDTO;
import com.at.model.entity.catalogs.user.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDTOFactoryImpl
    implements UserDTOFactory
{

    @Override
    public IdentifiedOutDTO createIdentifierOutDTO(User model)
    {
        IdentifierOutDTO outDTO = new IdentifierOutDTO();
        outDTO.setId(model.getId());
        return outDTO;
    }

    @Override
    public User createModel(UserInDTO inDTO)
    {
        User model = new User();
        updateModel(inDTO, model);
        return model;
    }

    @Override
    public UserOutDTO createOutDTO(User model)
    {
        UserOutDTO outDTO = new UserOutDTO();
        fillPrimaryInfo(outDTO, model);
        return outDTO;
    }

    @Override
    public List<UserOutDTO> createListOutDTO(List<User> modelList)
    {
        List<UserOutDTO> outDTOList = new ArrayList<>();
        for (User model: modelList)
        {
            outDTOList.add(createOutDTO(model));
        }
        return outDTOList;
    }

    @Override
    public void fillPrimaryInfo(
            UserOutDTO outDTO,
            User model)
    {
        outDTO.setId(model.getId());
        outDTO.setDictionaryStatusType(model.getDictionaryStatusType());
        outDTO.setName(model.getName());
        outDTO.setSurname(model.getSurname());
        outDTO.setLogin(model.getLogin());
    }

    @Override
    public void updateModel(
            UserInDTO inDTO,
            User model)
    {
        model.setLogin(inDTO.getLogin());
        model.setPassword(inDTO.getPassword());
        model.setName(inDTO.getName());
        model.setSurname(inDTO.getSurname());
    }

}
