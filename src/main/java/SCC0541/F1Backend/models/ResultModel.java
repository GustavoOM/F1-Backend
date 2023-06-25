package SCC0541.F1Backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Results")
public class ResultModel {
    @Id
    @Column(name = "Resultid")
    private Integer resultId;

    @Column(name = "Raceid")
    private Integer raceId;

    @Column(name = "Driverid")
    private Integer driverId;

    @Column(name = "Constructorid")
    private Integer constructorId;

    @Column(name = "Number")
    private Integer number;

    @Column(name = "Grid")
    private Integer grid;

    @Column(name = "Position")
    private Integer position;

    @Column(name = "Positiontext")
    private String positionText;

    @Column(name = "Positionorder")
    private Integer positionOrder;

    @Column(name = "Points")
    private Float points;

    @Column(name = "Laps")
    private Integer Laps;

    @Column(name = "Time")
    private String time;

    @Column(name = "milliseconds")
    private Integer milliseconds;

    @Column(name = "fastestlap")
    private Integer fastestLap;

    @Column(name = "Rank")
    private Integer rank;

    @Column(name = "Fastestlaptime")
    private String fastestLapTime;

    @Column(name = "Fastestlapspeed")
    private String fastestLapSpeed;

    @Column(name = "Statusid")
    private Integer statusId;


}

/*

CREATE TABLE Results(
    ResultId  INTEGER PRIMARY KEY,
    RaceId  INTEGER,
    DriverId  INTEGER,
    ConstructorId  INTEGER,
    Number INTEGER,
    Grid  INTEGER,
    Position  INTEGER,
    PositionText  TEXT,
    PositionOrder  INTEGER,
    Points  FLOAT,
    Laps  INTEGER,
    Time  TEXT,
    Milliseconds  INTEGER,
    FastestLap  INTEGER,
    Rank INTEGER,
    FastestLapTime  TEXT,
    FastestLapSpeed  TEXT,
    StatusId  INTEGER
    );


*/