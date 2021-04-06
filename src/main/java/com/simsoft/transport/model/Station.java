package com.simsoft.transport.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;

@Entity // jpa annotation
@Table(name="STATION")
@Data
public class Station extends  BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "seq")
    @GenericGenerator(name = "seq", strategy="increment")
    @Column(name="STATION_ID")
    private long stationId;
    @Column(name="STATION_NAME")
    private String stationName;
}
