package com.at.service.catalogs.user;

import com.at.exception.catalogs.user.UserNotFoundException;
import com.at.model.entity.catalogs.user.User;
import com.at.repository.catalogs.user.UserRepository;
import com.at.service.catalogs.CatalogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl
    extends CatalogServiceImpl<User, Long, UserNotFoundException>
    implements UserService
{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByLoginIgnoreCase(String login)
    {
        return userRepository.findByLoginIgnoreCase(login);
    }

}
