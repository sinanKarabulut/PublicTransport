package com.simsoft.transport.dao;

import com.simsoft.transport.model.RouteStation;
import net.sf.json.JSONObject;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Queue;

@Repository(value = "routeStationDAO")
public class RouteStationDAO extends BaseDAO {
    public List<JSONObject> getRouteStationList(Map<String, String[]> requestMap) {
        String sql = "";

        sql="select rs.ROUTE_STATION_ID as \"routeStationId\",r.ROUTE_NAME as \"routeName\",s.station_name as \"stationName\"";
        sql += "from ROUTE_STATION rs,Route r,Station s where rs.ROUTE_ID = r.ROUTE_ID and " +
                " rs.station_id =s.station_id and rs.status=1 ";

        Query query = getCurrentSession().createSQLQuery(sql);
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);

        return  query.list();
    }
    public List<RouteStation> getRouteStationList(Long routeStationId,Long routeId){
        String hql = "from RouteStation v where v.status=true ";

        if(routeStationId != null){
            hql += "and v.routeStationId=:routeStationId";
        }
        if(routeId != null){
            hql += " and v.stationId=:stationId";
        }

        Query query = getCurrentSession().createQuery(hql.toString());

        if(routeStationId != null){
            query.setLong("routeStationId",routeStationId);
        }

        if(routeId != null){
            query.setLong("routeId",routeId);
        }

        return  query.list();
    }
}
