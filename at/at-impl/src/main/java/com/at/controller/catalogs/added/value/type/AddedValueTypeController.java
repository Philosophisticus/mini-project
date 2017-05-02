package com.at.controller.catalogs.added.value.type;

import com.at.dto.in.catalogs.added.value.type.AddedValueTypeInDTO;
import com.at.dto.out.IdentifiedOutDTO;
import com.at.dto.out.catalogs.added.value.type.AddedValueTypeOutDTO;
import com.at.service.catalogs.added.value.type.AddedValueTypeLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/addedValueType")
public class AddedValueTypeController
{

    @Autowired
    private AddedValueTypeLightWeightService lightWeightService;

    @RequestMapping(method = RequestMethod.GET)
    public List<AddedValueTypeOutDTO> findAll()
    {
        return lightWeightService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public AddedValueTypeOutDTO findById(
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
    public AddedValueTypeOutDTO createNew(
            @RequestBody @Valid AddedValueTypeInDTO inDTO)
    {
        return lightWeightService.createNew(inDTO);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public AddedValueTypeOutDTO update(
            @PathVariable("id") Long id,
            @RequestBody @Valid AddedValueTypeInDTO inDTO)
    {
        return lightWeightService.update(id, inDTO);
    }

}
