package com.at.service.security;

import com.at.dto.out.security.SecurityInfoOutDTO;


public interface SecurityLightWeightService
{

    /**
     * Get user details.
     *
     * @return {@link SecurityInfoOutDTO}
     */
    SecurityInfoOutDTO getUserSecurityDetails();

}
