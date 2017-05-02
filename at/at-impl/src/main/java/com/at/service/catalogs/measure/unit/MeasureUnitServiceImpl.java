package com.at.service.catalogs.measure.unit;

import com.at.exception.catalogs.measure.unit.MeasureUnitNotFoundException;
import com.at.model.entity.catalogs.measure.unit.MeasureUnit;
import com.at.service.catalogs.TitledCatalogServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class MeasureUnitServiceImpl
    extends TitledCatalogServiceImpl<MeasureUnit, Long, MeasureUnitNotFoundException>
    implements MeasureUnitService
{
}
