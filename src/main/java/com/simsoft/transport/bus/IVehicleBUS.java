package com.simsoft.transport.bus;

import com.simsoft.transport.dto.VehicleDTO;
import net.sf.json.JSONObject;

import java.util.Map;

public interface IVehicleBUS {
    JSONObject getVehicleList(Map<String, String[]> requestMap) throws Exception;

    JSONObject saveOrUpdateVehicle(VehicleDTO vehicleDTO,Long id) throws Exception;

    boolean delete(Long id) throws Exception;
}
