package servlets;

import model.ConnectToDB;
import model.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ChangeOrderStatus")
public class ChangeOrderStatusServlet extends HttpServlet {

    ConnectToDB connection = new ConnectToDB();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("orderId"));
        String status = request.getParameter("status");

        connection.changeOrderStatus(status, id);

        response.sendRedirect("/");

    }
}