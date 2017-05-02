package com.at.exception.factory;

import com.at.aspects.annotation.AppExceptionKey;
import com.at.exception.AppException;
import com.at.helper.system.AppMessageSourceHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppExceptionFactory
{

    @Autowired
    private AppMessageSourceHelper appMessageSourceHelper;

    // ********************************************************************************************************** start
    // *** public methods ***

    public <T extends AppException> T getAppException(
            Class<T> clazz,
            Object ... args)
    {

        T appException;

        try
        {
            AppExceptionKey appExceptionKey = clazz.getAnnotation(AppExceptionKey.class);
            String key = appExceptionKey.value();

            appException = clazz.newInstance();
            appException.setMessage(appMessageSourceHelper.getMessage(key, args));
        }
        catch (InstantiationException e)
        {
            throw new RuntimeException(e);
        }
        catch (IllegalAccessException e)
        {
            throw new RuntimeException(e);
        }

        return appException;

    }

    // ********************************************************************************************************** end
}
