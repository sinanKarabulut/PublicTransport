package com.simsoft.transport.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="VEHICLE")
@DynamicInsert
@DynamicUpdate
@ToString
@Data
@NoArgsConstructor //boş bir constructure otomatik yapar
@AllArgsConstructor
public class Vehicle implements Serializable {

    private long vehicleId;
    private String vehicleName;
    private String plate;
    private String model;
    private Integer modelYear;
    private boolean statu=true;

    @Id
    @Column(name = "VEHICLE_ID", unique = true, nullable = false, precision = 12, scale = 0)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Column(name="VEHICLE_NAME")
    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    @Column(name="PLATE")
    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    @Column(name="STATU")
    public boolean isStatu() {
        return statu;
    }

    public void setStatu(boolean statu) {
        this.statu = statu;
    }

    @Column(name="MODEL")
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name="MODEL_YEAR")
    public Integer getModelYear() {
        return modelYear;
    }

    public void setModelYear(Integer modelYear) {
        this.modelYear = modelYear;
    }
}
