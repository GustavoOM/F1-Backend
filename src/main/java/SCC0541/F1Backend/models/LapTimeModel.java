package SCC0541.F1Backend.models;

import SCC0541.F1Backend.models.primary_keys.LapTimePK;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Laptimes")
public class LapTimeModel {

    @EmbeddedId
    private LapTimePK lapTimePK;

    @Column(name = "position")
    private Integer position;

    @Column(name = "time")
    private String time;

    @Column(name = "milliseconds")
    private Integer milisseconds;

}
