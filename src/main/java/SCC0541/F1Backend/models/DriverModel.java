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
@Entity(name="Driver")
public class DriverModel {
    @Id
    @Column(name = "driverid")
    private Integer driverId;

    @Column(unique = true, name = "Driverref")
    private String driverRef;

    @Column(name = "Number")
    private Integer number;

    @Column(name = "Code")
    private String code;

    @Column(name = "Forename")
    private String forename;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Dob")
    private LocalDateTime dob;

    @Column(name = "Nationality")
    private String nationality;

    @Column(name = "url")
    private String url;


}

/*

CREATE TABLE Driver(
    DriverId INTEGER PRIMARY KEY,
    DriverRef TEXT UNIQUE,
    Number INTEGER,
    Code TEXT,
    Forename TEXT,
    Surname TEXT,
    Dob DATE,
    Nationality TEXT,
    URL TEXT UNIQUE,
	CONSTRAINT DrLogKey UNIQUE (Forename, Surname)
    );

*/
