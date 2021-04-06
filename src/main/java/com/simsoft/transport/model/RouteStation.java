package com.simsoft.transport.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ROUTE_STATION")
@Data
public class RouteStation extends BaseEntity {
    @Id
    @Column(name = "ROUTE_STATION_ID", unique = true, nullable = false, precision = 12, scale = 0)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private long routeStationId;
    @Column(name="STATION_ID")
    private Long stationId;
    @Column(name="ROUTE_ID")
    private Long routeId;

}
