package com.at.exception;

public class AppException extends RuntimeException
{

    private static final long serialVersionUID = 1L;

    private String message;

    // ********************************************************************************************************** start
    // *** get/set methods ***

    @Override
    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    // ********************************************************************************************************** end

}
