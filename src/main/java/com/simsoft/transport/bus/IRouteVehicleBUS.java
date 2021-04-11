package com.simsoft.transport.bus;

import com.simsoft.transport.dto.RouteVehicleDTO;
import net.sf.json.JSONObject;

import java.util.Map;

public interface IRouteVehicleBUS {

    /**
     * Route-Vehicle list
     * @param requestMap
     * @return
     * @throws Exception
     */
    JSONObject getRouteVehicleList(Map<String, String[]> requestMap) throws Exception;

    /**
     * save route-vehicle
     * @param routeVehicleDTO
     * @return
     * @throws Exception
     */
    JSONObject saveOrUpdateRouteVehicle(RouteVehicleDTO routeVehicleDTO) throws Exception;

    /**
     * delete route vehicle
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteRouteVehicle(Long id) throws Exception;
}
