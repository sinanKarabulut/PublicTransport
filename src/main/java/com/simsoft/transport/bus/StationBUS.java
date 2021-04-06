package com.simsoft.transport.bus;

import com.simsoft.transport.dao.StationDAO;
import com.simsoft.transport.dao.VehicleDAO;
import com.simsoft.transport.dto.StationDTO;
import com.simsoft.transport.model.Station;
import com.simsoft.transport.model.Vehicle;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service(value = "stationBUS")
public class StationBUS implements IStationBUS{

    @Autowired
    private StationDAO stationDAO;

    @Override
    public JSONObject getStationList(Map<String, String[]> requestMap) throws Exception {
        JSONObject sendJSON = new JSONObject();

        List<JSONObject> list = stationDAO.getStationList(requestMap);

        sendJSON.put("data",list);
        sendJSON.put("sucess",true);
        return sendJSON;
    }

    @Override
    @Transactional(readOnly = false)
    public JSONObject saveOrUpdateStation(StationDTO stationDTO, Long id) throws Exception {
        JSONObject sendJSON = new JSONObject();

        Station station=null;
        if(id == null){
            station = new Station();
        }else{
            station = stationDAO.getCurrentSession().load(Station.class,id);
        }

        station.setStationName(stationDTO.getStationName());
        station.setStatus(true);

        stationDAO.getCurrentSession().saveOrUpdate(station);
        stationDAO.getCurrentSession().flush();
        sendJSON.put("success",true);
        return  sendJSON;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean delete(Long id) throws Exception {
        Station station = stationDAO.getCurrentSession().load(Station.class,id);
        station.setStatus(false);
        stationDAO.getCurrentSession().saveOrUpdate(station);

        return  true;
    }
}
