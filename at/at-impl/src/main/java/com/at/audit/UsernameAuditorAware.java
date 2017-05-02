package com.at.audit;


import com.at.helper.system.SecurityHelper;
import com.at.model.entity.catalogs.user.User;
import org.springframework.data.domain.AuditorAware;


public class UsernameAuditorAware implements AuditorAware<String>
{

    @Override
    public String getCurrentAuditor()
    {
        final User user = SecurityHelper.currentUser();
        if (user == null)
        {
            return "";
        }

        return String.valueOf(user.getId());
    }

}