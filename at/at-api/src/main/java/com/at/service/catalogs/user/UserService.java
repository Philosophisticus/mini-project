package com.at.service.catalogs.user;

import com.at.model.entity.catalogs.user.User;
import com.at.service.catalogs.CatalogService;

public interface UserService
    extends CatalogService<User, Long>
{

    User findByLoginIgnoreCase(String title);

}
