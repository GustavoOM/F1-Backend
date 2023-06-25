package SCC0541.F1Backend.dtos;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GeoCitiesDTO {

    private Integer geoNameId;
    private String name;
    private String asciiName;
    private String alternateNames;
    private Float lat;
    private Float lon;
    private String featureClass;
    private String featureCode;
    private String country;
    private String cc2;
    private String admin1Code;
    private String admin2Code;
    private String admin3Code;
    private String admin4Code;
    private Long population;
    private Long elevation;
    private Long dem;
    private String timeZone;
    private LocalDateTime modification;

}
