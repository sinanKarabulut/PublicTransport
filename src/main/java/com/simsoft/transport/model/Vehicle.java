package com.simsoft.transport.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;

@Entity // jpa annotation
@Table(name="VEHICLE")
@ToString
@Data
public class Vehicle extends BaseEntity {

    public Vehicle(){}
    public Vehicle(long vehicleId){
        this.vehicleId = vehicleId;
    }

    @Id
    @Column(name = "VEHICLE_ID", unique = true, nullable = false, precision = 12, scale = 0)
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "seq")
    @GenericGenerator(name = "seq", strategy="increment")
    private long vehicleId;
    @Column(name="VEHICLE_NAME")
    private String vehicleName;
    @Column(name="PLATE")
    private String plate;
    @Column(name="MODEL")
    private String model;
    @Column(name="MODEL_YEAR")
    private Integer modelYear;

}
