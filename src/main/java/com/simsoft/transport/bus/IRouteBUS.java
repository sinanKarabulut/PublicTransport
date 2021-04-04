package com.simsoft.transport.bus;

import com.simsoft.transport.dto.RouteDTO;
import net.sf.json.JSONObject;

import java.util.Map;

public interface IRouteBUS {
    /**
     * route list
     * @param requestMap
     * @return
     * @throws Exception
     */
    JSONObject getRouteList(Map<String, String[]> requestMap) throws Exception;


    /**
     * save  route
     * @param routeDTO
     * @param id
     * @return
     * @throws Exception
     */
    JSONObject saveOrUpdateRoute(RouteDTO routeDTO, Long id) throws Exception;

    boolean delete(Long id) throws Exception;
}
