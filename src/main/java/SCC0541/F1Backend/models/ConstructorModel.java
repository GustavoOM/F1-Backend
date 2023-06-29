package SCC0541.F1Backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="Constructors")
public class ConstructorModel {
    // identificadores
    @Id
    @Column(name = "constructorid")
    private Integer constructorId;

    @Column(unique = true, name = "constructorref")
    private String constructorRef;

    @Column(unique = true, name = "Name")
    private String name;

    @Column(name = "Nationality")
    private String nationality;

    @Column(name = "Url")
    private String url;
}

/*

CREATE TABLE Constructors  (
    ConstructorId INTEGER PRIMARY KEY,
    ConstructorRef TEXT UNIQUE,
    Name TEXT UNIQUE,
    Nationality TEXT,
    Url TEXT
    );

* */