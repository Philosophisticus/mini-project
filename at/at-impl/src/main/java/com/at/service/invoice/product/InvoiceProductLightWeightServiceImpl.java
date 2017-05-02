package com.at.service.invoice.product;

import com.at.dto.factory.invoice.product.InvoiceProductDTOFactory;
import com.at.dto.in.invoice.product.InvoiceProductInDTO;
import com.at.dto.out.IdentifiedOutDTO;
import com.at.dto.out.invoice.product.InvoiceProductOutDTO;
import com.at.exception.AppException;
import com.at.exception.factory.AppExceptionFactory;
import com.at.exception.invoice.InvoiceIsConfirmedException;
import com.at.model.entity.invoice.Invoice;
import com.at.model.entity.invoice.product.InvoiceProduct;
import com.at.service.invoice.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InvoiceProductLightWeightServiceImpl
    implements InvoiceProductLightWeightService
{

    @Autowired
    private AppExceptionFactory appExceptionFactory;

    @Autowired
    private InvoiceProductService invoiceProductService;

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private InvoiceProductDTOFactory invoiceProductDTOFactory;


    @Transactional
    @Override
    public List<InvoiceProductOutDTO> findByInvoiceId(Long invoiceId)
            throws AppException
    {
        final List<InvoiceProduct> modelList = invoiceProductService.findByInvoiceId(invoiceId);
        return invoiceProductDTOFactory.createListOutDTO(modelList);
    }

    @Transactional
    @Override
    public InvoiceProductOutDTO findById(Long id)
            throws AppException
    {
        final InvoiceProduct model = invoiceProductService.findById(id);
        return invoiceProductDTOFactory.createOutDTO(model);
    }

    @Transactional
    @Override
    public InvoiceProductOutDTO createNew(
            Long invoiceId,
            InvoiceProductInDTO inDTO)
    {
        final Invoice invoice = invoiceService.findById(invoiceId);

        if (invoice.getConfirmed())
            throw appExceptionFactory.getAppException(InvoiceIsConfirmedException.class);

        final InvoiceProduct model = invoiceProductDTOFactory.createModel(invoice, inDTO);
        return invoiceProductDTOFactory.createOutDTO(invoiceProductService.save(model));
    }

    @Transactional
    @Override
    public InvoiceProductOutDTO update(
            Long invoiceId,
            Long id,
            InvoiceProductInDTO inDTO)
            throws AppException
    {
        final Invoice invoice = invoiceService.findById(invoiceId);

        if (invoice.getConfirmed())
            throw appExceptionFactory.getAppException(InvoiceIsConfirmedException.class);

        final InvoiceProduct model = invoiceProductService.findById(id);

        if (!model.getInvoice().getId().equals(invoiceId))
            throw new AppException();

        invoiceProductDTOFactory.updateModel(inDTO, model, invoice);
        return invoiceProductDTOFactory.createOutDTO(invoiceProductService.save(model));
    }

    @Transactional
    @Override
    public IdentifiedOutDTO<Long> delete(
            Long invoiceId,
            Long id)
            throws AppException
    {
        final Invoice invoice = invoiceService.findById(invoiceId);

        if (invoice.getConfirmed())
            throw appExceptionFactory.getAppException(InvoiceIsConfirmedException.class);

        final InvoiceProduct model = invoiceProductService.findById(id);

        if (!model.getInvoice().getId().equals(invoiceId))
            throw new AppException();

        invoiceProductService.delete(model);
        return invoiceProductDTOFactory.createIdentifierOutDTO(model);
    }

}
