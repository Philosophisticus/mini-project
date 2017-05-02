package com.at.service.invoice;

import com.at.exception.invoice.InvoiceNotFoundException;
import com.at.model.entity.invoice.Invoice;
import com.at.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl
    extends GenericServiceImpl<Invoice, Long, InvoiceNotFoundException>
    implements InvoiceService
{
}
