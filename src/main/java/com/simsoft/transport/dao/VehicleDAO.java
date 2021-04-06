package com.simsoft.transport.dao;
import net.sf.json.JSONObject;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository(value = "vehicleDAO")
public class VehicleDAO extends BaseDAO {

    public List<JSONObject> getVehicleList(Map<String, String[]> requestMap) {

        String hql = "from Vehicle v where v.status=true";

        Query query = getCurrentSession().createQuery(hql.toString());

        return  query.list();
    }


}
