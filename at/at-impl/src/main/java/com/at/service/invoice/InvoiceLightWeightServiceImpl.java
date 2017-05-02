package com.at.service.invoice;

import com.at.dto.factory.invoice.InvoiceDTOFactory;
import com.at.dto.in.invoice.InvoiceInDTO;
import com.at.dto.in.invoice.InvoicePaymentInDTO;
import com.at.dto.out.IdentifiedOutDTO;
import com.at.dto.out.invoice.InvoiceOutDTO;
import com.at.exception.AppException;
import com.at.exception.factory.AppExceptionFactory;
import com.at.model.entity.invoice.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InvoiceLightWeightServiceImpl
    implements InvoiceLightWeightService
{

    @Autowired
    private AppExceptionFactory appExceptionFactory;

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private InvoiceDTOFactory invoiceDTOFactory;

    @Transactional
    @Override
    public List<InvoiceOutDTO> findAll()
            throws AppException
    {
        final List<Invoice> modelList = invoiceService.findAll();
        return invoiceDTOFactory.createListOutDTO(modelList);
    }

    @Transactional
    @Override
    public InvoiceOutDTO findById(Long id)
            throws AppException
    {
        final Invoice model = invoiceService.findById(id);
        return invoiceDTOFactory.createOutDTO(model);
    }

    @Transactional
    @Override
    public InvoiceOutDTO createNew(
            InvoiceInDTO inDTO)
    {
        final Invoice model = invoiceDTOFactory.createModel(inDTO);
        return invoiceDTOFactory.createOutDTO(invoiceService.save(model));
    }

    @Transactional
    @Override
    public InvoiceOutDTO update(
            Long id,
            InvoiceInDTO inDTO)
            throws AppException
    {
        final Invoice model = invoiceService.findById(id);
        invoiceDTOFactory.updateModel(inDTO, model);
        return invoiceDTOFactory.createOutDTO(invoiceService.save(model));
    }

    @Transactional
    @Override
    public InvoiceOutDTO pay(
            Long id,
            InvoicePaymentInDTO inDTO)
            throws AppException
    {
        final Invoice model = invoiceService.findById(id);
        invoiceDTOFactory.updateModel(inDTO, model);
        return invoiceDTOFactory.createOutDTO(invoiceService.save(model));
    }

    @Transactional
    @Override
    public InvoiceOutDTO confirm(Long id)
            throws AppException
    {
        final Invoice model = invoiceService.findById(id);
        invoiceDTOFactory.confirm(model);
        return invoiceDTOFactory.createOutDTO(invoiceService.save(model));
    }

    @Transactional
    @Override
    public IdentifiedOutDTO<Long> delete(Long id)
            throws AppException
    {
        final Invoice model = invoiceService.findById(id);
        invoiceService.delete(model);
        return invoiceDTOFactory.createOutDTO(model);
    }

}
