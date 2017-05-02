package com.at.dto.factory.invoice.product;

import com.at.dto.factory.catalogs.added.value.type.AddedValueTypeDTOFactory;
import com.at.dto.factory.catalogs.measure.unit.MeasureUnitDTOFactory;
import com.at.dto.in.invoice.product.InvoiceProductInDTO;
import com.at.dto.out.IdentifiedOutDTO;
import com.at.dto.out.IdentifierOutDTO;
import com.at.dto.out.invoice.product.InvoiceProductOutDTO;
import com.at.model.entity.enums.Placement;
import com.at.model.entity.invoice.Invoice;
import com.at.model.entity.invoice.product.InvoiceProduct;
import com.at.service.catalogs.added.value.type.AddedValueTypeService;
import com.at.service.catalogs.measure.unit.MeasureUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InvoiceProductDTOFactoryImpl
    implements InvoiceProductDTOFactory
{

    @Autowired
    private MeasureUnitService measureUnitService;

    @Autowired
    private AddedValueTypeService addedValueTypeService;

    @Autowired
    private MeasureUnitDTOFactory measureUnitDTOFactory;

    @Autowired
    private AddedValueTypeDTOFactory addedValueTypeDTOFactory;

    @Override
    public IdentifiedOutDTO createIdentifierOutDTO(InvoiceProduct model)
    {
        IdentifierOutDTO outDTO = new IdentifierOutDTO();
        outDTO.setId(model.getId());
        return outDTO;
    }

    @Override
    public InvoiceProduct createModel(Invoice invoice, InvoiceProductInDTO inDTO)
    {
        InvoiceProduct model = new InvoiceProduct();
        model.setInvoice(invoice);
        updateModel(inDTO, model, invoice);
        return model;
    }

    @Override
    public InvoiceProductOutDTO createOutDTO(InvoiceProduct model)
    {
        InvoiceProductOutDTO outDTO = new InvoiceProductOutDTO();
        fillPrimaryInfo(outDTO, model);
        return outDTO;
    }

    @Override
    public List<InvoiceProductOutDTO> createListOutDTO(List<InvoiceProduct> modelList)
    {
        List<InvoiceProductOutDTO> outDTOList = new ArrayList<>();
        for (InvoiceProduct model: modelList)
        {
            outDTOList.add(createOutDTO(model));
        }
        return outDTOList;
    }

    @Override
    public void fillPrimaryInfo(
            InvoiceProductOutDTO outDTO,
            InvoiceProduct model)
    {
        outDTO.setId(model.getId());
        outDTO.setTitle(model.getTitle());
        outDTO.setAddedValueType(addedValueTypeDTOFactory.createOutDTO(model.getAddedValueType()));
        outDTO.setAmount(model.getAmount());
        outDTO.setCode(model.getCode());
        outDTO.setInvoiceId(model.getInvoice().getId());
        outDTO.setMeasureUnit(measureUnitDTOFactory.createOutDTO(model.getMeasureUnit()));
        outDTO.setSingleCost(model.getSingleCost());
        outDTO.setVat(model.getVat());
    }

    @Override
    public void updateModel(
            InvoiceProductInDTO inDTO,
            InvoiceProduct model,
            Invoice invoice)
    {
        model.setTitle(inDTO.getTitle());
        model.setInvoice(invoice);
        model.setCode(inDTO.getCode());
        model.setAmount(inDTO.getAmount());
        model.setSingleCost(inDTO.getSingleCost());
        model.setVat(inDTO.getVat());
        model.setPlacement(Placement.valueOf(inDTO.getPlacement()));
        model.setMeasureUnit(measureUnitService.findById(inDTO.getMeasureUnitId()));
        model.setAddedValueType(addedValueTypeService.findById(inDTO.getAddedValueTypeId()));
    }

}
