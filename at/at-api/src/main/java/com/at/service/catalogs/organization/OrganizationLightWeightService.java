package com.at.service.catalogs.organization;

import com.at.dto.in.catalogs.organization.OrganizationInDTO;
import com.at.dto.out.catalogs.organization.OrganizationOutDTO;
import com.at.service.catalogs.CatalogLightWeightService;

public interface OrganizationLightWeightService
    extends CatalogLightWeightService<Long, OrganizationOutDTO, OrganizationInDTO>
{
}
