package SCC0541.F1Backend.dtos;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UsuarioLoginDTO {
    private String username;
    private String password;
}
