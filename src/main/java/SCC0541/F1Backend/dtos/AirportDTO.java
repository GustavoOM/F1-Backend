package SCC0541.F1Backend.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirportDTO {
    private String ident;
    private String type;
    private String name;
    private Double latDeg;
    private Double longDeg;
    private Integer elevFt;
    private String continent;
    private String iSOCountry;
    private String iSORegion;
    private String city;
    private String scheduled_service;
    private String gpscode;
    private String iatacode;
    private String localCode;
    private String homeLink;
    private String wikipediaLink;
    private String keywords;
}
