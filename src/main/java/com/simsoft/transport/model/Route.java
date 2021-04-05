package com.simsoft.transport.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="ROUTE")
@DynamicInsert
@DynamicUpdate
@ToString
@Data
@NoArgsConstructor //boş bir constructure otomatik yapar
@AllArgsConstructor
public class Route  implements Serializable {
    private  long routeId;
    private String routeName;
    private boolean statu=true;

    @Id
    @Column(name = "ROUTE_ID", unique = true, nullable = false, precision = 12, scale = 0)
    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    @Column(name="STATU")
    public boolean isStatu() {
        return statu;
    }

    public void setStatu(boolean statu) {
        this.statu = statu;
    }

    @Column(name = "RouteName")
    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }
}
