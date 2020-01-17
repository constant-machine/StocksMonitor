package stocksMonitor.servlets;

import stocksMonitor.entities.StockPurchase;
import stocksMonitor.entities.User;
import stocksMonitor.model.StockModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

public class AddStockHandler extends HttpServlet {

    private StockModel model;
    private User user;

    public AddStockHandler() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/add.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String emitent = request.getParameter("emitent");
        Long amount = Long.valueOf(request.getParameter("amount"));
        BigDecimal cost = new BigDecimal(request.getParameter("cost"));
        StockPurchase purchase = new StockPurchase(name, emitent, amount, cost, user);

        model.add(purchase);

        request.setAttribute("stockInfo", purchase.toString());
        doGet(request, response);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        model = new StockModel();
        //TODO: replace with logged in user
        user = new User("TestUser");
    }

    @Override
    public void destroy() {
        model.shutdown();
        super.destroy();
    }
}
