package com.at.repository.invoice.product;

import com.at.model.entity.invoice.product.InvoiceProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceProductRepository
        extends JpaRepository<InvoiceProduct, Long>
{

    List<InvoiceProduct> findByInvoiceId(Long invoiceId);

}
