package servlets;

import model.ConnectToDB;
import model.Order;
import model.OrderStatus;
import model.PizzaChoice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/sendOrder")
public class sendOrderToServerServlet extends HttpServlet {

    ConnectToDB connection = new ConnectToDB();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Order newOrder = new Order();
        ArrayList<PizzaChoice> choicesArray =  (ArrayList<PizzaChoice>) session.getAttribute("choicesArray");

        String address = request.getParameter("address");
        OrderStatus status = OrderStatus.ORDER_IS_PLACED;

        newOrder.setStatus(String.valueOf(status));
        newOrder.setAddress(address);

        for (int i = 0; i < choicesArray.size(); i++) {
            newOrder.setPizzaType(choicesArray.get(i).getPizzaType());
            newOrder.setIngredients(choicesArray.get(i).getIngredients());
            newOrder.setTotalPrice(choicesArray.get(i).getTotalPrice());
        }

        connection.sendOrder(newOrder);

        session.removeAttribute("firstPageVisited");
        session.removeAttribute("pizzaArray");
        session.removeAttribute("ingredientsArray");
        session.removeAttribute("choicesArray");
        session.removeAttribute("order");

        response.sendRedirect("/");
    }
}