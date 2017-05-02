package com.at.repository.catalogs;

import com.at.model.entity.catalogs.TitledCatalogEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface TitledCatalogRepository<T extends TitledCatalogEntity<ID>, ID extends Serializable>
    extends CatalogRepository<T, ID>
{

    @Query("select t from #{#entityName} t " +
            "where t.dictionaryStatusType = com.at.model.enums.DictionaryStatusType.ACTIVE or " +
            "t.dictionaryStatusType = com.at.model.enums.DictionaryStatusType.ACTIVE_NOT_REMOVABLE " +
            "order by title asc")
    List<T> findAllByOrderByTitleAsc();

    T findByTitleIgnoreCase(String title);

    @Query(value = "select t from #{#entityName} t where lower(t.title) like lower(:title) " +
            "and t.dictionaryStatusType = 'ACTIVE' " +
            "order by length(title) asc, title asc")
    List<T> findActiveByTitleIgnoreCaseContaining(
            @Param("title") String title,
            Pageable pageRequest);

}
