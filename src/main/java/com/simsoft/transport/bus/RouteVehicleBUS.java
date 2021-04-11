package com.simsoft.transport.bus;

import com.simsoft.transport.dao.RouteVehicleDAO;
import com.simsoft.transport.dto.RouteVehicleDTO;
import com.simsoft.transport.model.Route;
import com.simsoft.transport.model.RouteStation;
import com.simsoft.transport.model.RouteVehicle;
import com.simsoft.transport.model.Vehicle;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("routeVehiclBUS")
public class RouteVehicleBUS implements IRouteVehicleBUS {

    @Autowired
    private RouteVehicleDAO routeVehicleDAO;

    @Override
    public JSONObject getRouteVehicleList(Map<String, String[]> requestMap) throws Exception {
        JSONObject sendJSON = new JSONObject();
        List<JSONObject> list = routeVehicleDAO.getRouteVehicleList(null,null,null);

        sendJSON.put("success",true);
        sendJSON.put("data",list);

        return sendJSON;
    }

    @Override
    @Transactional(readOnly = false)
    public JSONObject saveOrUpdateRouteVehicle(RouteVehicleDTO routeVehicleDTO) throws Exception {
        JSONObject sendJSON = new JSONObject();

        RouteVehicle routeVehicle = null;
        if(routeVehicleDTO.getRouteVehicleId() != null && !routeVehicleDTO.getRouteVehicleId().equals(0L)){
           routeVehicle = routeVehicleDAO.getCurrentSession().load(RouteVehicle.class,routeVehicleDTO.getRouteVehicleId());
        }else{
            routeVehicle = new RouteVehicle();
        }

        if(routeVehicleDTO.getVehicleId() == null || routeVehicleDTO.getRouteId().equals(0L)){
            throw  new Exception("Route is not found!");
        }
        if(routeVehicleDTO.getVehicleId() == null || routeVehicleDTO.getVehicleId().equals(0L)){
            throw new Exception("Vehicle is not found!");
        }

        Route route = routeVehicleDAO.getCurrentSession().load(Route.class,routeVehicleDTO.getRouteId());
        Vehicle vehicle = routeVehicleDAO.getCurrentSession().load(Vehicle.class,routeVehicleDTO.getVehicleId());

        if(route == null){
            throw  new Exception("Rota bulunamadı...");
        }
        if(vehicle == null){
            throw new Exception("Araç Bulunamadı...");
        }

        routeVehicle.setVehicle(vehicle);
        routeVehicle.setRoute(route);

        List<JSONObject> listKontrol = routeVehicleDAO.getRouteVehicleList(null,routeVehicle.getVehicle().getVehicleId(),routeVehicle.getRoute().getRouteId());

        if(listKontrol != null && listKontrol.size() > 0){
            if(routeVehicleDTO.getRouteVehicleId() != null && !routeVehicleDTO.getRouteVehicleId().equals(0L)){
                for(Map<String,Object> obj :listKontrol){
                    Long routeVehicleId =(Long)obj.get("routeVehicleId");
                    if(!routeVehicleDTO.getRouteVehicleId().equals(routeVehicleId)){
                        throw new Exception("Rota ve Araç eşleşmesi daha önce yapılmıştır.!");
                    }
                }
            }else{
                throw new Exception("Rota ve Araç eşleşmesi daha önce yapılmıştır.!");
            }
        }



        routeVehicleDAO.getCurrentSession().saveOrUpdate(routeVehicle);

        sendJSON.put("success",true);
        return  sendJSON;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean deleteRouteVehicle(Long id) throws Exception {
        RouteVehicle routeVehicle = routeVehicleDAO.getCurrentSession().load(RouteVehicle.class, id);
        routeVehicle.setStatus(false);

        routeVehicleDAO.getCurrentSession().saveOrUpdate(routeVehicle);
        return true;
    }

}
