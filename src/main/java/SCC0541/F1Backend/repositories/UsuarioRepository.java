package SCC0541.F1Backend.repositories;

import SCC0541.F1Backend.dtos.UsuarioRespostaDTO;
import SCC0541.F1Backend.models.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

    @Query(value = "SELECT * FROM USERS WHERE login = :login", nativeQuery = true)
    Optional<UsuarioModel> findByLogin(@Param("login") String login);

    @Query(value = "SELECT * FROM USERS WHERE userId = :id", nativeQuery = true)
    Optional<UsuarioModel> findById(@Param("id") String login);

    @Query(value = "SELECT * FROM USERS WHERE tipo = :tipoPessoa", nativeQuery = true)
    List<UsuarioModel> listarUsuariosDoSistemaPorTipo(String tipoPessoa);

    @Query(value = "SELECT * FROM USERS", nativeQuery = true)
    List<UsuarioModel> listarUsuariosDoSistema();
}
