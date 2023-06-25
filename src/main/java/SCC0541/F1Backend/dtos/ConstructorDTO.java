package SCC0541.F1Backend.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConstructorDTO {

    private Integer constructorId;

    private String constructorRef;

    private String name;

    private String nationality;

    private String url;

}
