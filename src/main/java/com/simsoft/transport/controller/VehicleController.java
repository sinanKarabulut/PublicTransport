package com.simsoft.transport.controller;

import com.simsoft.transport.bus.IVehicleBUS;
import com.simsoft.transport.dto.VehicleDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.lang.invoke.MethodType;
import java.util.Map;

@RestController(value = "vehicleController")
@RequestMapping("/api/vehicle/*")
@Api(value = "/api/vehicle", description =  "Vehicle APIs Document")

@CrossOrigin
public class VehicleController {

    @Autowired
    private IVehicleBUS vehicleBUS;

    @ApiOperation(value ="Get Vehicle List",response = JSONObject.class)
    @GetMapping("/getVehicleList")
    //@PreAuthorize("hasRole('USERS')")
    public ResponseEntity<JSONObject> getVehicleList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String[]> requestMap = request.getParameterMap();

        JSONObject sendJSON = vehicleBUS.getVehicleList(requestMap);

        return  ResponseEntity.ok(sendJSON);
    }

    @PostMapping("/saveOrUpdateVehicle")
    @ApiOperation(value ="Create Operations",response = VehicleDTO.class)
    public ResponseEntity<JSONObject> saveOrUpdateVehicle(@Valid @RequestBody VehicleDTO vehicleDTO) throws Exception {

        JSONObject sendJSON = vehicleBUS.saveOrUpdateVehicle(vehicleDTO,null);


        return  ResponseEntity.ok(sendJSON);
    }


    @PutMapping("/{id}")
    @ApiOperation(value ="Update Operations",response = VehicleDTO.class)
    //@RequestMapping(path = "/update",method = RequestMethod.PUT)
    public ResponseEntity<JSONObject> saveOrUpdateVehicle(@PathVariable(value = "id",required = true) Long id,@Valid  @RequestBody VehicleDTO vehicleDTO) throws Exception {
        //SOLID single responsibility sağlamaz
        //projectServiceImpl.save()
        return ResponseEntity.ok(vehicleBUS.saveOrUpdateVehicle(vehicleDTO,id));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value ="Delete Operations",response = Boolean.class)
    public ResponseEntity<Boolean> deleteVehicle(@PathVariable(value = "id",required = true) Long id) throws Exception {
        return  ResponseEntity.ok(vehicleBUS.delete(id));
    }


}
