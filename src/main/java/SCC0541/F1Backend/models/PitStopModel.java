package SCC0541.F1Backend.models;

import SCC0541.F1Backend.models.primary_keys.PitStopPK;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Pitstops")
public class PitStopModel {

    @EmbeddedId
    private PitStopPK pitStopPK;

    @Column(name = "lap")
    private Integer lap;

    @Column(name = "time")
    private String time;

    @Column(name = "duration")
    private String duration;

    @Column(name = "milliseconds")
    private Integer milisseconds;

}
