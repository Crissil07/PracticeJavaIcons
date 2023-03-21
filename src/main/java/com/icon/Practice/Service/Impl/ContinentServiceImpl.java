package com.icon.Practice.Service.Impl;

import com.icon.Practice.DTO.ContinentDTO;
import com.icon.Practice.Entity.ContinentEntity;
import com.icon.Practice.Mapper.ContinentMapper;
import com.icon.Practice.Repository.ContinentRepository;
import com.icon.Practice.Service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContinentServiceImpl implements ContinentService {

    @Autowired
    private ContinentMapper continentMapper;
    @Autowired
    private ContinentRepository continentRepository;

    public ContinentDTO save(ContinentDTO dto){
        ContinentEntity contEntity = continentMapper.continentDTO2Entity(dto);

        ContinentEntity savedEntity = continentRepository.save(contEntity);

        ContinentDTO continentResponse = continentMapper.ContinentEntity2DTO(savedEntity);
        System.out.println("GUARDAR CONTINENTE");
        return dto;
    }

}

/*Instancio la clase ContinentMapper y le doy nombre continentMapper, con la anotacion de
@Autowired para que inicialice.

Ahora hay que convertir El parametro recibido (ContinentDTO dto) a entidad para poder guardarlo
entonces definimos ContinentEntity y lo seteamos a traves de continentMapper pasandole el dto para
que se convierta.

Y para guardar la contEntity, voy a necesitar el Repository, por eso tengo que instanciar tambien
el ContinetRepository en este ServiceImpl y brindar la anotacion de @Autowired para inicializarla.

Luego con ContinentEntity savedEntity = continentRepository.save(contEntity); vamos a guardar por
parametro la entidad.

Pero como siempre el return es a travez de un DTO, tenemos que convertirla a traves
de un metodo inverso en el Mapper.

A traves de continentResponse pasamos la entidad guardada para devolver por el return la response*/

