package SCC0541.F1Backend.repositories;

import SCC0541.F1Backend.database.SQLScripts;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;


@Repository
public class LogRepository {

    private final EntityManagerFactory entityManagerFactory;

    public LogRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    /*
     *   1) Buscamos a sessão com o banco por meio do entityManager.
     *   2) Começamos uma transação
     *   3) Criamos uma consulta parametrizada, protegida contra SQL injection e inserimos os parâmetros
     *   4) Caso não ocorram exceptions, fazemos commit e a conexão é fechada
     *   5) Caso hajam exceptions, fazemos rollback, relançamos a exception para a classe
     *      ExceptionHandlerController a fim de pegar a mensagem e enviá-la para o usuário,
     *      e a conexão é fechada
     * */

    public void createLog(Integer id, Integer idOriginal) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try{
            entityManager.getTransaction().begin();

            Query query = entityManager.createNativeQuery(
                    SQLScripts.LOG_INSERT
            );

            query.setParameter("id", id);
            query.setParameter("idOriginal", idOriginal);

            query.executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception exception) {
            entityManager.getTransaction().rollback();
            throw exception;
        } finally {
            entityManager.close();
        }
    }
}