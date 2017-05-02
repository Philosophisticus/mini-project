package com.at.service.security;


import com.at.dto.factory.security.SecurityDTOFactory;
import com.at.dto.out.security.SecurityInfoOutDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class SecurityLightWeightServiceImpl implements SecurityLightWeightService
{

    @Autowired
    private SecurityDTOFactory securityDTOFactory;


    // ********************************************************************************************************** start
    // *** override SecurityLightWeightService methods ***

    @Override
    @Transactional(readOnly = true)
    public SecurityInfoOutDTO getUserSecurityDetails()
    {
        return securityDTOFactory.createOutDTO();
    }

    // ********************************************************************************************************** end


}