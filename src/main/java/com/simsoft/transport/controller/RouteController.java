package com.simsoft.transport.controller;

import com.simsoft.transport.bus.IRouteBUS;
import com.simsoft.transport.bus.IStationBUS;
import com.simsoft.transport.dto.RouteDTO;
import com.simsoft.transport.dto.StationDTO;
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

@RestController(value = "routeController")
@RequestMapping("/api/route/*")
@Api(value = "/api/route", description = "Route APIs Document")
@CrossOrigin
public class RouteController {
    @Autowired
    private IRouteBUS routeBUS;

    @ApiOperation(value = "Get Route List", response = JSONObject.class)
    @GetMapping("/getRouteList")
    public ResponseEntity<JSONObject> getRouteList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String[]> requestMap = request.getParameterMap();

        JSONObject sendJSON = routeBUS.getRouteList(requestMap);

        return ResponseEntity.ok(sendJSON);
    }

    @PostMapping("/saveOrUpdateRoute")
    @ApiOperation(value = "Create Operations", response = VehicleDTO.class)
    public ResponseEntity<JSONObject> saveOrUpdateRoute(@Valid @RequestBody RouteDTO routeDTO) throws Exception {

        JSONObject sendJSON = routeBUS.saveOrUpdateRoute(routeDTO, null);


        return ResponseEntity.ok(sendJSON);
    }


    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operations", response = VehicleDTO.class)
    public ResponseEntity<JSONObject> saveOrUpdateRoute(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody RouteDTO routeDTO) throws Exception {

        return ResponseEntity.ok(routeBUS.saveOrUpdateRoute(routeDTO, id));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operations", response = Boolean.class)
    public ResponseEntity<Boolean> deleteStation(@PathVariable(value = "id", required = true) Long id) throws Exception {
        return ResponseEntity.ok(routeBUS.delete(id));
    }
}
