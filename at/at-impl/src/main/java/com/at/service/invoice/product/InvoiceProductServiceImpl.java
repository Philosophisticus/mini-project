package com.at.service.invoice.product;

import com.at.exception.invoice.product.InvoiceProductNotFoundException;
import com.at.model.entity.invoice.product.InvoiceProduct;
import com.at.repository.invoice.product.InvoiceProductRepository;
import com.at.service.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceProductServiceImpl
    extends GenericServiceImpl<InvoiceProduct, Long, InvoiceProductNotFoundException>
    implements InvoiceProductService
{

    @Autowired
    private InvoiceProductRepository invoiceProductRepository;

    @Override
    public List<InvoiceProduct> findByInvoiceId(Long invoiceId)
    {
        return invoiceProductRepository.findByInvoiceId(invoiceId);
    }

}
