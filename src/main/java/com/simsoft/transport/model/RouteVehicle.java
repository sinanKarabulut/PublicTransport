package com.simsoft.transport.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ROUTE_VEHICLE")
@Data
public class RouteVehicle  extends BaseEntity {
    @Id
    @Column(name = "ROUTE_VEHICLE_ID", unique = true, nullable = false, precision = 12, scale = 0)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private long routeVehicleId;
    @JoinColumn(name="VEHICLE_ID")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Vehicle vehicle;
    @JoinColumn(name="ROUTE_ID")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Route route;

}
