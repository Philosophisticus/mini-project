package com.at.exception.catalogs.user;

import com.at.aspects.annotation.AppExceptionKey;
import com.at.exception.AppException;

@AppExceptionKey("app.err.user.not.found")
public class UserNotFoundException extends AppException
{

    private static final long serialVersionUID = 1L;

}
