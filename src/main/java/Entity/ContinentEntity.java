package Entity;

import lombok.*;
import javax.persistence.*;

@Table(name = "continent")//Le digo que tabla va a usar.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class ContinentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Genera una secuencia de Id: 1,2,3,4,5...
    private Long id;

    private String photo;

    private String denomination;

}
