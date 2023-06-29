package SCC0541.F1Backend.repositories;

import SCC0541.F1Backend.database.SQLScripts;
import SCC0541.F1Backend.dtos.CreateConstructorDTO;
import SCC0541.F1Backend.models.ConstructorModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ConstructorRepository {

    private final EntityManagerFactory entityManagerFactory;

    public ConstructorRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void createConstructor(CreateConstructorDTO constructorDTO) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try{
            entityManager.getTransaction().begin();

            jakarta.persistence.Query query = entityManager.createNativeQuery(
                    SQLScripts.CONSTRUCTOR_INSERT
            );

            query.setParameter("constructorRef", constructorDTO.getConstructorRef());
            query.setParameter("name", constructorDTO.getName());
            query.setParameter("nationality", constructorDTO.getNationality());
            query.setParameter("url", constructorDTO.getUrl());

            query.executeUpdate();

            entityManager.getTransaction().commit();

        } catch (Exception exception) {
            entityManager.getTransaction().rollback();
            throw exception;
        } finally {
            entityManager.close();
        }
    }

    public ArrayList<ConstructorModel> findAll() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try{
            entityManager.getTransaction().begin();

            Query query = entityManager.createNativeQuery(
                    SQLScripts.FIND_ALL_CONSTRUCTORS
            );

            List<Object[]> tuplas = query.getResultList();

            ArrayList<ConstructorModel> responseList = new ArrayList<>();

            tuplas.forEach(tupla ->
                    responseList.add(
                            ConstructorModel.builder()
                                    .constructorId(Integer.valueOf(tupla[0].toString()))
                                    .constructorRef(tupla[1].toString())
                                    .name(tupla[2].toString())
                                    .nationality(tupla[3].toString())
                                    .url(tupla[4].toString())
                                    .build()
                    )
            );

            return responseList;

        } catch (Exception exception) {
            entityManager.getTransaction().rollback();
            throw exception;
        } finally {
            entityManager.close();
        }

    }

    public Optional<ConstructorModel> findById(Integer id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try{
            entityManager.getTransaction().begin();

            Query query = entityManager.createNativeQuery(
                    SQLScripts.FIND_CONSTRUCTOR_BY_ID
            );

            query.setParameter("constructorId", id);

            Object[] singleResult = (Object[]) query.getSingleResult();

            return Optional.ofNullable(ConstructorModel.builder()
                    .constructorId(Integer.valueOf(singleResult[0].toString()))
                    .constructorRef(singleResult[1].toString())
                    .name(singleResult[2].toString())
                    .nationality(singleResult[3].toString())
                    .url(singleResult[4].toString())
                    .build());

        } catch (Exception exception) {
            entityManager.getTransaction().rollback();
            throw exception;
        } finally {
            entityManager.close();
        }

    }

}