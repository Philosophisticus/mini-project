package com.at.dto.factory.invoice;

import com.at.dto.factory.catalogs.organization.OrganizationDTOFactory;
import com.at.dto.in.invoice.InvoiceInDTO;
import com.at.dto.in.invoice.InvoicePaymentInDTO;
import com.at.dto.out.IdentifiedOutDTO;
import com.at.dto.out.IdentifierOutDTO;
import com.at.dto.out.invoice.InvoiceOutDTO;
import com.at.model.entity.invoice.Invoice;
import com.at.service.catalogs.organization.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InvoiceDTOFactoryImpl
    implements InvoiceDTOFactory
{

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    private OrganizationDTOFactory organizationDTOFactory;


    @Override
    public void updateModel(
            InvoicePaymentInDTO inDTO,
            Invoice model)
    {
        Long newCost = model.getPaidCost() + inDTO.getPaidCost();
        model.setPaidCost(newCost > model.getTotalCost() ? model.getTotalCost() : newCost);
    }

    @Override
    public void confirm(Invoice model)
    {
        model.setConfirmed(Boolean.TRUE);
    }

    @Override
    public IdentifiedOutDTO createIdentifierOutDTO(Invoice model)
    {
        IdentifierOutDTO outDTO = new IdentifierOutDTO();
        outDTO.setId(model.getId());
        return outDTO;
    }

    @Override
    public Invoice createModel(InvoiceInDTO inDTO)
    {
        Invoice model = new Invoice();
        updateModel(inDTO, model);
        return model;
    }

    @Override
    public InvoiceOutDTO createOutDTO(Invoice model)
    {
        InvoiceOutDTO outDTO = new InvoiceOutDTO();
        fillPrimaryInfo(outDTO, model);
        return outDTO;
    }

    @Override
    public List<InvoiceOutDTO> createListOutDTO(List<Invoice> modelList)
    {
        List<InvoiceOutDTO> outDTOList = new ArrayList<>();
        for (Invoice model: modelList)
        {
            outDTOList.add(createOutDTO(model));
        }
        return outDTOList;
    }

    @Override
    public void fillPrimaryInfo(
            InvoiceOutDTO outDTO,
            Invoice model)
    {
        outDTO.setId(model.getId());
        outDTO.setDateOfArrival(model.getDateOfArrival());
        outDTO.setConfirmed(model.getConfirmed());
        outDTO.setPaid(model.getPaid());
        outDTO.setMaxDateOfPayment(model.getMaxDateOfPayment());
        outDTO.setNumber(model.getNumber());
        outDTO.setOrganization(organizationDTOFactory.createOutDTO(model.getOrganization()));
        outDTO.setPaidCost(model.getPaidCost());
        outDTO.setTotalCost(model.getTotalCost());
    }

    @Override
    public void updateModel(
            InvoiceInDTO inDTO,
            Invoice model)
    {
        model.setDateOfArrival(inDTO.getDateOfArrival());
        model.setMaxDateOfPayment(inDTO.getMaxDateOfPayment());
        model.setNumber(inDTO.getNumber());
        model.setOrganization(organizationService.findById(inDTO.getOrganizationId()));
    }

}
