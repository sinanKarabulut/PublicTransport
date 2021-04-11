package com.simsoft.transport.controller;

import com.simsoft.transport.bus.IRouteVehicleBUS;
import com.simsoft.transport.dto.RouteStationDTO;
import com.simsoft.transport.dto.RouteVehicleDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;

@RestController(value = "routeVehicleController")
@RequestMapping("/api/routeVehicle/*")
@Api(value = "/api/routeVehicle", description = "Route-vehicle APIs Document")
@CrossOrigin
public class RouteVehicleController {
    @Autowired
    private IRouteVehicleBUS routeVehicleBUS;

    @ApiOperation(value = "Get Route Vehicle List", response = JSONObject.class)
    @GetMapping("/getRouteVehicleList")
    public ResponseEntity<JSONObject> getRouteVehicleList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String[]> requestMap = request.getParameterMap();

        JSONObject sendJSON = routeVehicleBUS.getRouteVehicleList(requestMap);

        return ResponseEntity.ok(sendJSON);
    }

    @PostMapping("/saveOrUpdateRouteVehicle")
    @ApiOperation(value = "Create Operations", response = RouteVehicleDTO.class)
    public ResponseEntity<JSONObject> saveOrUpdateRouteVehicle(@Valid @RequestBody RouteVehicleDTO routeVehicleDTO) throws Exception {

        JSONObject sendJSON = routeVehicleBUS.saveOrUpdateRouteVehicle(routeVehicleDTO);


        return ResponseEntity.ok(sendJSON);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operations", response = Boolean.class)
    public ResponseEntity<Boolean> deleteRouteVehicle(@PathVariable(value = "id", required = true) Long id) throws Exception {
        return ResponseEntity.ok(routeVehicleBUS.deleteRouteVehicle(id));
    }
}
