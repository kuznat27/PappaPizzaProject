package servlets;

import model.ConnectToDB;
import model.IngredientType;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/getIngredients")
public class IngredientsMenuServlet extends HttpServlet {

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
        ArrayList<IngredientType> ingredientsArray = connection.getIngredientsFromDB();
        HttpSession session = request.getSession();
        session.setAttribute("ingredientsArray", ingredientsArray);
        request.setAttribute("ingredients", ingredientsArray);
        getServletContext().getRequestDispatcher("/ingredientsMenu.jsp").forward(request, response);
    }

}