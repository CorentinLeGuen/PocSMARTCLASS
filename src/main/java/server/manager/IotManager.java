package server.manager;

import server.entities.IotEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class IotManager {

    public static void saveIotEntity(Object o) {
        if (o == null) return;

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JEE-Persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        try {
            IotEntity iotEntity = (IotEntity)o;

            entityManager.persist(iotEntity);
        } catch (Exception e) {
            System.err.println("Erreur de cast de object en iotEntity : " + e.getMessage());
            e.printStackTrace();
        }

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
