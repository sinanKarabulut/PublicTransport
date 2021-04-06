package com.simsoft.transport.bus;

import com.simsoft.transport.dto.RouteStationDTO;
import net.sf.json.JSONObject;

import java.util.Map;

public interface IRouteStationBUS {
    JSONObject getRouteStationList(Map<String, String[]> requestMap) throws  Exception;

    JSONObject saveOrUpdateRouteStation(RouteStationDTO routeStationDTO, Long id) throws Exception;

    boolean delete(Long id) throws Exception;
}
