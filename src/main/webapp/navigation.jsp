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
</style>

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
