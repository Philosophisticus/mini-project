package com.at.dto.out.catalogs;


import com.at.dto.out.IdentifiedOutDTO;
import com.at.model.enums.DictionaryStatusType;

import java.io.Serializable;


public abstract class CatalogOutDTO<
        ID extends Serializable>
    extends IdentifiedOutDTO<ID>
{

    private DictionaryStatusType dictionaryStatusType;

    public DictionaryStatusType getDictionaryStatusType() {
        return dictionaryStatusType;
    }

    public void setDictionaryStatusType(DictionaryStatusType dictionaryStatusType) {
        this.dictionaryStatusType = dictionaryStatusType;
    }

}