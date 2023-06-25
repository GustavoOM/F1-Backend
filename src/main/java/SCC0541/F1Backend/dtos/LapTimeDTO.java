package SCC0541.F1Backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LapTimeDTO {

    private int raceId;
    private int driverId;
    private int lap;
    private int position;
    private String time;
    private int milliseconds;

}
