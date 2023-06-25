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
@Entity(name="Circuits")
public class CircuitModel {
    // identificadores
    @Id
    @Column(name = "CircuitId")
    private Integer circuitId;

    @Column(unique = true, name = "CircuitRef")
    private String circuitRef;

    @Column(unique = true, name = "Name")
    private String name;

    @Column(name = "Location")
    private String location;

    @Column(name = "Country")
    private String country;

    @Column(name = "Lat")
    private Float lat;

    @Column(name = "Lng")
    private Float lng;

    @Column(name = "Alt")
    private Float alt;

    @Column(name = "URL")
    private String url;

}

/*

CREATE TABLE Circuits (
    CircuitId INTEGER PRIMARY KEY,
    CircuitRef TEXT NOT NULL UNIQUE,
    Name TEXT NOT NULL UNIQUE,
    Location TEXT,
    Country TEXT,
    Lat FLOAT,
    Lng FLOAT,
    Alt FLOAT,
    URL TEXT
);

*/