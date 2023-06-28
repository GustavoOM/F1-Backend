package SCC0541.F1Backend.dtos;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UsuarioLoginDTO {

    @Schema(description = "Username do usuário cadastrado no banco")
    @NotBlank
    private String username;

    @Schema(description = "Senha do usuário cadastrado no banco")
    private String password;
}
