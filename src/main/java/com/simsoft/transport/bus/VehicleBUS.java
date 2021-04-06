package com.simsoft.transport.bus;

import com.simsoft.transport.dao.VehicleDAO;
import com.simsoft.transport.dto.VehicleDTO;
import com.simsoft.transport.model.Vehicle;
import net.sf.json.JSONObject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;

@Service(value = "vehicleBUS")
public class VehicleBUS implements IVehicleBUS {

    @Autowired
    private VehicleDAO vehicleDAO;

    @Override
    public JSONObject getVehicleList(Map<String, String[]> requestMap) throws Exception {
        JSONObject sendJSON = new JSONObject();

        List<JSONObject> list = vehicleDAO.getVehicleList(requestMap);

        sendJSON.put("data", list);
        sendJSON.put("sucess", true);
        return sendJSON;
    }

    @Override
    @Transactional(readOnly = false)
    public JSONObject saveOrUpdateVehicle(VehicleDTO vehicleDTO, Long id) throws Exception {

        JSONObject sendJSON = new JSONObject();

        Vehicle vehicle = null;
        if (id == null) {
            vehicle = new Vehicle();
        } else {
            vehicle = vehicleDAO.getCurrentSession().load(Vehicle.class, id);
        }

        vehicle.setVehicleName(vehicleDTO.getVehicleName());
        vehicle.setPlate(vehicleDTO.getPlate());
        vehicle.setStatus(true);

        vehicleDAO.getCurrentSession().saveOrUpdate(vehicle);
        vehicleDAO.getCurrentSession().flush();
        sendJSON.put("success", true);
        return sendJSON;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean delete(Long id) throws Exception {
        Vehicle vehicle = vehicleDAO.getCurrentSession().load(Vehicle.class, id);
        vehicle.setStatus(false);
        vehicleDAO.getCurrentSession().saveOrUpdate(vehicle);

        return true;
    }
}
