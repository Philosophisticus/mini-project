package com.at.controller.catalogs.organization;

import com.at.dto.in.catalogs.organization.OrganizationInDTO;
import com.at.dto.out.IdentifiedOutDTO;
import com.at.dto.out.catalogs.organization.OrganizationOutDTO;
import com.at.service.catalogs.organization.OrganizationLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/organization")
public class OrganizationController
{

    @Autowired
    private OrganizationLightWeightService lightWeightService;

    @RequestMapping(method = RequestMethod.GET)
    public List<OrganizationOutDTO> findAll()
    {
        return lightWeightService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public OrganizationOutDTO findById(
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
    public OrganizationOutDTO createNew(
            @RequestBody @Valid OrganizationInDTO inDTO)
    {
        return lightWeightService.createNew(inDTO);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public OrganizationOutDTO update(
            @PathVariable("id") Long id,
            @RequestBody @Valid OrganizationInDTO inDTO)
    {
        return lightWeightService.update(id, inDTO);
    }

}
