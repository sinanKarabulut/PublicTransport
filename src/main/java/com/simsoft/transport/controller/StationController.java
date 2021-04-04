package com.simsoft.transport.controller;

import com.simsoft.transport.bus.IStationBUS;
import com.simsoft.transport.bus.IVehicleBUS;
import com.simsoft.transport.dto.StationDTO;
import com.simsoft.transport.dto.VehicleDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;



@RestController(value = "stationController")
@RequestMapping("/api/station/*")
@Api(value = "/api/station", description =  "Station APIs Document")
@CrossOrigin
public class StationController {

    @Autowired
    private IStationBUS stationBUS;

    @ApiOperation(value = "Get Vehicle List", response = JSONObject.class)
    @GetMapping("/getStationList")
    public ResponseEntity<JSONObject> getStationList(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String[]> requestMap = request.getParameterMap();

        JSONObject sendJSON = stationBUS.getStationList(requestMap);

        return ResponseEntity.ok(sendJSON);
    }

    @PostMapping("/saveOrUpdateStation")
    @ApiOperation(value = "Create Operations", response = VehicleDTO.class)
    public ResponseEntity<JSONObject> saveOrUpdateStation(@Valid @RequestBody StationDTO stationDTO) throws Exception {

        JSONObject sendJSON = stationBUS.saveOrUpdateStation(stationDTO, null);


        return ResponseEntity.ok(sendJSON);
    }


    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operations", response = VehicleDTO.class)
    public ResponseEntity<JSONObject> saveOrUpdateStation(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody StationDTO stationDTO) throws Exception {

        return ResponseEntity.ok(stationBUS.saveOrUpdateStation(stationDTO, id));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operations", response = Boolean.class)
    public ResponseEntity<Boolean> deleteStation(@PathVariable(value = "id", required = true) Long id) throws Exception {
        return ResponseEntity.ok(stationBUS.delete(id));
    }
}
