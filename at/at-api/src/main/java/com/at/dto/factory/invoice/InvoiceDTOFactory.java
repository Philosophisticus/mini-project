package com.at.dto.factory.invoice;

import com.at.dto.factory.DTOFactoryMethods;
import com.at.dto.in.invoice.InvoiceInDTO;
import com.at.dto.in.invoice.InvoicePaymentInDTO;
import com.at.dto.out.invoice.InvoiceOutDTO;
import com.at.model.entity.invoice.Invoice;

public interface InvoiceDTOFactory
        extends DTOFactoryMethods.CreateModel<Invoice, InvoiceInDTO>,
                DTOFactoryMethods.CreateOutDTO<Invoice, InvoiceOutDTO>,
                DTOFactoryMethods.CreateListOutDTO<Invoice, InvoiceOutDTO>,
                DTOFactoryMethods.CreateIdentifierOutDTO<Invoice>,
                DTOFactoryMethods.FillPrimaryInfo<Invoice, InvoiceOutDTO>,
                DTOFactoryMethods.UpdateModel<Invoice, InvoiceInDTO>
{

    void updateModel(InvoicePaymentInDTO inDTO, Invoice model);

    void confirm(Invoice model);

}
