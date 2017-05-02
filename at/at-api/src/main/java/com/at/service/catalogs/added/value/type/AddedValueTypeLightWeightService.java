package com.at.service.catalogs.added.value.type;

import com.at.dto.in.catalogs.added.value.type.AddedValueTypeInDTO;
import com.at.dto.out.catalogs.added.value.type.AddedValueTypeOutDTO;
import com.at.service.catalogs.CatalogLightWeightService;

public interface AddedValueTypeLightWeightService
    extends CatalogLightWeightService<Long, AddedValueTypeOutDTO, AddedValueTypeInDTO>
{
}
