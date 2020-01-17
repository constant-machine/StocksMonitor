package stocksMonitor.servlets;

import stocksMonitor.entities.StockPurchase;
import stocksMonitor.model.StockModel;

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

    private StockModel model;

    public ListStocksHandler() {
    }

    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {

        // TODO: replace id with logged in user_id
        List<StockPurchase> stockPurchases = model.list(1L);

        List<Long> ids = new LinkedList<>();
        List<String> names = new LinkedList<>();
        List<String> emitents = new LinkedList<>();
        List<Long> amounts = new LinkedList<>();
        List<BigDecimal> costs = new LinkedList<>();

        for (StockPurchase stockPurchase : stockPurchases) {
            if (!stockPurchases.isEmpty()) {
                ids.add(stockPurchase.getId());
                names.add(stockPurchase.getName());
                emitents.add(stockPurchase.getEmitent());
                amounts.add(stockPurchase.getAmount());
                costs.add(stockPurchase.getCost());
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        model = new StockModel();
    }

    @Override
    public void destroy() {
        model.shutdown();
        super.destroy();
    }
}
