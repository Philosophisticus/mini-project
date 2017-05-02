package com.at.helper.system;

import com.at.model.entity.catalogs.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public class SecurityHelper
{

    // ********************************************************************************************************** start
    // *** public methods ***

    /**
     * Get current user.
     *
     * @return {@link User}
     */
    @SuppressWarnings("unchecked")
    public static User currentUser()
    {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated())
        {
            return ((User) authentication.getPrincipal());
        }

        return null;
    }

    /**
     * Get current user id.
     *
     * @return id of {@link User}
     */
    public static Long currentUserId()
    {
        final User currentUser = currentUser();
        return currentUser != null? currentUser.getId(): null;
    }

    // ********************************************************************************************************** end

}
