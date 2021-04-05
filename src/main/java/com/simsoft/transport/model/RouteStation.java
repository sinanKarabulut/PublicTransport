package com.simsoft.transport.model;

import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ROUTE_STATION")
@DynamicInsert
@DynamicUpdate
@ToString
public class RouteStation implements Serializable {
    private long routeStationId;
    private Long stationId;
    private Long routeId;
    private boolean statu=true;

    @Id
    @Column(name = "ROUTE_STATION_ID", unique = true, nullable = false, precision = 12, scale = 0)
    public long getRouteStationId() {
        return routeStationId;
    }

    public void setRouteStationId(long routeStationId) {
        this.routeStationId = routeStationId;
    }

    @Column(name="STATU")
    public boolean isStatu() {
        return statu;
    }

    public void setStatu(boolean statu) {
        this.statu = statu;
    }

    @Column(name="STATION_ID")
    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    @Column(name="ROUTE_ID")
    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }
}
