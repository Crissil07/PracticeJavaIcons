package com.icon.Practice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "icon")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class IconEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String photo;
    private String denomination;

    @Column(name = "created_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate createDate;

    private Long height;

    private String history;

   @ManyToMany(mappedBy = "icons", cascade = CascadeType.ALL)
   //Cuando creo el Icono, no puedo pasarle una lista de paises, ya quien se hace cargo de la relacion es el pais.
   //Defino esto con el mappedBy
   //La definicion esta en el Set (atributo) de la entidad pais
    private List<CountryEntity> country = new ArrayList<>();

}
