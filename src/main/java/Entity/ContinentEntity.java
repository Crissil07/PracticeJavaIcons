package Entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "continent")//Le digo que tabla va a usar.
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class ContinentEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")//Genera una secuencia de Id: 1,2,3,4,5...
    private Long id;

    private String photo;

    private String denomination;

}
