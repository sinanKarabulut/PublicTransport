package com.simsoft.transport.model;

import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ROUTE_VEHICLE")
@DynamicInsert
@DynamicUpdate
@ToString
public class RouteVehicle  implements Serializable {
    private long routeVehicleId;
    private Vehicle vehicle;
    private Route route;
    private boolean statu;

    @Id
    @Column(name = "ROUTE_VEHICLE_ID", unique = true, nullable = false, precision = 12, scale = 0)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getRouteVehicleId() {
        return routeVehicleId;
    }

    public void setRouteVehicleId(long routeVehicleId) {
        this.routeVehicleId = routeVehicleId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VEHICLE_ID")
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROUTE_ID")
    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Column(name="STATU")
    public boolean isStatu() {
        return statu;
    }

    public void setStatu(boolean statu) {
        this.statu = statu;
    }
}
