package com.at.dto.factory.catalogs.organization;

import com.at.dto.in.catalogs.organization.OrganizationInDTO;
import com.at.dto.out.IdentifiedOutDTO;
import com.at.dto.out.IdentifierOutDTO;
import com.at.dto.out.catalogs.organization.OrganizationOutDTO;
import com.at.model.entity.catalogs.organization.Organization;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrganizationDTOFactoryImpl
    implements OrganizationDTOFactory
{

    @Override
    public IdentifiedOutDTO createIdentifierOutDTO(Organization model)
    {
        IdentifierOutDTO outDTO = new IdentifierOutDTO();
        outDTO.setId(model.getId());
        return outDTO;
    }

    @Override
    public Organization createModel(OrganizationInDTO inDTO)
    {
        Organization model = new Organization();
        updateModel(inDTO, model);
        return model;
    }

    @Override
    public OrganizationOutDTO createOutDTO(Organization model)
    {
        OrganizationOutDTO outDTO = new OrganizationOutDTO();
        fillPrimaryInfo(outDTO, model);
        return outDTO;
    }

    @Override
    public List<OrganizationOutDTO> createListOutDTO(List<Organization> modelList)
    {
        List<OrganizationOutDTO> outDTOList = new ArrayList<>();
        for (Organization model: modelList)
        {
            outDTOList.add(createOutDTO(model));
        }
        return outDTOList;
    }

    @Override
    public void fillPrimaryInfo(
            OrganizationOutDTO outDTO,
            Organization model)
    {
        outDTO.setId(model.getId());
        outDTO.setDictionaryStatusType(model.getDictionaryStatusType());
        outDTO.setTitle(model.getTitle());
    }

    @Override
    public void updateModel(
            OrganizationInDTO inDTO,
            Organization model)
    {
        model.setTitle(inDTO.getTitle());
    }
}
