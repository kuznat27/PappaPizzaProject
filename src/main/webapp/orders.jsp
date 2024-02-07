<%@ page import="model.Order" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Credentials" %>
<%@ page import="model.OrderStatus" %><%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 07.02.2024
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="./styles/ordersPage2.css" />
    <title>List of orders</title>
</head>
<body>
    <header class="header">
        <%@ include file="navigation.jsp"%>
    </header>
    <section class="section1">
        <h3 class="title3">The list of orders</h3>
        <div class="menu">
            <form action="/ChangeOrderStatus" method="post">
            <ul class="list">
                <li class="menuNav item">
                    <span></span>
                    <span>№</span>
                    <span>Pizza</span>
                    <span>Ingredients</span>
                    <span>Address</span>
                    <span>Total Price</span>
                    <span>Status</span>
                </li>

                <% ArrayList<Order> ordersArray = (ArrayList<Order>) request.getAttribute("orders"); %>
                <%for (int i = 0; i < ordersArray.size(); i++) {%>
                    <li class="item color">
                        <input name="orderId" type="radio" value=<%=ordersArray.get(i).getId()%> />
                        <span><%= ordersArray.get(i).getId()%></span>
                        <span><%= ordersArray.get(i).getPizzaType()%></span>
                        <span><%= ordersArray.get(i).getIngredients()%></span>
                        <span><%= ordersArray.get(i).getAddress()%></span>
                        <span><%= ordersArray.get(i).getTotalPrice()%></span>
                        <span><%= ordersArray.get(i).getStatus()%></span>
                    </li>
                <% } %>
            </ul>
                <div class="optionContainer">
                    <h3>Choose a new status</h3>
                    <div>
                        <input id="placed" type="radio" name="status" value=<%=OrderStatus.ORDER_IS_PLACED%> />
                        <label for="placed">Order is placed</label>
                    </div>
                    <div>
                        <input id="preparing" type="radio" name="status" value=<%=OrderStatus.PREPARING%> />
                        <label for="preparing">Preparing</label>
                    </div>
                    <div>
                        <input id="delivering" type="radio" name="status" value=<%=OrderStatus.DELIVERING%> />
                        <label for="delivering">Delivering</label>
                    </div>
                    <div>
                        <input id="delivered" type="radio" name="status" value=<%=OrderStatus.DELIVERED%> />
                        <label for="delivered">Delivered</label>
                    </div>
                </div>

                <div class="btnContainer">
                    <a href="/"><button class="subBtn" type="button">Go back</button></a>
                    <input class="subBtn" type="submit" value="Change order status" />
                </div>
            </form>
        </div>
    </section>
</body>
</html>
