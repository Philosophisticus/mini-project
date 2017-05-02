package com.at.service.invoice.product;

import com.at.model.entity.invoice.product.InvoiceProduct;
import com.at.service.GenericService;

import java.util.List;

public interface InvoiceProductService
    extends GenericService<InvoiceProduct, Long>
{

    List<InvoiceProduct> findByInvoiceId(Long invoiceId);

}
