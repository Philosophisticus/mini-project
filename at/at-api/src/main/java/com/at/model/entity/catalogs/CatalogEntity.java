package com.at.model.entity.catalogs;

import com.at.model.entity.AuditableEntity;
import com.at.model.enums.DictionaryStatusType;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class CatalogEntity<PK extends Serializable>
    extends AuditableEntity<PK>
{

    @Enumerated(value = EnumType.STRING)
    @Column(name = "DICTIONARY_STATUS", nullable = false)
    private DictionaryStatusType dictionaryStatusType;


    // ********************************************************************************************************** start
    // *** public methods ***

    public DictionaryStatusType getDictionaryStatusType() {
        return dictionaryStatusType;
    }

    public void setDictionaryStatusType(DictionaryStatusType dictinoaryStatusType) {
        this.dictionaryStatusType = dictinoaryStatusType;
    }

    // ********************************************************************************************************** end


}
