package com.at.controller.security;

import com.at.dto.out.security.SecurityInfoOutDTO;
import com.at.service.security.SecurityLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/security")
public class SecurityController
{

    @Autowired
    private SecurityLightWeightService securityLightWeightService;


	// ********************************************************************************************************** start
	// *** web services methods ***

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public SecurityInfoOutDTO getUserSecurityDetails()
    {
        return securityLightWeightService.getUserSecurityDetails();
    }

    // ************************************************************************************************************ end

}