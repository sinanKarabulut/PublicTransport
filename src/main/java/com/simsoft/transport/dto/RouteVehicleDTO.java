package com.simsoft.transport.dto;

import com.simsoft.transport.model.Route;
import com.simsoft.transport.model.Vehicle;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Route Vehicle Data Transfer Object")
public class RouteVehicleDTO {
    @ApiModelProperty(required = false,value = "Route Vehicle Id")
    private Long routeVehicleId;
    @ApiModelProperty(required = true,value = "Vehicle Id")
    private Long vehicleId;
    @ApiModelProperty(required = true,value = "Route Id")
    private Long routeId;
}
