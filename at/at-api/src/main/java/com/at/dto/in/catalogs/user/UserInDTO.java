package com.at.dto.in.catalogs.user;

import com.at.constants.ValidationConstants;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class UserInDTO
{

    @NotNull(message = ValidationConstants.REQUIRED)
    @Length(max = 255, message = ValidationConstants.MAXLENGTH)
    private String name;

    @NotNull(message = ValidationConstants.REQUIRED)
    @Length(max = 255, message = ValidationConstants.MAXLENGTH)
    private String surname;

    @NotNull(message = ValidationConstants.REQUIRED)
    @Length(max = 255, message = ValidationConstants.MAXLENGTH)
    private String login;

    @NotNull(message = ValidationConstants.REQUIRED)
    @Length(max = 255, message = ValidationConstants.MAXLENGTH)
    private String password;


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

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

}
