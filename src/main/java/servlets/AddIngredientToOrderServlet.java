package servlets;

import model.IngredientType;
import model.Order;
import model.PizzaChoice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

@WebServlet("/addingIngredients")
public class AddIngredientToOrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PizzaChoice choice = (PizzaChoice) session.getAttribute("order");

        ArrayList<IngredientType> ingredientsArray = (ArrayList<IngredientType>) session.getAttribute("ingredients");

        Enumeration<String> parameterNames = request.getParameterNames();

        int ingredientPrice = 0;
        String paramName = parameterNames.nextElement();
        int quantity = Integer.parseInt(request.getParameter(paramName));

        for (int i = 0; i < ingredientsArray.size(); i++) {
            if (ingredientsArray.get(i).getPosition() == Integer.parseInt(paramName)) {
                ingredientPrice = ingredientsArray.get(i).getPrice() * quantity;
            }
        }

        choice.setIngredients(paramName);
        choice.setIngredientQuantity(quantity);
        choice.setTotalPrice(ingredientPrice);

        session.setAttribute("order", choice);

        response.sendRedirect("orderDisplay.jsp");
    }
}