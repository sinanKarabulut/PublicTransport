package com.simsoft.transport.bus;

import com.simsoft.transport.dto.StationDTO;
import net.sf.json.JSONObject;

import java.util.Map;

public interface IStationBUS {
    JSONObject getStationList(Map<String, String[]> requestMap) throws Exception;

    JSONObject saveOrUpdateStation(StationDTO stationDTO, Long id) throws  Exception;

    boolean delete(Long id) throws Exception;
}
