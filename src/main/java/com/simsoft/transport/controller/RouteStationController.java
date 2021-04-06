package com.simsoft.transport.controller;

import com.simsoft.transport.bus.IRouteBUS;
import com.simsoft.transport.bus.IRouteStationBUS;
import com.simsoft.transport.dto.RouteDTO;
import com.simsoft.transport.dto.RouteStationDTO;
import com.simsoft.transport.dto.VehicleDTO;
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

@RestController(value = "routeStationController")
@RequestMapping("/api/routeStation/*")
@Api(value = "/api/routeStation", description = "Route Staion APIs Document")
@CrossOrigin
public class RouteStationController {
    @Autowired
    private IRouteStationBUS routeStationBUS;

    @ApiOperation(value = "Get Route Station List", response = JSONObject.class)
    @GetMapping("/getRouteStationList")
    public ResponseEntity<JSONObject> getRouteStationList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String[]> requestMap = request.getParameterMap();

        JSONObject sendJSON = routeStationBUS.getRouteStationList(requestMap);

        return ResponseEntity.ok(sendJSON);
    }

    @PostMapping("/saveOrUpdateRouteStation")
    @ApiOperation(value = "Create Operations", response = VehicleDTO.class)
    public ResponseEntity<JSONObject> saveOrUpdateRouteStation(@Valid @RequestBody RouteStationDTO routeStationDTO) throws Exception {

        JSONObject sendJSON = routeStationBUS.saveOrUpdateRouteStation(routeStationDTO, null);


        return ResponseEntity.ok(sendJSON);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operations", response = RouteStationDTO.class)
    public ResponseEntity<JSONObject> saveOrUpdateRouteStation(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody RouteStationDTO routeStationDTO) throws Exception {

        return ResponseEntity.ok(routeStationBUS.saveOrUpdateRouteStation(routeStationDTO, id));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operations", response = Boolean.class)
    public ResponseEntity<Boolean> deleteRouteStation(@PathVariable(value = "id", required = true) Long id) throws Exception {
        return ResponseEntity.ok(routeStationBUS.delete(id));
    }
}
