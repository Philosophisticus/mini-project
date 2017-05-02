package com.at.config.authentication;

import com.at.model.entity.catalogs.role.privilege.RolePrivilege;
import com.at.model.entity.user.User;
import com.at.model.entity.user.role.UserRole;
import com.at.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;

public class EdbAuthenticationProvider implements AuthenticationProvider
{

    private static final Logger LOGGER = LoggerFactory.getLogger(EdbAuthenticationProvider.class);

    @Autowired
    private UserService userService;


    @Override
    public Authentication authenticate(
            Authentication authentication)
            throws
            AuthenticationException
    {
        final String username = authentication.getName();
        final String password = authentication.getCredentials().toString();

        User user = userService.findUserByLoginAndPassword(username, password);
        if (user == null)
            return null;

        final Collection<GrantedAuthority> authorities = new ArrayList<>();
        for (UserRole userRole : user.getUserRoles())
        {
            for (RolePrivilege rolePrivilege : userRole.getRole().getRolePrivileges())
            {
                authorities.add(new SimpleGrantedAuthority(rolePrivilege.getPrivilege().name()));
            }
        }

        LOGGER.warn("User[login='" + user.getEdbData().getLogin() + "'] logged in");
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    @Override
    public boolean supports(Class<?> clazz)
    {
        return true;
    }

}
