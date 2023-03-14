package com.icon.Practice.Service;

import com.icon.Practice.DTO.ContinentDTO;
import org.springframework.stereotype.Service;

@Service
public class ContinentService {

    //Metodo para guardar. Va a devolver tipo ContinenteDTO
    public ContinentDTO save(ContinentDTO dto){
        //save
        // TODO: guardar continente
        System.out.println("GUARDAR CONTINENTE");
        return dto;
    }

}
