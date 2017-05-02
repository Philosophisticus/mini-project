package com.at.config.authentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EdbLogoutHandler implements LogoutHandler
{

    private static final String SID = "SID";

    @Override
    public void logout(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            Authentication authentication)
    {
        final Cookie cookie = WebUtils.getCookie(httpServletRequest, SID);

        if (cookie != null)
        {
            // remove cookie
            cookie.setMaxAge(0);
            cookie.setValue(null);
            httpServletResponse.addCookie(cookie);
        }
    }

}
