<%@ page import="model.PizzaType" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <link rel="stylesheet" href="./styles/pizzaMenu2.css"/>
    <title>Pizza menu</title>
</head>
<body>
<header class="header">
    <%@ include file="navigation.jsp"%>
</header>
<section class="section1">
    <h3 class="title3">Choose the pizza you like</h3>
    <div class="menu">
        <ul class="list">
            <li class="menuNav item">
                <span>№</span>
                <span>Name</span>
                <span>Price</span>
                <span>Quantity</span>
            </li>

            <% ArrayList<PizzaType> pizzaArray = (ArrayList<PizzaType>) request.getAttribute("pizza"); %>
            <%for (int i = 0; i < pizzaArray.size(); i++) {%>
            <form action="/addingPizza" method="post">
                <li class="item color">
                    <span><%= pizzaArray.get(i).getPosition()%></span>
                    <span><%= pizzaArray.get(i).getName()%></span>
                    <span><%= pizzaArray.get(i).getPrice()%></span>
                    <span class="inputContainer">
                            <input type="number" name=<%=pizzaArray.get(i).getPosition()%> min="0" max="5" value="0"/>
                            <input type="submit" value="Add" class="subBtn"/>
                    </span>
                </li>
            </form>
            <% } %>
        </ul>
    </div>
</section>
</body>
</html>
