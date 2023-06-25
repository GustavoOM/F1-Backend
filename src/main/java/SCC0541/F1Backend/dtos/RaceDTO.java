package SCC0541.F1Backend.dtos;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RaceDTO {
    private Integer qualifyId;

    private Integer year;

    private Integer round;

    private Integer circuitId;

    private String name;

    private LocalDateTime date;

    private String time;

    private String url;

    private LocalDateTime dfp1;

    private String tfp1;

    private LocalDateTime dfp2;

    private String tfp2;

    private LocalDateTime dfp3;

    private String tfp3;

    private LocalDateTime dquali;

    private String tquali;

    private LocalDateTime dsprint;

    private String tsprint;
}
