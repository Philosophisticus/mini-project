package com.at.dto.out;


public abstract class IdentifiedOutDTO<ID>
{

    private ID id;


    // ********************************************************************************************************** start
    // *** get/set methods ***

    public ID getId()
    {
        return id;
    }

    public void setId(ID id)
    {
        this.id = id;
    }

    // ********************************************************************************************************** end


}