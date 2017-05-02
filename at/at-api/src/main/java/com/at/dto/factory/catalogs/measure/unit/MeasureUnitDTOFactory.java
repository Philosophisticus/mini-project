package com.at.dto.factory.catalogs.measure.unit;

import com.at.dto.factory.DTOFactoryMethods;
import com.at.dto.in.catalogs.measure.unit.MeasureUnitInDTO;
import com.at.dto.out.catalogs.measure.unit.MeasureUnitOutDTO;
import com.at.model.entity.catalogs.measure.unit.MeasureUnit;

public interface MeasureUnitDTOFactory
        extends DTOFactoryMethods.CreateModel<MeasureUnit, MeasureUnitInDTO>,
                DTOFactoryMethods.CreateOutDTO<MeasureUnit, MeasureUnitOutDTO>,
                DTOFactoryMethods.CreateListOutDTO<MeasureUnit, MeasureUnitOutDTO>,
                DTOFactoryMethods.CreateIdentifierOutDTO<MeasureUnit>,
                DTOFactoryMethods.FillPrimaryInfo<MeasureUnit, MeasureUnitOutDTO>,
                DTOFactoryMethods.UpdateModel<MeasureUnit, MeasureUnitInDTO>
{
}
