package com.at.dto.factory.catalogs.added.value.type;

import com.at.dto.in.catalogs.added.value.type.AddedValueTypeInDTO;
import com.at.dto.out.IdentifiedOutDTO;
import com.at.dto.out.IdentifierOutDTO;
import com.at.dto.out.catalogs.added.value.type.AddedValueTypeOutDTO;
import com.at.model.entity.catalogs.added.value.type.AddedValueType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddedValueTypeDTOFactoryImpl
    implements AddedValueTypeDTOFactory
{

    @Override
    public IdentifiedOutDTO createIdentifierOutDTO(AddedValueType model)
    {
        IdentifierOutDTO outDTO = new IdentifierOutDTO();
        outDTO.setId(model.getId());
        return outDTO;
    }

    @Override
    public AddedValueType createModel(AddedValueTypeInDTO inDTO)
    {
        AddedValueType model = new AddedValueType();
        updateModel(inDTO, model);
        return model;
    }

    @Override
    public AddedValueTypeOutDTO createOutDTO(AddedValueType model)
    {
        AddedValueTypeOutDTO outDTO = new AddedValueTypeOutDTO();
        fillPrimaryInfo(outDTO, model);
        return outDTO;
    }

    @Override
    public List<AddedValueTypeOutDTO> createListOutDTO(List<AddedValueType> modelList)
    {
        List<AddedValueTypeOutDTO> outDTOList = new ArrayList<>();
        for (AddedValueType model: modelList)
        {
            outDTOList.add(createOutDTO(model));
        }
        return outDTOList;
    }

    @Override
    public void fillPrimaryInfo(
            AddedValueTypeOutDTO outDTO,
            AddedValueType model)
    {
        outDTO.setId(model.getId());
        outDTO.setDictionaryStatusType(model.getDictionaryStatusType());
        outDTO.setTitle(model.getTitle());
        outDTO.setValue(model.getValue());
    }

    @Override
    public void updateModel(
            AddedValueTypeInDTO inDTO,
            AddedValueType model)
    {
        model.setTitle(inDTO.getTitle());
        model.setValue(inDTO.getValue());
    }

}
