package com.at.service.invoice.product;

import com.at.dto.in.invoice.product.InvoiceProductInDTO;
import com.at.dto.out.IdentifiedOutDTO;
import com.at.dto.out.invoice.product.InvoiceProductOutDTO;
import com.at.exception.AppException;

import java.util.List;

public interface InvoiceProductLightWeightService
{

    List<InvoiceProductOutDTO> findByInvoiceId(
            final Long invoiceId)
            throws
            AppException;

    InvoiceProductOutDTO findById(
            final Long id)
            throws
            AppException;

    InvoiceProductOutDTO createNew(
            final Long invoiceId,
            final InvoiceProductInDTO inDTO);

    InvoiceProductOutDTO update(
            final Long invoiceId,
            final Long id,
            final InvoiceProductInDTO inDTO)
            throws
            AppException;

    IdentifiedOutDTO<Long> delete(
            final Long invoiceId,
            final Long id)
            throws
            AppException;

}
