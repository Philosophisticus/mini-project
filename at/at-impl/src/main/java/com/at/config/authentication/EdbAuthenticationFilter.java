package com.at.config.authentication;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EdbAuthenticationFilter extends AbstractAuthenticationProcessingFilter
{

    private static final String SID = "SID";

    public EdbAuthenticationFilter(RequestMatcher requestMatcher)
    {
        super(requestMatcher);
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse)
            throws
            AuthenticationException,
            IOException,
            ServletException
    {
        // get actual BYSID cookie value ..............................................................................
        final Cookie cookie = WebUtils.getCookie(httpServletRequest, SID);

        boolean failure = cookie == null;
        if (!failure)
        {
            final String cookieVal = cookie.getValue(); // sessionId

            if (!failure)
            {
                //  authenticate user .................................................................................
                PreAuthenticatedAuthenticationToken authRequest = new PreAuthenticatedAuthenticationToken(
                        httpServletRequest.getUserPrincipal().getName(), null);
                authRequest.setDetails(authenticationDetailsSource.buildDetails(httpServletRequest));

                Authentication authentication = getAuthenticationManager().authenticate(authRequest);
                WebUtils.setSessionAttribute(httpServletRequest, SID, cookieVal);

                return authentication;
            }
        }

        if (failure)
        {
            throw new AuthenticationServiceException("Error occurred during authentication");
        }

        return SecurityContextHolder.getContext().getAuthentication();
    }

    @Override
    protected boolean requiresAuthentication(HttpServletRequest request,
                                             HttpServletResponse response)
    {
        // get actual SID cookie value ..............................................................................
        final Cookie cookie = WebUtils.getCookie(request, SID);
        if (cookie == null)
        {
            return true;
        }

        // cookie found, check it has value the same as in the current session ........................................
        final String sessionVal = (String) WebUtils.getSessionAttribute(request, SID);
        final String cookieVal = cookie.getValue();
        return !cookieVal.equals(sessionVal);
    }

}
