package com.at.dto.factory.catalogs.organization;

import com.at.dto.factory.DTOFactoryMethods;
import com.at.dto.in.catalogs.organization.OrganizationInDTO;
import com.at.dto.out.catalogs.organization.OrganizationOutDTO;
import com.at.model.entity.catalogs.organization.Organization;

public interface OrganizationDTOFactory
        extends DTOFactoryMethods.CreateModel<Organization, OrganizationInDTO>,
                DTOFactoryMethods.CreateOutDTO<Organization, OrganizationOutDTO>,
                DTOFactoryMethods.CreateListOutDTO<Organization, OrganizationOutDTO>,
                DTOFactoryMethods.CreateIdentifierOutDTO<Organization>,
                DTOFactoryMethods.FillPrimaryInfo<Organization, OrganizationOutDTO>,
                DTOFactoryMethods.UpdateModel<Organization, OrganizationInDTO>
{
}
