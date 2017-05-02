package com.at.dto.out.error;

import java.io.Serializable;


public class ErrorOutDTO implements Serializable
{

    private static final long serialVersionUID = 1L;


    private String type;

    private Object data;

    /**
     * Constructor
     *
     * @param exc - error exception
     * @param data - error data
     */
    public ErrorOutDTO(
            final Throwable exc,
            final String data)
    {

        this.type = exc.getClass().getSimpleName();
        this.data = data;

    }

    /**
     * Constructor
     *
     * @param type - error type
     * @param data - error data
     */
    public ErrorOutDTO(
            final String type,
            final Object data)
    {

        this.type = type;
        this.data = data;

    }

    /**
     * Constructor
     */
    public ErrorOutDTO()
    {
    }

    // ********************************************************************************************************** start
    // *** get/set methods ***

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    // ********************************************************************************************************** end


}