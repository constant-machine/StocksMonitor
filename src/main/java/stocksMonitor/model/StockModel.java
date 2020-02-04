package stocksMonitor.model;

import stocksMonitor.entities.StockPurchase;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * Persists domain objects into db.
 */
public class StockModel {

    private EntityManager entityManager;

    public StockModel() throws NamingException {
        Context context = new InitialContext();
        Properties properties = new Properties();
        properties.setProperty("javax.persistence.jdbc.user", (String) context.lookup("db_user"));
        properties.setProperty("javax.persistence.jdbc.password", (String) context.lookup("db_password"));
        properties.setProperty("hibernate.connection.url", (String) context.lookup("db_url"));
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("stocks-persistence", properties);
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
