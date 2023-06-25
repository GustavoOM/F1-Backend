package SCC0541.F1Backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PitStopDTO {

    private Integer raceId;
    private Integer driverId;
    private Integer stop;
    private Integer lap;
    private String time;
    private String duration;
    private Integer milliseconds;

}
