<%--
  Created by IntelliJ IDEA.
  User: Александр
  Date: 05.02.2024
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<style>
    .nav {
        width:100%;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    .title1 {
        font-size: 24px;
        font-weight: bold;
    }

    .auth-buttons {
        position: absolute;
        top: 10px;
        right: 10px;
    }

    .btnContainer {
        display:flex;
        gap:20px;
    }

    .btnContainer button {
        display: block;
        font-size: 16px;
        padding:8px 8px;
        border-radius: 10px;
        border: 1px solid black;
        cursor:pointer;
        margin-top:20px;
        margin-inline:auto;
        background-color: transparent;
    }


    .btnContainer button:hover {
        background-color: #64ac8f;
        color: white;
    }

</style>

<nav class="nav">
    <h1 class="title1">Welcome to Papa Pizza</h1>
    <div class="btnContainer">
        <button>Sign up</button>
        <button>Sign in</button>
    <div class="auth-buttons">
        <%
            //HttpSession session = request.getSession(false);
            if (session != null && session.getAttribute("username") != null) {
        %>
        User Active
        <form action="LogoutServlet" method="post" style="display: inline;">
            <input type="submit" value="Exit">
        </form>
        <%
        } else {
        %>
        <form action="registration.jsp" style="display: inline;">
            <input type="submit" value="Sign Up">
        </form>
        <form action="login.jsp" style="display: inline;">
            <input type="submit" value="Sign In">
        </form>
        <%
            }
        %>
    </div>
</nav>

