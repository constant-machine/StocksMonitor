package stocksMonitor.servlets;

import stocksMonitor.entities.Stock;
import stocksMonitor.model.StockProcessor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class ListStocksHandler extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ListStocksHandler() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StockProcessor processor = StockProcessor.getInstance();
        List<Stock> stocks = processor.list();

        List<Long> ids = new LinkedList<>();
        List<String> names = new LinkedList<>();
        List<String> emitents = new LinkedList<>();
        List<Long> amounts = new LinkedList<>();
        List<BigDecimal> costs = new LinkedList<>();

        for (Stock stock : stocks) {
            if (!stocks.isEmpty()) {
                ids.add(stock.getId());
                names.add(stock.getName());
                emitents.add(stock.getEmitent());
                amounts.add(stock.getAmount());
                costs.add(stock.getCost());
            }
        }

        request.setAttribute("ids", ids);
        request.setAttribute("names", names);
        request.setAttribute("emitents", emitents);
        request.setAttribute("amounts", amounts);
        request.setAttribute("costs", costs);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
