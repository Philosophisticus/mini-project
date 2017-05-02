package com.at.exception.catalogs.measure.unit;

import com.at.aspects.annotation.AppExceptionKey;
import com.at.exception.AppException;

@AppExceptionKey("app.err.measure.unit.not.found")
public class MeasureUnitNotFoundException extends AppException
{

    private static final long serialVersionUID = 1L;

}
