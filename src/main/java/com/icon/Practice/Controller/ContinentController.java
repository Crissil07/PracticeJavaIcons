package com.icon.Practice.Controller;

import com.icon.Practice.DTO.ContinentDTO;
import com.icon.Practice.Service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Los controladores solo van a recibir una solicitud y devolver una respuesta. No tienen logica.
@RestController
@RequestMapping("continents")//Base de nuestro path para acceder a nuestro controller.Apirest indica siempre en plural.
public class ContinentController {

    //Atributo de tipo continente service
    @Autowired //inicializa
    private ContinentService continentService; //Atributo de tipo continente service. Instancia de la clase ContinentService

    //Metodo que va a devolver algo: RETURN.
    //Para acceder al body es con la anotacion @RequestBody + variableDTO + nombre.
    //Devuelve un ResponseEntity(tipo de objeto) <TIPO DE ELEMENTO> que nos ayuda a manejar los responses.
    @PostMapping
    public ResponseEntity<ContinentDTO> save(@RequestBody ContinentDTO continent){
        //Guardar continente
        ContinentDTO savedContinent = continentService.save(continent);
        //201, continente guardado
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContinent);
    }

}
