package com.at.model.entity.catalogs.organization;

import com.at.model.entity.catalogs.TitledCatalogEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "ORGANIZATION")
@AttributeOverrides({
        @AttributeOverride(name = "title", column = @Column(name = "TITLE", nullable = false))
})
public class Organization extends TitledCatalogEntity<Long>
{
}
