package com.at.controller.catalogs.measure.unit;

import com.at.dto.in.catalogs.measure.unit.MeasureUnitInDTO;
import com.at.dto.out.IdentifiedOutDTO;
import com.at.dto.out.catalogs.measure.unit.MeasureUnitOutDTO;
import com.at.service.catalogs.measure.unit.MeasureUnitLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/measureUnit")
public class MeasureUnitController
{

    @Autowired
    private MeasureUnitLightWeightService lightWeightService;

    @RequestMapping(method = RequestMethod.GET)
    public List<MeasureUnitOutDTO> findAll()
    {
        return lightWeightService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public MeasureUnitOutDTO findById(
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
    public MeasureUnitOutDTO createNew(
            @RequestBody @Valid MeasureUnitInDTO inDTO)
    {
        return lightWeightService.createNew(inDTO);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public MeasureUnitOutDTO update(
            @PathVariable("id") Long id,
            @RequestBody @Valid MeasureUnitInDTO inDTO)
    {
        return lightWeightService.update(id, inDTO);
    }

}
