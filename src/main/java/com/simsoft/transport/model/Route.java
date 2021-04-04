package com.simsoft.transport.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="ROUTE")
@DynamicInsert
@DynamicUpdate
public class Route  implements Serializable {
    private  long routeId;
    private long routeGroup;
    private String routeGroupName;
    private Station station;
    private boolean statu=true;

    @Id
    @Column(name = "ROUTE_ID", unique = true, nullable = false, precision = 12, scale = 0)
    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATION_ID")
    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    @Column(name="STATU")
    public boolean isStatu() {
        return statu;
    }

    public void setStatu(boolean statu) {
        this.statu = statu;
    }

    @Column(name="STATION_GROUP_ID")
    public long getRouteGroup() {
        return routeGroup;
    }

    public void setRouteGroup(long routeGroup) {
        this.routeGroup = routeGroup;
    }

    @Column(name = "STATION_GROUP_NAME")
    public String getRouteGroupName() {
        return routeGroupName;
    }

    public void setRouteGroupName(String routeGroupName) {
        this.routeGroupName = routeGroupName;
    }
}
