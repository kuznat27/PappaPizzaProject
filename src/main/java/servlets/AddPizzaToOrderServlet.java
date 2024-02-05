package servlets;

import model.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

@WebServlet("/addingPizza")
public class AddPizzaToOrderServlet extends HttpServlet {

    ConnectToDB connection = new ConnectToDB();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PizzaChoice choice = new PizzaChoice();

        ArrayList<PizzaType> pizzaArray = (ArrayList<PizzaType>) session.getAttribute("pizzaArray");

        Enumeration<String> parameterNames = request.getParameterNames();
        
        int pizzaPrice = 0;
        String paramName = parameterNames.nextElement();
        int quantity = Integer.parseInt(request.getParameter(paramName));
        
        for (int i = 0; i < pizzaArray.size(); i++) {
            if (pizzaArray.get(i).getPosition() == Integer.parseInt(paramName)) {
                pizzaPrice = pizzaArray.get(i).getPrice() * quantity;
            }
        }

        choice.setPizzaType(paramName);
        choice.setPizzaQuantity(quantity);
        choice.setTotalPrice(pizzaPrice);

        session.setAttribute("order", choice);

        ArrayList<IngredientType> ingredientsArray = connection.getIngredientsFromDB();
        session.setAttribute("ingredients", ingredientsArray);

        response.sendRedirect("/getIngredients");
    }
}