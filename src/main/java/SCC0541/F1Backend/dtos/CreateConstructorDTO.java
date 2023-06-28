package SCC0541.F1Backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateConstructorDTO {

    private String constructorRef;

    private String name;

    private String nationality;

    private String url;
}


