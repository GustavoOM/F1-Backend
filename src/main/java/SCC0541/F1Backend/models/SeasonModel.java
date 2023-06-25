package SCC0541.F1Backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Seasons")
public class SeasonModel {
    @Id
    @Column(name = "year")
    private Integer year;

    @Column(name = "url")
    private String url;
}
