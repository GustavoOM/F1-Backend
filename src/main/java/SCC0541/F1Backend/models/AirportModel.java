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
@Entity(name="Airports")
public class AirportModel {

    @Id
    @Column(name = "Ident")
    private String ident;

    @Column(name = "Type")
    private String type;

    @Column(name = "Name")
    private String name;

    @Column(name = "Latdeg")
    private Double latDeg;

    @Column(name = "Longdeg")
    private Double longDeg;

    @Column(name = "Elevft")
    private Integer elevFt;

    @Column(name = "Continent")
    private String continent;

    @Column(name = "isocountry")
    private String iSOCountry;

    @Column(name = "isoregion")
    private String iSORegion;

    @Column(name = "City")
    private String city;

    @Column(name = "Scheduled_service")
    private String scheduled_service;

    @Column(name = "gpscode")
    private String gpscode;

    @Column(name = "iatacode")
    private String iatacode;

    @Column(name = "Localcode")
    private String localCode;

    @Column(name = "Homelink")
    private String homeLink;

    @Column(name = "wikipedialink")
    private String wikipediaLink;

    @Column(name = "keywords")
    private String keywords;


}
