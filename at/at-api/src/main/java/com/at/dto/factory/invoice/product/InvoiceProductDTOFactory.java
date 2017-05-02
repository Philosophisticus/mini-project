package com.at.dto.factory.invoice.product;

import com.at.dto.factory.DTOFactoryMethods;
import com.at.dto.in.invoice.product.InvoiceProductInDTO;
import com.at.dto.out.invoice.product.InvoiceProductOutDTO;
import com.at.model.entity.invoice.Invoice;
import com.at.model.entity.invoice.product.InvoiceProduct;

public interface InvoiceProductDTOFactory
        extends DTOFactoryMethods.CreateOutDTO<InvoiceProduct, InvoiceProductOutDTO>,
                DTOFactoryMethods.CreateIdentifierOutDTO<InvoiceProduct>,
                DTOFactoryMethods.FillPrimaryInfo<InvoiceProduct, InvoiceProductOutDTO>,
                DTOFactoryMethods.CreateListOutDTO<InvoiceProduct, InvoiceProductOutDTO>
{

    InvoiceProduct createModel(
            Invoice invoice,
            InvoiceProductInDTO inDTO);

    void updateModel(
            InvoiceProductInDTO inDTO,
            InvoiceProduct model,
            Invoice invoice);

}
