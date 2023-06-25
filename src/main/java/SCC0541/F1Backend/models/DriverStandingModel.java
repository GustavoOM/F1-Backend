package SCC0541.F1Backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Driverstandings")
public class DriverStandingModel {
    // identificadores
    @Id
    @Column(name = "Driverstandingsid")
    private Integer driverStandingsId;

    @Column(name = "raceid")
    private Integer raceId;

    @Column(name = "driverid")
    private Integer driverId;

    @Column(name = "Points")
    private Float points;

    @Column(name = "Position")
    private Integer position;

    @Column(name = "Positiontext")
    private String positionText;

    @Column(name = "Wins")
    private Integer wins;



}

/*

CREATE TABLE  DriverStandings(
    DriverStandingsId INTEGER PRIMARY KEY,
    RaceId  INTEGER,
    DriverId INTEGER,
    Points FLOAT,
    Position INTEGER,
    PositionText TEXT,
    Wins INTEGER,
	CONSTRAINT DSLogKey UNIQUE (RaceId, DriverId),
	CONSTRAINT DSPositionKey UNIQUE (RaceId, Position)
    );


*/