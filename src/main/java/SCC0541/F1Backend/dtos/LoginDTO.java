package SCC0541.F1Backend.dtos;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LoginDTO {
    private Integer userId;
    private String username;
    private String password;
    private String tipo;
    private Integer originalId;
}
