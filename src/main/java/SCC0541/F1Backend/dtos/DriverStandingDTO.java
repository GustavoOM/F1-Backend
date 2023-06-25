package SCC0541.F1Backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverStandingDTO {
    private Integer driverStandingsId;

    private Integer raceId;

    private Integer driverId;

    private Float points;

    private Integer position;

    private String positionText;

    private Integer wins;

}
