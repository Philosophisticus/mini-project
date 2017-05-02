package com.at.controller;

import com.at.aspects.annotation.TypeConversionError;
import com.at.dto.out.error.ErrorOutDTO;
import com.at.exception.AppException;
import com.at.helper.system.AppMessageSourceHelper;
import com.at.constants.ValidationConstants;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class AppExceptionHandler
{

    private static final Logger LOGGER = LoggerFactory.getLogger(AppExceptionHandler.class);


    private static final String TYPE_MISMATCH = "typeMismatch";
    private static final String MSG_VALID_ERR_TYPE_MISMATCH = "valid.err.type.mismatch";
    private static final String APP_VALIDATION_ERROR = "AppValidationError";


    @Autowired
    protected AppMessageSourceHelper appMessageHelper;


    // ********************************************************************************************************** start
    // *** exception handler methods ***

    @ExceptionHandler(AppException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorOutDTO handleAppException(
            AppException error)
            throws
            IOException
    {
        return new ErrorOutDTO(error, error.getMessage());
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorOutDTO handleMethodArgumentNotValidException1(
            BindException error)
            throws
            IOException
    {
        return createValidationErrorOutDTO(error.getBindingResult());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorOutDTO handleMethodArgumentNotValidException(
            MethodArgumentNotValidException error)
            throws
            IOException
    {
        return createValidationErrorOutDTO(error.getBindingResult());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorOutDTO handleHttpMessageNotReadableException(
            HttpMessageNotReadableException error)
            throws
            IOException
    {

        LOGGER.error("", error);
        String errorMessage = getErrorMessage(error);
        errorMessage = errorMessage.isEmpty() ? error.getMessage() : errorMessage;

        return new ErrorOutDTO(error, errorMessage);

    }

    @ExceptionHandler(TypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorOutDTO handleTypeMismatchException(
            TypeMismatchException error)
            throws
            IOException
    {

        LOGGER.error("", error);
        return new ErrorOutDTO(error, error.getMessage());

    }

    // ********************************************************************************************************** end


    // ********************************************************************************************************** start
    // *** private methods ***

    /**
     * Get error message from HttpMessageNotReadableException
     *
     * @param ex - Exception
     * @return Formatted error message
     */
    private String getErrorMessage(
            HttpMessageNotReadableException ex)
    {

        Throwable cause = ex.getCause();

        if (cause != null)
        {
            if (cause instanceof JsonMappingException)
            {
                return getErrorMessage((JsonMappingException)cause);
            }
        }

        return "";

    }

    /**
     * Get error message from JsonMappingException
     *
     * @param ex - {@link JsonMappingException}
     * @return Formatted error message
     */
    private String getErrorMessage(
            final JsonMappingException ex)
    {

        final List<JsonMappingException.Reference> jsonRefs = ex.getPath();
        String errMessage = "";

        if (jsonRefs != null && !jsonRefs.isEmpty())
        {
            final JsonMappingException.Reference jsonRef = jsonRefs.get(jsonRefs.size() - 1);
            final Class<?> clazz = jsonRef.getFrom().getClass();

            try
            {
                final Field field = clazz.getDeclaredField(jsonRef.getFieldName());

                final TypeConversionError typeErr = field.getAnnotation(TypeConversionError.class);

                errMessage = typeErr != null
                        ? appMessageHelper.getMessage(typeErr.message())
                        : appMessageHelper.getMessage(MSG_VALID_ERR_TYPE_MISMATCH);

            }
            catch (SecurityException e)
            {
                LOGGER.error("", e);
            }
            catch (NoSuchFieldException e)
            {
                LOGGER.error("", e);
            }
            catch (Throwable e)
            {
                LOGGER.error("", e);
            }
        }

        return errMessage;

    }

    /**
     * Get error message from ObjectError
     *
     * @param objectError - {@link ObjectError}
     * @return Formatted error message
     */
    private String getErrorMessage(
            final ObjectError objectError,
            final Object rejectedValue)
    {

//        return !TYPE_MISMATCH.equals(objectError.getCode())
//                ? appMessageHelper.getMessage(objectError.getDefaultMessage())
//                : appMessageHelper.getMessage(MSG_VALID_ERR_TYPE_MISMATCH);
        switch (objectError.getDefaultMessage())
        {
            case ValidationConstants.RANGE_LENGTH:
                Integer maxLength = (Integer)objectError.getArguments()[1];
                if (((String)rejectedValue).length() > maxLength)
                    return ValidationConstants.MAXLENGTH;
                else
                    return ValidationConstants.MINLENGTH;
            default: return objectError.getDefaultMessage();
        }

    }

    /**
     * Create APP_VALIDATION_ERROR ErrorOutDTO using BindingResult
     *
     * @param bindingResult - {@link BindingResult}
     * @return {@link ErrorOutDTO}
     */
    private ErrorOutDTO createValidationErrorOutDTO(
            final BindingResult bindingResult)
    {

        final Map<String, List<String>> errors = new HashMap<>();
        for (ObjectError objectError: bindingResult.getAllErrors())
        {
            if (objectError instanceof FieldError)
            {
                final FieldError fieldError = (FieldError)objectError;
                final Object rejectedValue = fieldError.getRejectedValue();
                final String field = fieldError.getField();
                if (!errors.containsKey(field))
                {
                    errors.put(field, new ArrayList<String>());
                }

                errors.get(field).add(getErrorMessage(objectError, rejectedValue));
            }
        }

        return new ErrorOutDTO(APP_VALIDATION_ERROR, convertErrorsMap(errors));

    }

    private Map<String, String> convertErrorsMap(Map<String, List<String>> errors)
    {

        Map<String, String> resultMap = new HashMap<>();
        for (Map.Entry<String, List<String>> entry: errors.entrySet())
        {
            List<String> fieldErrors = entry.getValue();
            String finalError = null;
            for (String fieldError: fieldErrors)
            {
                if (fieldError.equals(ValidationConstants.REQUIRED))
                {
                    finalError = ValidationConstants.REQUIRED;
                    break;
                }
                finalError = fieldError;
            }
            resultMap.put(entry.getKey(), finalError);
        }
        return resultMap;

    }

    // ********************************************************************************************************** end


}