package com.simsoft.transport.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Vehicle Data Transfer Object")
public class VehicleDTO {

    @NotNull
    @ApiModelProperty(required = true,value = "Vehicle Name")
    private String vehicleName;

    @NotEmpty
    @NotNull
    @ApiModelProperty(required = true,value = "Plate")
    private String plate;

    @NotEmpty
    @NotNull
    @ApiModelProperty(required = true,value = "Model")
    private String model;

    @NotEmpty
    @NotNull
    @ApiModelProperty(required = true,value = "Model Year")
    private Integer modelYear;
}
