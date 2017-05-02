package com.at.dto.factory.catalogs.added.value.type;

import com.at.dto.factory.DTOFactoryMethods;
import com.at.dto.in.catalogs.added.value.type.AddedValueTypeInDTO;
import com.at.dto.out.catalogs.added.value.type.AddedValueTypeOutDTO;
import com.at.model.entity.catalogs.added.value.type.AddedValueType;

public interface AddedValueTypeDTOFactory
    extends DTOFactoryMethods.CreateModel<AddedValueType, AddedValueTypeInDTO>,
            DTOFactoryMethods.CreateOutDTO<AddedValueType, AddedValueTypeOutDTO>,
            DTOFactoryMethods.CreateListOutDTO<AddedValueType, AddedValueTypeOutDTO>,
            DTOFactoryMethods.CreateIdentifierOutDTO<AddedValueType>,
            DTOFactoryMethods.FillPrimaryInfo<AddedValueType, AddedValueTypeOutDTO>,
            DTOFactoryMethods.UpdateModel<AddedValueType, AddedValueTypeInDTO>
{
}
