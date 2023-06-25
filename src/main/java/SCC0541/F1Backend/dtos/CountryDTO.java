package SCC0541.F1Backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {
    private String code;

    private String name;

    private String continent;

    private String keywords;
}
