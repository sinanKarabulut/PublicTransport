package com.simsoft.transport.bus;

import com.simsoft.transport.dao.RouteStationDAO;
import com.simsoft.transport.dto.RouteStationDTO;
import com.simsoft.transport.model.Route;
import com.simsoft.transport.model.RouteStation;
import com.simsoft.transport.model.Station;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "routeStationBUS")
public class RouteStationBUS implements IRouteStationBUS {

    @Autowired
    private RouteStationDAO routeStationDAO;

    @Override
    public JSONObject getRouteStationList(Map<String, String[]> requestMap) throws Exception {
        JSONObject sendJson = new JSONObject();
        List<JSONObject> list = routeStationDAO.getRouteStationList(requestMap);

        sendJson.put("data",list);
        sendJson.put("success",true);
        return  sendJson;
    }

    @Override
    public JSONObject saveOrUpdateRouteStation(RouteStationDTO routeStationDTO, Long routeId) throws Exception {
        JSONObject sendJSON = new JSONObject();

        if(routeStationDTO.getStationId().size() < 1){
            throw  new Exception("Birden çok rota seçilmelidir.!");
        }

        if(routeId != null){
            List<RouteStation> routeStationList = routeStationDAO.getRouteStationList(null,routeId);

            if(routeStationList.size() > 0){
                for(RouteStation routeStation:routeStationList){
                    routeStation.setStatus(false);
                    routeStationDAO.getCurrentSession().saveOrUpdate(routeStation);
                }
            }
        }
        RouteStation routeStation=null;
        for(int i=0;i<routeStationDTO.getStationId().size();i++){
            routeStation = new RouteStation();
            routeStation.setStatus(true);
            routeStation.setStationId(routeStationDTO.getStationId().get(i));
            routeStation.setRouteId(routeStationDTO.getRouteId());
            routeStationDAO.getCurrentSession().saveOrUpdate(routeStation);

        }
        sendJSON.put("success",true);
        return  sendJSON;
    }

    @Override
    public boolean delete(Long id) throws Exception {
        RouteStation routeStation = routeStationDAO.getCurrentSession().load(RouteStation.class, id);
        routeStation.setStatus(false);

        routeStationDAO.getCurrentSession().saveOrUpdate(routeStation);
        return false;
    }
}
