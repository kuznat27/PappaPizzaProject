<%@ page import="model.Order" %>
<%@ page import="model.PizzaChoice" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.PizzaType" %>
<%@ page import="model.IngredientType" %><%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 05.02.2024
  Time: 4:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order display</title>
    <link href="styles/orderStyles.css" rel="stylesheet">
</head>
<body>
<header class="header">
    <%@ include file="navigation.jsp"%>
</header>
<section class="section1">
    <div class="menu">
        <ul class="list">
            <li class="menuNav item">
                <span>№</span>
                <span>Pizza</span>
                <span>Quantity</span>
                <span>Ingredients</span>
                <span>Quantity</span>
                <span>Total price</span>
            </li>

            <%--How to not refresh it? --%>

            <%PizzaChoice choice = (PizzaChoice) session.getAttribute("order"); %>
            <%ArrayList<PizzaType> pizzaArray = (ArrayList<PizzaType>) session.getAttribute("pizzaArray");%>
            <%ArrayList<IngredientType> ingredientsArray = (ArrayList<IngredientType>) session.getAttribute("ingredients");%>
            <%ArrayList<PizzaChoice> choicesArray = (ArrayList<PizzaChoice>) session.getAttribute("choicesArray"); %>
            <%choicesArray.add(choice);%>


            <% for (int i = 0; i < choicesArray.size(); i++) { %>
            <li class="item color">
                <span><%= i + 1 %></span>
                <span>
                    <% int pizzaIndex = Integer.parseInt(choicesArray.get(i).getPizzaType());%>
                    <% String pizzaName = pizzaArray.get(pizzaIndex).getName();%>
                    <%= pizzaName %>
                </span>
                <span><%=choicesArray.get(i).getPizzaQuantity()%></span>
                <span>
                    <% int ingredientIndex = Integer.parseInt(choicesArray.get(i).getIngredients());%>
                    <% String ingredientName = ingredientsArray.get(ingredientIndex).getName();%>
                    <%= ingredientName %>
                </span>
                <span><%=choicesArray.get(i).getIngredientQuantity()%></span>
                <span><%=choicesArray.get(i).getTotalPrice()%></span>
            </li>
            <% } %>

            <a href="/pizzaMenu"><button class="btn">Add more pizza</button></a>

            <form action="/sendingOrder" method="post">
                <div class="addressContainer">
                    <h3 class="title3">Fill in your address, please. </h3>
                    <div class="inputContainer">
                        <label class="label" for="address">Address: </label>
                        <input type="text" placeholder="Saint-Petersburg..." name="address" id="address"/>
                    </div>
                </div>
                <input type="Submit" value="Place order" class="subBtn"/>
            </form>
        </ul>
    </div>
</section>
</body>
</html>

<%--Order newOrder = new Order;--%>
<%--for (int i = 0; i < choicesArray.size(); i++) {--%>
<%--    String pizza = choicesArray.get(i).getPizzaType();--%>
<%--    newOrder.setPizza(pizza);--%>
<%--    String ingredient = choicesArray.get(i).getIngerdientType();--%>
<%--    newOrder.setIngredient(pizza);--%>
<%--    // { Pizza: 2x1, Ingredient: 1 }--%>
<%--    // { Pizza: 2, 3; }--%>
<%--}--%>
