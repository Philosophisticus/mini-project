package com.at.repository.invoice;

import com.at.model.entity.invoice.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>
{
}
