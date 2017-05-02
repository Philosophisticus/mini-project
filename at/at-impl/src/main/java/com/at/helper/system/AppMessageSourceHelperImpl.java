package com.at.helper.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.logging.Logger;

@Component
public class AppMessageSourceHelperImpl implements AppMessageSourceHelper
{

    private Logger logger = Logger.getLogger(AppMessageSourceHelperImpl.class.getName());

    @Autowired
    private MessageSource messageSource;

    // ********************************************************************************************************** start
    // *** public methods ***

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage(
            String code)
    {
        return getMessage(code, null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMessage(
            String code,
            Object... args)
    {

        try
        {
            return messageSource.getMessage(code, args, getUserLocale());
        }
        catch (NoSuchMessageException e)
        {
            return prepareErrMessage(code);
        }

    }

    @Override
    public String getMessage(
            String code,
            Object[] args,
            String defaultMessage)
    {
        return messageSource.getMessage(code, args, defaultMessage, getUserLocale());
    }

    // ********************************************************************************************************** end

    // ********************************************************************************************************** start
    // *** private methods ***

    private Locale getUserLocale()
    {
        return LocaleContextHolder.getLocale();
    }

    public String prepareErrMessage(
            String code)
    {

        String msg = "Please add the following message key to Resource Bundle. Resource Bundle has no '" + code + "' message key";

        logger.info(msg);
        return msg;

    }

    // ********************************************************************************************************** end
}
