package com.simsoft.transport.dao;

import com.simsoft.transport.model.RouteVehicle;
import net.sf.json.JSONObject;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository(value = "routeVehicleDAO")
public class RouteVehicleDAO extends BaseDAO {

    public List<JSONObject> getRouteVehicleList(Long routeVehicleId,Long routeId,Long vehicleId){
        String  sql="";
        sql="select new map(rv.routeVehicleId as routeVehicleId,rv.route.routeName as routeName,rv.vehicle.vehicleName as vehicleName";
        sql+=",rv.vehicle.model as vehicleModel,rv.vehicle.plate as plate) ";
        sql+= " from RouteVehicle rv where rv.status=true ";

        if(routeVehicleId != null){
            sql+=" and rv.routeVehicleId=:routeVehicleId ";
        }
        if(routeId != null){
            sql+=" and rv.route.routeId=:routeId ";
        }
        if(vehicleId != null){
            sql+=" and rv.vehicle.vehicleId=:vehicleId ";
        }

        Query query=getCurrentSession().createQuery(sql);

        if(routeVehicleId != null){
            query.setLong("routeVehicleId",routeVehicleId);
        }
        if(routeId != null){
            query.setLong("routeId",routeId);
        }
        if(vehicleId != null){
            query.setLong("vehicleId",vehicleId);
        }

        return  query.list();
    }
}
