package com.at.controller.catalogs.user;

import com.at.dto.in.catalogs.user.UserInDTO;
import com.at.dto.out.IdentifiedOutDTO;
import com.at.dto.out.catalogs.user.UserOutDTO;
import com.at.service.catalogs.user.UserLightWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController
{

    @Autowired
    private UserLightWeightService lightWeightService;

    @RequestMapping(method = RequestMethod.GET)
    public List<UserOutDTO> findAll()
    {
        return lightWeightService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public UserOutDTO findById(
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
    public UserOutDTO createNew(
            @RequestBody @Valid UserInDTO inDTO)
    {
        return lightWeightService.createNew(inDTO);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public UserOutDTO update(
            @PathVariable("id") Long id,
            @RequestBody @Valid UserInDTO inDTO)
    {
        return lightWeightService.update(id, inDTO);
    }

}
