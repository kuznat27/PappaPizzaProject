package servlets;

import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/fetchingOrders")
public class FetchingOrdersServlet extends HttpServlet {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    ConnectToDB connection = new ConnectToDB();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Order> orderArray = connection.getOrders();
        ArrayList<PizzaType> arrayOfPizzas = connection.getPizzaFromDB();
        ArrayList<IngredientType> ingredientArray = connection.getIngredientsFromDB();

        RefactorArray.refactorPizzaTypes(orderArray, arrayOfPizzas);
        RefactorArray.refactorIngredientTypes(orderArray, ingredientArray);

        HttpSession session = request.getSession();
        session.setAttribute("orders", orderArray);

        request.setAttribute("orders", orderArray);
        getServletContext().getRequestDispatcher("/orders.jsp").forward(request, response);

    }

}