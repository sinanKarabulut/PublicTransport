package com.simsoft.transport.bus;

import com.simsoft.transport.dao.RouteDAO;
import com.simsoft.transport.dao.StationDAO;
import com.simsoft.transport.dto.RouteDTO;
import com.simsoft.transport.model.Route;
import com.simsoft.transport.model.RouteStation;
import com.simsoft.transport.model.Vehicle;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "routeBUS")
public class RouteBUS implements IRouteBUS{
    @Autowired
    private RouteDAO routeDAO;

    @Override
    public JSONObject getRouteList(Map<String, String[]> requestMap) throws Exception {
        JSONObject sendJSON = new JSONObject();

        List<JSONObject> list = routeDAO.getRouteList(requestMap);

        sendJSON.put("data", list);
        sendJSON.put("sucess", true);
        return sendJSON;
    }

    @Override
    public JSONObject saveOrUpdateRoute(RouteDTO routeDTO, Long id) throws Exception {
        JSONObject sendJSON = new JSONObject();

        Route route = null;
        if (id == null) {
            route = new Route();
        } else {
            route = routeDAO.getCurrentSession().load(Route.class, id);
        }

        List<RouteStation> routeList = routeDAO.getRouteList(route.getRouteId());

        for(RouteStation route1:routeList){
            route1.setStatus(false);
            routeDAO.getCurrentSession().saveOrUpdate(route1);
        }

        route.setRouteName(routeDTO.getRouteName());
        route.setStatus(true);

        RouteStation routeStationObj=null;

        for(RouteStation routeStation:routeDTO.getRouteStaion()){
            routeStationObj = new RouteStation();

            routeStationObj.setRouteId(routeStation.getRouteId());
            routeStationObj.setStationId(routeStation.getStationId());
            routeStationObj.setStatus(true);
            routeDAO.getCurrentSession().saveOrUpdate(routeStationObj);
        }

        routeDAO.getCurrentSession().saveOrUpdate(route);
        routeDAO.getCurrentSession().flush();
        sendJSON.put("success", true);
        return sendJSON;
    }

    @Override
    public boolean delete(Long id) throws Exception {
        Route route = routeDAO.getCurrentSession().load(Route.class, id);
        route.setStatus(false);

        routeDAO.getCurrentSession().saveOrUpdate(route);
        return false;
    }
}
