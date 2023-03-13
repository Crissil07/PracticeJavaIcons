package Entity;

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
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private Long id;

    private String photo;

    private String denomination;

    @Column(name = "population")
    private Long population;

    private Long surface; //m2

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)//FetchType.EAGER: inicializacion temprana, cuando pida dato tipo pais, si o si viene con su continente. CascadeType.ALL operaciones consecuentes por continente.
    @JoinColumn(name = "continent_Id", insertable = false, updatable = false)//Como hago join de la entidad con la tabla continente, a traves de continentId. Insertable FALSE, porque solo obtengo info.
    private ContinentEntity continent;

    @Column(name = "continent:Id", nullable = false)//Con este atributo defino columna que no puede ser nula y va a tener un id de continente. Y se Joinea con la table del continente a travez del id.
    private Long continentId;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "icon_country",//Tabla intermedia
            joinColumns = @JoinColumn (name = "country_id"), //Con que dato joinea entre tablas
            inverseJoinColumns = @JoinColumn(name = "icon_id"))//De manera inversa el joinable
    private Set<IconEntity> icons = new HashSet<>();

}
