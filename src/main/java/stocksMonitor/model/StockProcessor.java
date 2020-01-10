package stocksMonitor.model;

import stocksMonitor.entities.Stock;

import java.util.LinkedList;
import java.util.List;

/**
 * Singleton that registers and keeps list of stocks.
 */
public class StockProcessor {

    private static StockProcessor instance = new StockProcessor();
    private List<Stock> stocks;

    private StockProcessor() {
        stocks = new LinkedList<Stock>();
    }

    public static StockProcessor getInstance() {
        return instance;
    }

    public synchronized void add(Stock stock) {
        stock.setId((long) stocks.size());
        stocks.add(stock);
    }

    public List<Stock> list() {
        return stocks;
    }
}
