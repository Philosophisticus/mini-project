package com.at.exception.invoice.product;

import com.at.aspects.annotation.AppExceptionKey;
import com.at.exception.AppException;

@AppExceptionKey("app.err.invoice.product.not.found")
public class InvoiceProductNotFoundException extends AppException
{

    private static final long serialVersionUID = 1L;

}
