package servlets;

import model.ConnectToDB;
import model.PizzaChoice;
import model.PizzaType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/pizzaMenu")
public class PizzaMenuServlet extends HttpServlet {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    ConnectToDB connection = new ConnectToDB();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // New line
        HttpSession session = request.getSession();
        ArrayList<PizzaType> pizzaArray = connection.getPizzaFromDB();

        Object isFirstPageVisited = session.getAttribute("firstPageVisited");

        if (isFirstPageVisited == null) {
            ArrayList<PizzaChoice> choicesArray = new ArrayList<>();

            session.setAttribute("firstPageVisited", true);
            session.setAttribute("choicesArray", choicesArray);
        }

        session.setAttribute("pizzaArray", pizzaArray);
        request.setAttribute("pizza", pizzaArray);
        getServletContext().getRequestDispatcher("/pizzaMenu.jsp").forward(request, response);
    }

}