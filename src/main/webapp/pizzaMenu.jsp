<%@ page import="model.PizzaType" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <link rel="stylesheet" href="./styles/pizzaMenuStyles.css"/>
    <title>Pizza menu</title>
</head>
<body>
<header class="header">
    <nav class="nav">
        <h1 class="title1">Welcome to Papa Pizza</h1>
        <div>
            <button>Sign up</button>
            <button>Sign up</button>
        </div>
    </nav>
</header>
<section class="section1">
    <form class="form">
        <ul class="list">
            <li>
                <span>№</span>
                <span>Name</span>
                <span>Price</span>
                <span>Quantity</span>
            </li>

            <% ArrayList<PizzaType> pizzaArray = (ArrayList<PizzaType>) request.getAttribute("pizza"); %>
            <%for (int i = 0; i < pizzaArray.size(); i++) {%>
            <li>
                <span><%= pizzaArray.get(i).getPosition()%></span>
                <span><%= pizzaArray.get(i).getName()%></span>
                <span><%= pizzaArray.get(i).getPrice()%></span>
                <span>
                        <input type="number" name="quantity" min="0" max="5" value="0"/>
                    </span>
            </li>
            <% } %>
        </ul>
        <input type="submit" value="Continue" class="subBtn"/>
    </form>
</section>
</body>
</html>
