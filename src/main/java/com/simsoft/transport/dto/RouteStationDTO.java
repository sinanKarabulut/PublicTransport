package com.simsoft.transport.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Route Station Data Transfer Object")
public class RouteStationDTO {
    @ApiModelProperty(required = true,value = "Station Id")
    private List<Long> stationId;
    @ApiModelProperty(required = true,value = "Route ID")
    private Long routeId;
}
