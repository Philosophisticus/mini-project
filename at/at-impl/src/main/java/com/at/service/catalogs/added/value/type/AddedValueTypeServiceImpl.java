package com.at.service.catalogs.added.value.type;

import com.at.exception.catalogs.added.value.type.AddedValueTypeNotFoundException;
import com.at.model.entity.catalogs.added.value.type.AddedValueType;
import com.at.service.catalogs.TitledCatalogServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AddedValueTypeServiceImpl
    extends TitledCatalogServiceImpl<AddedValueType, Long, AddedValueTypeNotFoundException>
    implements AddedValueTypeService
{
}
