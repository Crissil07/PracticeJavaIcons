package com.icon.Practice.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "continent")//Le digo que tabla va a usar.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class ContinentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String photo;

    private String denomination;

}
