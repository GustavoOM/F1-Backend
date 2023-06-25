package SCC0541.F1Backend.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QualifyingDTO {
    private Integer qualifyId;

    private Integer raceId;

    private Integer driverId;

    private Integer constructorId;

    private Integer number;

    private String q1;

    private String q2;

    private String q3;
}
