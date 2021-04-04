package com.simsoft.transport.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Station Data Transfer Object")
public class StationDTO {
    @NotNull
    @ApiModelProperty(required = true,value = "Station Name")
    private String stationName;
}
