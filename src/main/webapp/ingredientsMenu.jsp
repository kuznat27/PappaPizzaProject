<%@ page import="model.IngredientType" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 05.02.2024
  Time: 2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ingredients choice</title>
    <link rel="stylesheet" href="./styles/ingredientsMenu.css" />
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
                    <span>Name</span>
                    <span>Price</span>
                    <span>Quantity</span>
                </li>

                <% ArrayList<IngredientType> ingredientsArray = (ArrayList<IngredientType>) request.getAttribute("ingredients"); %>
                <%for (int i = 0; i < ingredientsArray.size(); i++) {%>
                <form action="/addingIngredients" method="post">
                    <li class="item color">
                        <span><%= ingredientsArray.get(i).getPosition()%></span>
                        <span><%= ingredientsArray.get(i).getName()%></span>
                        <span><%= ingredientsArray.get(i).getPrice()%></span>
                        <span class="inputContainer">
                            <input type="number" name=<%=ingredientsArray.get(i).getPosition()%> min="0" max="5" value="0"/>
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
