package com.at.model.entity;

import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableEntity<PK extends Serializable> extends IdentifiedEntity<PK>
{

    @Column(name = "LAST_MODIFIED_USER_ID", nullable = false)
    @LastModifiedBy
    private String lastModifiedUser;

    @Column(name = "MODIFICATION_DATE", nullable = false)
    @LastModifiedDate
    private DateTime modificationDate;

    @Column(name = "CREATED_BY_USER_ID", nullable = false)
    @CreatedBy
    private String createdByUser;

    @Column(name = "CREATION_DATE", nullable = false)
    @CreatedDate
    private DateTime creationDate;


    // ********************************************************************************************************** start
    // *** public methods ***

    public String getLastModifiedUser()
    {
        return lastModifiedUser;
    }

    public void setLastModifiedUser(String lastModifiedUser)
    {
        this.lastModifiedUser = lastModifiedUser;
    }

    public DateTime getModificationDate()
    {
        return modificationDate;
    }

    public void setModificationDate(DateTime modificationDate)
    {
        this.modificationDate = modificationDate;
    }

    public String getCreatedByUser()
    {
        return createdByUser;
    }

    public void setCreatedByUser(String createdByUser)
    {
        this.createdByUser = createdByUser;
    }

    public DateTime getCreationDate()
    {
        return creationDate;
    }

    public void setCreationDate(DateTime creationDate)
    {
        this.creationDate = creationDate;
    }

    // ********************************************************************************************************** end


}
