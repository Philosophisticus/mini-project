package com.at.exception.catalogs.organization;

import com.at.aspects.annotation.AppExceptionKey;
import com.at.exception.AppException;

@AppExceptionKey("app.err.organization.with.title.exists")
public class OrganizationWithTitleExistsException extends AppException
{

    private static final long serialVersionUID = 1L;

}
