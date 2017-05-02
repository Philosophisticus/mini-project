package com.at.dto.out.catalogs.user;

import com.at.dto.out.IdentifierOutDTO;
import com.at.dto.out.catalogs.CatalogOutDTO;

public class UserOutDTO extends CatalogOutDTO<Long>
{

    private String login;

    private String name;

    private String surname;

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
}
