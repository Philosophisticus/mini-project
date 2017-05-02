package com.at.model.entity;

import javax.persistence.*;
import java.io.Serializable;


@MappedSuperclass
public abstract class IdentifiedEntity<PK extends Serializable>
        implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private PK id;


    public PK getId()
    {
        return id;
    }

    public void setId(PK id)
    {
        this.id = id;
    }

    @Transient
    public boolean isNew()
    {
        return null == getId();
    }

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();

        result.append(this.getClass().getName());
        result.append(" [");
        result.append("id = ");
        result.append(id);
        result.append("]");

        return result.toString();
    }
}
