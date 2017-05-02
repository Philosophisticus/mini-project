package com.at.service.catalogs.organization;

import com.at.exception.catalogs.organization.OrganizationNotFoundException;
import com.at.model.entity.catalogs.organization.Organization;
import com.at.service.catalogs.TitledCatalogServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl
    extends TitledCatalogServiceImpl<Organization, Long, OrganizationNotFoundException>
    implements OrganizationService
{
}
