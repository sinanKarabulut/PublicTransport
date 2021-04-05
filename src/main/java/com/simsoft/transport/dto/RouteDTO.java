package com.simsoft.transport.dto;

import com.simsoft.transport.model.RouteStation;
import com.simsoft.transport.model.Station;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Route Data Transfer Object")
public class RouteDTO {

    @ApiModelProperty(required = true,value = "Route Group ID")
    private long routeGroup;

    @ApiModelProperty(required = true,value = "Route  Name")
    private String routeName;

    @ApiModelProperty(required = true,value = "station")
    private List<RouteStation> routeStaion;
}
