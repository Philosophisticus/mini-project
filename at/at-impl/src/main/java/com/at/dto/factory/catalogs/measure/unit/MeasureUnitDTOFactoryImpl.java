package com.at.dto.factory.catalogs.measure.unit;

import com.at.dto.in.catalogs.measure.unit.MeasureUnitInDTO;
import com.at.dto.out.IdentifiedOutDTO;
import com.at.dto.out.IdentifierOutDTO;
import com.at.dto.out.catalogs.measure.unit.MeasureUnitOutDTO;
import com.at.model.entity.catalogs.measure.unit.MeasureUnit;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MeasureUnitDTOFactoryImpl
    implements MeasureUnitDTOFactory
{

    @Override
    public IdentifiedOutDTO createIdentifierOutDTO(MeasureUnit model)
    {
        IdentifierOutDTO outDTO = new IdentifierOutDTO();
        outDTO.setId(model.getId());
        return outDTO;
    }

    @Override
    public MeasureUnit createModel(MeasureUnitInDTO inDTO)
    {
        MeasureUnit model = new MeasureUnit();
        updateModel(inDTO, model);
        return model;
    }

    @Override
    public MeasureUnitOutDTO createOutDTO(MeasureUnit model)
    {
        MeasureUnitOutDTO outDTO = new MeasureUnitOutDTO();
        fillPrimaryInfo(outDTO, model);
        return outDTO;
    }

    @Override
    public List<MeasureUnitOutDTO> createListOutDTO(List<MeasureUnit> modelList)
    {
        List<MeasureUnitOutDTO> outDTOList = new ArrayList<>();
        for (MeasureUnit model: modelList)
        {
            outDTOList.add(createOutDTO(model));
        }
        return outDTOList;
    }

    @Override
    public void fillPrimaryInfo(
            MeasureUnitOutDTO outDTO,
            MeasureUnit model)
    {
        outDTO.setId(model.getId());
        outDTO.setDictionaryStatusType(model.getDictionaryStatusType());
        outDTO.setTitle(model.getTitle());
    }

    @Override
    public void updateModel(
            MeasureUnitInDTO inDTO,
            MeasureUnit model)
    {
        model.setTitle(inDTO.getTitle());
    }

}
