package com.simsoft.transport.dao;

import net.sf.json.JSONObject;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository(value = "stationDAO")
public class StationDAO extends BaseDAO {

    public List<JSONObject> getStationList(Map<String, String[]> requestMap) {
        String hql = "from Station v where v.statu=true";

        Query query = getCurrentSession().createQuery(hql.toString());

        return  query.list();
    }
}
