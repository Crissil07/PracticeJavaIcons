package com.icon.Practice.Service.Impl;

import com.icon.Practice.DTO.ContinentDTO;
import com.icon.Practice.Entity.ContinentEntity;
import com.icon.Practice.Mapper.ContinentMapper;
import com.icon.Practice.Repository.ContinentRepository;
import com.icon.Practice.Service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContinentServiceImpl implements ContinentService {

    @Autowired
    private ContinentMapper continentMapper;
    @Autowired
    private ContinentRepository continentRepository;

    public ContinentDTO save(ContinentDTO dto){
        //llamo dentro del mapper a ContinentDTO2Entity para pasar los datos dto (pasados por parametro) a entidad
        ContinentEntity contEntity = continentMapper.continentDTO2Entity(dto);
        //Una vez pasado a entidad, se hace la consulta al repositorio y los datos (contEntity) de la DB, se guardan en un objeto nuevo.
        ContinentEntity savedEntity = continentRepository.save(contEntity);
        //Este ultimo objeto,una vez guardado, hay que reconvertirlo a DTO para poder ser devuelto, entonces llamo nuevamente al mapper ConinentEntity2DTO. Y en el return, devuelvo continentResponse (con los datos del DTO grabados).
        ContinentDTO continentResponse = continentMapper.continentEntity2DTO(savedEntity);
        System.out.println("GUARDAR CONTINENTE");
        return continentResponse;
    }

    //Creo este metodo ya que ContinentService me obliga a crearlo a travez de la interfaz, con un override, pero se sobre escribe de la interfaz.
    public List<ContinentDTO> getAllContinents() {
        //Jpa nos provee el metodo que busca lo ya creado en la DB, por eso no hace falta pasar el DTO a entity
        List<ContinentEntity> contEntities = continentRepository.findAll();
        //Encontrada esta lista de continentes, lo guardo en este nuevo objeto y a traves del mapper, transformo esta lista (de entidades) a DTO con datos por parametro (contEntities)
        List<ContinentDTO> continentResponse = continentMapper.continentEntityList2DTOList(contEntities);
        return continentResponse;
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

