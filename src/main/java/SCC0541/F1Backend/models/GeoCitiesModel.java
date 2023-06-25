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
@Entity(name = "Geocities15k")
public class GeoCitiesModel {

    @Id
    @Column(name = "Geonameid")
    private Integer geoNameId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Asciiname")
    private String asciiName;

    @Column(name = "Alternatenames")
    private String alternateNames;

    @Column(name = "Lat")
    private Float lat;

    @Column(name = "Long")
    private Float lon;

    @Column(name = "Featureclass")
    private String featureClass;

    @Column(name = "Featurecode")
    private String featureCode;

    @Column(name = "Country")
    private String country;

    @Column(name = "cc2")
    private String cc2;

    @Column(name = "Admin1code")
    private String admin1Code;

    @Column(name = "Admin2code")
    private String admin2Code;

    @Column(name = "Admin3code")
    private String admin3Code;

    @Column(name = "Admin4code")
    private String admin4Code;

    @Column(name = "Population")
    private Long population;

    @Column(name = "Elevation")
    private Long elevation;

    @Column(name = "Dem")
    private Long dem;

    @Column(name = "Timezone")
    private String timeZone;

    @Column(name = "Modification")
    private LocalDateTime modification;

}
