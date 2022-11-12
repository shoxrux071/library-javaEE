<%--
  Created by IntelliJ IDEA.
  User: shoxrux
  Date: 10/11/22
  Time: 00:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="row">
    <div class="col-6 offset-3">
        <form method="post">

            <div class="form-group">
                <label for="email">Username</label>
                <input type="text" class="form-control" name="email" id="email" placeholder="email">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" name="password" id="password" placeholder="Password">
            </div>
            <button type="submit" class="btn btn-primary">Login</button>
            <a href="/register" class="btn btn-warning">Register</a>
        </form>
    </div>
</div>
</body>
</html>