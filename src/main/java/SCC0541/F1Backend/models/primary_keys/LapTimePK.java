package SCC0541.F1Backend.models.primary_keys;



import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class LapTimePK implements Serializable {

    @Column(name = "raceid")
    private Integer raceId;

    @Column(name = "driverid")
    private Integer driverId;

    @Column(name = "lap")
    private Integer lap;

}
