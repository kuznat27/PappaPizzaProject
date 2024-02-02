<html>
<head>
    <link rel="stylesheet" href="./styles/indexStyles.css"/>
    <title>Pizza cafe</title>
</head>
<body>
<header class="header">
    <nav class="nav">
        <h1 class="title1">Welcome to Papa Pizza</h1>
        <div style="position: absolute; top: 10px; right: 10px;">
        <form action="registration.jsp" style="display: inline;">
            <input type="submit" value="Sign Up">
        </form>
        <form action="login.jsp" style="display: inline;">
            <input type="submit" value="Sign In">
        </form>
        </div>
    </nav>
    <ul class="list">
        <li>
            <a href="pizzaMenu.jsp"><button>Order pizza</button></a>
        </li>
        <li>
            <button>Change order status</button>
        </li>
    </ul>
</header>
</body>
</html>