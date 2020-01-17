package stocksMonitor.model;

import stocksMonitor.entities.StockPurchase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.LinkedList;
import java.util.List;

/**
 * Persists domain objects into db.
 */
public class StockModel {

    private EntityManager entityManager;

    public StockModel() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("stocks-persistence");
        entityManager = factory.createEntityManager();
    }

    public void shutdown() {
        entityManager.getEntityManagerFactory().close();
        entityManager.close();
    }

    /**
     * Add new purchase into table.
     * @param purchase to add
     */
    public void add(StockPurchase purchase) {
        entityManager.getTransaction().begin();
        entityManager.persist(purchase);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    /**
     * List of user purchases.
     * @param userId to look for
     * @return list with purchases
     */
    public List<StockPurchase> list(Long userId) {
        List<StockPurchase> stockPurchases = new LinkedList<>();

        entityManager.getTransaction().begin();
        stockPurchases.addAll(entityManager.createQuery(
                "FROM StockPurchase WHERE user_id=" + userId, StockPurchase.class)
                .getResultList());
        entityManager.flush();
        entityManager.getTransaction().commit();
        return stockPurchases;
    }
}
