package com.icon.Practice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Table(name = "country")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class CountryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String photo;

    private String denomination;

    private Long population;

    private Long surface; //m2

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //FetchType.EAGER: inicializacion temprana, cuando pida dato tipo pais, si o si viene con su continente.
    //CascadeType.ALL -> Las operaciones de padre se propagan a hijos tambien.
    //N paises 1 cont/ 1 cont N paises -
    //cada uno de los paises, va a estar en 1 continente.
    @JoinColumn(name = "continent_Id", insertable = false, updatable = false)
    //Como hago join de la entidad con la tabla continente, a traves de continent_Id.
    //Insertable-Updatable FALSE, porque solo obtengo info.
    //Con esto busco info del objeto tipo continente entero.
    private ContinentEntity continent;

    @Column(name = "continent_Id", nullable = false)
    //Con este atributo defino columna que no puede ser nula y va a tener un id de continente.
    //Y se Joinea con la table del continente a travez del id.
    //Con esto busco info del objeto tipo continente entero. Guardo y actualizo donde tengo el Id.
    private Long continentId;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    //Propaga la persistencia de una entidad a sus entidades relacionadas. Es decir, si persistimos
                    //un Pais, también vamos a persistir a su Icono
                    CascadeType.MERGE
                    //propaga la operación de actualización en la base de datos de una relación principal a sus
                    //secundarias.
            })
    //Pais se hace cargo de la relacion con Icons
    //Pais es el objeto mas grande, y englobaria a Iconos.
    @JoinTable(name = "icon_country",//Tabla intermedia
            joinColumns = @JoinColumn (name = "country_id"), //Con que dato joinea entre tablas
            inverseJoinColumns = @JoinColumn(name = "icon_id"))//De manera inversa el joinable
    //Cuando creo un pais, puedo pasarle una lisa de iconos que va a crear la remacion @MtoM
    private Set<IconEntity> icons = new HashSet<>();

}
