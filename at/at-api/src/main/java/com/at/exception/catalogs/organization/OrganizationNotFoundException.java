package com.at.exception.catalogs.organization;


import com.at.aspects.annotation.AppExceptionKey;
import com.at.exception.AppException;

@AppExceptionKey("app.err.organization.not.found")
public class OrganizationNotFoundException extends AppException
{

    private static final long serialVersionUID = 1L;

}
