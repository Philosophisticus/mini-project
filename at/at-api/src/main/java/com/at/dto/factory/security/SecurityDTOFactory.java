package com.at.dto.factory.security;


import com.at.dto.out.security.SecurityInfoOutDTO;


public interface SecurityDTOFactory
{

    /**
     * Create {@link SecurityInfoOutDTO}.
     *
     * @return {@link SecurityInfoOutDTO}
     */
    SecurityInfoOutDTO createOutDTO();

}
