package com.at.controller.invoice.product;

import com.at.dto.in.invoice.product.InvoiceProductInDTO;
import com.at.dto.out.IdentifiedOutDTO;
import com.at.dto.out.invoice.product.InvoiceProductOutDTO;
import com.at.service.invoice.product.InvoiceProductLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/invoice/{invoiceId}/invoiceProduct")
public class InvoiceProductController
{
    @Autowired
    private InvoiceProductLightWeightService lightWeightService;

    @RequestMapping(method = RequestMethod.GET)
    public List<InvoiceProductOutDTO> findByInvoiceId(
            @PathVariable("invoiceId") Long invoiceId)
    {
        return lightWeightService.findByInvoiceId(invoiceId);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public InvoiceProductOutDTO findById(
            @PathVariable("id") Long id)
    {
        return lightWeightService.findById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public IdentifiedOutDTO<Long> delete(
            @PathVariable("invoiceId") Long invoiceId,
            @PathVariable("id") Long id)
    {
        return lightWeightService.delete(invoiceId, id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public InvoiceProductOutDTO createNew(
            @PathVariable("invoiceId") Long invoiceId,
            @RequestBody @Valid InvoiceProductInDTO inDTO)
    {
        return lightWeightService.createNew(invoiceId, inDTO);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public InvoiceProductOutDTO update(
            @PathVariable("invoiceId") Long invoiceId,
            @PathVariable("id") Long id,
            @RequestBody @Valid InvoiceProductInDTO inDTO)
    {
        return lightWeightService.update(invoiceId, id, inDTO);
    }
}
