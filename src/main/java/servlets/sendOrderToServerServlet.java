package servlets;

import model.Order;
import model.PizzaChoice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/sendOrder")
public class sendOrderToServerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        Order newOrder = new Order();
//        String address = request.getParameter("address");
//
//        newOrder.setAddress(address);
//
//        ArrayList<PizzaChoice> choicesArray =  (ArrayList<PizzaChoice>) session.getAttribute("choicesArray");
//
//        for (int i = 0; i < choicesArray.size(); i++) {
//            newOrder.setPizzaType(choicesArray.get(i).getPizzaType());
//            newOrder.setIngredients(choicesArray.get(i).getIngredients());
//            newOrder.setTotalPrice(choicesArray.get(i).getTotalPrice());
//        }
//
//        System.out.println(newOrder);
    }
}