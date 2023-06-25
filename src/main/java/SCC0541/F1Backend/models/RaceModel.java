package SCC0541.F1Backend.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Races")
public class RaceModel {
    @Id
    @Column(name = "raceid")
    private Integer qualifyId;

    @Column(name = "year")
    private Integer year;

    @Column(name = "Round")
    private Integer round;

    @Column(name = "Circuitid")
    private Integer circuitId;

    @Column(name = "Name")
    private String name;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "time")
    private String time;

    @Column(name = "url")
    private String url;

    @Column(name = "Dfp1")
    private LocalDateTime dfp1;

    @Column(name = "Tfp1")
    private String tfp1;

    @Column(name = "Dfp2")
    private LocalDateTime dfp2;

    @Column(name = "Tfp2")
    private String tfp2;

    @Column(name = "Dfp3")
    private LocalDateTime dfp3;

    @Column(name = "Tfp3")
    private String tfp3;

    @Column(name = "Dquali")
    private LocalDateTime dquali;

    @Column(name = "Tquali")
    private String tquali;

    @Column(name = "Dsprint")
    private LocalDateTime dsprint;

    @Column(name = "Tsprint")
    private String tsprint;

}

/*

CREATE TABLE Races(
    RaceId INTEGER PRIMARY KEY,
    YEAR INTEGER,
    Round INTEGER,
    CircuitId INTEGER,
    Name TEXT,
    Date DATE,
    Time TEXT,
    URL TEXT UNIQUE,
	Dfp1 DATE,
	Tfp1 TEXT,
	Dfp2 DATE,
	Tfp2 TEXT,
	Dfp3 DATE,
	Tfp3 TEXT,
	Dquali DATE,
	Tquali TEXT,
	Dsprint DATE,
	Tsprint TEXT
);


*/
