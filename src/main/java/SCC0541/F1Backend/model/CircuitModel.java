package SCC0541.F1Backend.model;

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
    @Column(name = "circuitid")
    private Integer circuitId;

    @Column(unique = true, name = "circuitref")
    private String circuitRef;

    @Column(unique = true, name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "country")
    private String country;

    @Column(name = "lat")
    private Float lat;

    @Column(name = "lng")
    private Float lng;

    @Column(name = "alt")
    private Float alt;

    @Column(name = "url")
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