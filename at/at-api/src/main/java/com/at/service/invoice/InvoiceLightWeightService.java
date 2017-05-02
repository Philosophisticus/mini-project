package com.at.service.invoice;

import com.at.dto.in.invoice.InvoiceInDTO;
import com.at.dto.in.invoice.InvoicePaymentInDTO;
import com.at.dto.out.IdentifiedOutDTO;
import com.at.dto.out.invoice.InvoiceOutDTO;
import com.at.exception.AppException;

import java.util.List;

public interface InvoiceLightWeightService
{

    List<InvoiceOutDTO> findAll()
            throws
            AppException;

    InvoiceOutDTO findById(
            final Long id)
            throws
            AppException;

    InvoiceOutDTO createNew(
            final InvoiceInDTO inDTO);

    InvoiceOutDTO update(
            final Long id,
            final InvoiceInDTO inDTO)
            throws
            AppException;

    InvoiceOutDTO pay(
            final Long id,
            final InvoicePaymentInDTO inDTO)
            throws
            AppException;

    InvoiceOutDTO confirm(
            final Long id)
            throws
            AppException;

    IdentifiedOutDTO<Long> delete(
            final Long id)
            throws
            AppException;

}
