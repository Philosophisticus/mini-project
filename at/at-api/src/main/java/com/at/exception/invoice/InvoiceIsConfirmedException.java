package com.at.exception.invoice;

import com.at.aspects.annotation.AppExceptionKey;
import com.at.exception.AppException;

@AppExceptionKey("app.err.invoice.is.confirmed")
public class InvoiceIsConfirmedException extends AppException
{

    private static final long serialVersionUID = 1L;

}
