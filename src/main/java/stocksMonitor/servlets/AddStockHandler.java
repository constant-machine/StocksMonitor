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

public class AddStockHandler extends HttpServlet {

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

        Stock stock = new Stock(name, emitent, amount, cost);

        StockProcessor processor = StockProcessor.getInstance();
        processor.add(stock);

        request.setAttribute("stockInfo", stock.toString());
        doGet(request, response);
    }
}
