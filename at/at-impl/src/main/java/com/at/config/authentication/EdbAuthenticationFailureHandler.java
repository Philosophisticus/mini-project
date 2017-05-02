package com.at.config.authentication;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EdbAuthenticationFailureHandler implements AuthenticationFailureHandler
{

    private static final String XML_HTTP_REQUEST = "XMLHttpRequest";
    private static final String HEADER_X_REQUESTED_WITH = "X-Requested-With";


    private final String redirectUrl;


    public EdbAuthenticationFailureHandler(String redirectUrl)
    {
        this.redirectUrl = redirectUrl;
    }

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException exception)
            throws
            IOException,
            ServletException
    {
        if (XML_HTTP_REQUEST.equals(request.getHeader(HEADER_X_REQUESTED_WITH)))
        {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
        else
        {
            response.sendRedirect(redirectUrl);
        }
    }

}
