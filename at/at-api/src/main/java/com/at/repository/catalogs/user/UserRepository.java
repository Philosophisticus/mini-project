package com.at.repository.catalogs.user;

import com.at.model.entity.catalogs.user.User;
import com.at.repository.catalogs.CatalogRepository;

public interface UserRepository
    extends CatalogRepository<User, Long>
{

    User findByLoginIgnoreCase(String login);

}
