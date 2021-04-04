package com.simsoft.transport.dao;

import net.sf.json.JSONObject;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository(value = "routeDAO")
public class RouteDAO extends BaseDAO{
    public List<JSONObject> getRouteList(Map<String, String[]> requestMap) {
        String hql = "from Route v where v.statu=true";

        Query query = getCurrentSession().createQuery(hql.toString());

        return  query.list();
    }
}
