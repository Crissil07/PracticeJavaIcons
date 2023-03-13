package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

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
