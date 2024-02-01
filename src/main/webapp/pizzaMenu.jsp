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
<%--                <% ArrayList<PizzaType> pizzaArray = (ArrayList<PizzaType>) request.getAttribute("pizza"); %>--%>
<%--                <%for (int i = 0; i < pizzaArray.size(); i++) {%>--%>
<%--                <li>--%>
<%--                    <%= pizzaArray.get(i).getName() %>--%>
<%--                </li>--%>
<%--                <% } %>--%>
<section class="section1">
    <form class="form">
        <ul class="list">
            <li>
                <span>№</span>
                <span>Name</span>
                <span>Price</span>
                <span>Quantity</span>
            </li>
            <li>
                <span>1</span>
                <span>Pepperoni</span>
                <span>$15</span>
                <span>
                    <input type="number" name="quantity" min="0" max="5" value="0"/>
                </span>
            </li>
            <li>
                <span>2</span>
                <span>Cheese</span>
                <span>$15</span>
                <span>
                    <input type="number" name="quantity" min="0" max="5" value="0"/>
                </span>
            </li>
            <li>
                <span>3</span>
                <span>Diablo</span>
                <span>$15</span>
                <span>
                    <input type="number" name="quantity" min="0" max="5" value="0"/>
                </span>
            </li>
            <li>
                <span>1</span>
                <span>Pepperoni</span>
                <span>$15</span>
                <span>
                    <input type="number" name="quantity" min="0" max="5" value="0"/>
                </span>
            </li>
        </ul>
        <input type="submit" value="Continue" class="subBtn"/>
    </form>
</section>
</body>
</html>
