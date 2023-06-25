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
@Entity(name="Qualifying")
public class QualifyingModel {
    @Id
    @Column(name = "Qualifyid")
    private Integer qualifyId;

    @Column(name = "raceid")
    private Integer raceId;

    @Column(name = "Driverid")
    private Integer driverId;

    @Column(name = "Constructorid")
    private Integer constructorId;

    @Column(name = "Number")
    private Integer number;

    @Column(name = "Q1")
    private String q1;

    @Column(name = "Q2")
    private String q2;

    @Column(name = "Q3")
    private String q3;
}

/*

CREATE TABLE Qualifying(
    QualifyId INTEGER PRIMARY KEY,
    RaceId  INTEGER,
    DriverId  INTEGER,
    ConstructorId  INTEGER,
    Number  INTEGER,
    Position  INTEGER,
    Q1  TEXT,
    Q2  TEXT,
    Q3  TEXT,
	CONSTRAINT QuLogKey UNIQUE (RaceId, DriverId, ConstructorId)
    );

*/