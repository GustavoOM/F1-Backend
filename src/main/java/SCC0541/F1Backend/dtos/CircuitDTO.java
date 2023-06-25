package SCC0541.F1Backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CircuitDTO {
    /*
    @NotNull(message = "A descrição nao pode ser nula")
    @NotEmpty(message = "A descrição nao pode estar vazia")
    @Schema(description = "Descricao do contato")
    private String descricao;

    @NotEmpty(message = "O número não pode ser vazio")
    @NotNull(message = "O número não pode ser nulo")
    @NotBlank(message = "O número não pode ser em branco")
    @Size(max = 13, message = "O número conter no máximo 13 caracteres")
    @Schema(description = "Numero ")
    private String numero;
    */

    private Integer circuitId;

    private String circuitRef;

    private String name;

    private String location;

    private String country;

    private Float lat;

    private Float lng;

    private Float alt;

    private String url;


}
