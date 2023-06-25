package SCC0541.F1Backend.dtos;

import lombok.Data;

@Data
public class ResultDTO {
    private Integer resultId;
    private Integer raceId;
    private Integer driverId;
    private Integer constructorId;
    private Integer number;
    private Integer grid;
    private Integer position;
    private String positionText;
    private Integer positionOrder;
    private Float points;
    private Integer Laps;
    private String time;
    private Integer milliseconds;
    private Integer fastestLap;
    private Integer rank;
    private String fastestLapTime;
    private String fastestLapSpeed;
    private Integer statusId;
}
