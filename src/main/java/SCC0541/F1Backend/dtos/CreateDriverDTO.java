package SCC0541.F1Backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateDriverDTO {

    private String driverRef;

    private Integer number;

    private String code;

    private String forename;

    private String surname;

    private LocalDate dob;

    private String nationality;

}
