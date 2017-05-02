package com.at.controller.invoice;

import com.at.dto.in.invoice.InvoiceInDTO;
import com.at.dto.in.invoice.InvoicePaymentInDTO;
import com.at.dto.out.IdentifiedOutDTO;
import com.at.dto.out.invoice.InvoiceOutDTO;
import com.at.service.invoice.InvoiceLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/invoice")
public class InvoiceController
{

    @Autowired
    private InvoiceLightWeightService lightWeightService;

    @RequestMapping(method = RequestMethod.GET)
    public List<InvoiceOutDTO> findAll()
    {
        return lightWeightService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public InvoiceOutDTO findById(
            @PathVariable("id") Long id)
    {
        return lightWeightService.findById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public IdentifiedOutDTO<Long> delete(
            @PathVariable("id") Long id)
    {
        return lightWeightService.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public InvoiceOutDTO createNew(
            @RequestBody @Valid InvoiceInDTO inDTO)
    {
        return lightWeightService.createNew(inDTO);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public InvoiceOutDTO update(
            @PathVariable("id") Long id,
            @RequestBody @Valid InvoiceInDTO inDTO)
    {
        return lightWeightService.update(id, inDTO);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "pay/{id}")
    public InvoiceOutDTO pay(
            @PathVariable("id") Long id,
            @RequestBody @Valid InvoicePaymentInDTO inDTO)
    {
        return lightWeightService.pay(id, inDTO);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "confirm/{id}")
    public InvoiceOutDTO confirm(
            @PathVariable("id") Long id)
    {
        return lightWeightService.confirm(id);
    }

}
