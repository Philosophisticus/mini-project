package com.at.model.entity.catalogs.added.value.type;

import com.at.model.entity.catalogs.TitledCatalogEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "ADDED_VALUE_TYPE")
@AttributeOverrides({
        @AttributeOverride(name = "title", column = @Column(name = "TITLE", nullable = false))
})
public class AddedValueType extends TitledCatalogEntity<Long>
{

    @Column(name = "VALUE", nullable = false)
    private Long value;


    // ********************************************************************************************************** start
    // *** get/set methods ***

    public Long getValue()
    {
        return value;
    }

    public void setValue(Long value)
    {
        this.value = value;
    }

    // ********************************************************************************************************** end

}
