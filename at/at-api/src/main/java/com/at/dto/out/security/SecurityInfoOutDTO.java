package com.at.dto.out.security;

public class SecurityInfoOutDTO
{

    private String login;

    private String name;

    private String surname;


    // ********************************************************************************************************** start
    // *** get/set methods ***

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    // ********************************************************************************************************** end


}
