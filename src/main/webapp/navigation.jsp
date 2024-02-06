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
        <%
            //HttpSession session = request.getSession(false);
            if (session != null && session.getAttribute("username") != null) {
        %>

        <button>User Active</button>
        <form action="LogoutServlet" method="post" id="id1">
            <button for="id1" type="submit">Exit</button>
        </form>
        <%
        } else {
        %>
        <form action="registration.jsp" id="id2">
            <button for="id2" type="submit">Sign Up</button>
        </form>
        <form action="login.jsp" id="i3">
            <button for="id3" type="submit">Sign In</button>
        </form>
        <%
            }
        %>
    </div>
</nav>

