package com.icon.Practice.Mapper;

import com.icon.Practice.DTO.ContinentDTO;
import com.icon.Practice.Entity.ContinentEntity;
import org.springframework.stereotype.Component;

@Component
public class ContinentMapper {

    public ContinentEntity continentDTO2Entity(ContinentDTO dto){

        ContinentEntity continentEntity = new ContinentEntity();

        continentEntity.setPhoto(dto.getPhoto());
        continentEntity.setDenomination(dto.getDenomination());

        return continentEntity;
    }

    public ContinentDTO ContinentEntity2DTO (ContinentEntity contEntity){

        ContinentDTO continentDTO = new ContinentDTO();

        continentDTO.setId(continentDTO.getId());
        continentDTO.setPhoto(contEntity.getPhoto());
        continentDTO.setDenomination(contEntity.getDenomination());

        return continentDTO;

    }

}

/*El Mapper es lo que transforma los DTO y lo devuelve como una Entity a traves
de un metodo. El mapper es de tipo component.
Al metodo creado de ContinentEntity continentDTO2Entity le paso por parametro
el ContinenteDTO dto. En este metodo convertimos el DTO --> Entity.

Se crea el Objeto instanciado de la clase ContinentEntity con el nombre de
continentEntity y luego se setean los datos pasados desde los DTO a este
nuevo objeto de la clase Entity y retorno este objeto.

Luego inyecto esto en ContinentServiceImpl

En el metodo inverso, nos llega un ContinentEntity y queremos convertirlo a
DTO. En este si agrego el Id para devolver y setear para devolver el dto
completo*/



