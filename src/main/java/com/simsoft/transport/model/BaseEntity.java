package com.simsoft.transport.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@MappedSuperclass // bütün classlarda veritabanında extend edilebilmesini sağlar
public abstract class BaseEntity implements Serializable {
    @Column(name="STATUS")
    private boolean status=true;
}
