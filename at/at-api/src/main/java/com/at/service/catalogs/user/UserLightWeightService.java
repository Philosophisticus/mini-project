package com.at.service.catalogs.user;

import com.at.dto.in.catalogs.user.UserInDTO;
import com.at.dto.out.IdentifiedOutDTO;
import com.at.dto.out.catalogs.user.UserOutDTO;
import com.at.exception.AppException;

import java.util.List;

public interface UserLightWeightService
{

    List<UserOutDTO> findAll();

    UserOutDTO findById(
            final Long id)
            throws AppException;

    UserOutDTO createNew(
            final UserInDTO inDTO);

    UserOutDTO update(
            final Long id,
            final UserInDTO inDTO)
            throws AppException;

    IdentifiedOutDTO<Long> delete(
            final Long id)
            throws AppException;

}
