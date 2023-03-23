package com.icon.Practice.Service;

import com.icon.Practice.DTO.ContinentDTO;

import java.util.List;

public interface ContinentService {

    ContinentDTO save(ContinentDTO dto);

   List<ContinentDTO> getAllContinents();

}
