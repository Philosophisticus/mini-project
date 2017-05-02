package com.at.repository.catalogs;

import com.at.model.entity.catalogs.CatalogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface CatalogRepository<T extends CatalogEntity<ID>, ID extends Serializable>
        extends JpaRepository<T, ID>
{

    @Modifying
    @Query("update #{#entityName} t set t.dictionaryStatusType = 'DELETED' where t.id = :id")
    void deleteEntity(@Param("id") ID id);

    @Query(value = "select t from #{#entityName} t where t.dictionaryStatusType = 'ACTIVE'")
    List<T> findAllEntities();

}
