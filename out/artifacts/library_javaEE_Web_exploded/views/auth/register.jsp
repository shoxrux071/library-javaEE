<%--
  Created by IntelliJ IDEA.
  User: shoxrux
  Date: 10/11/22
  Time: 00:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="row">
    <div class="col-6 offset-3">
        <form method="post" >
            <div class="row">
                <div class="col-md-6">
                    <label>Name</label>
                    <input type="text" name="name" class="form-control" placeholder="Enter name"/>


                    <div class="form-group mb-3">
                        <label>Surname</label>
                        <input type="text" name="surname" class="form-control" placeholder="Enter Surname"/>
                    </div>

                    <div class="form-group mb-3">
                        <label>Email</label>
                        <input type="email" name="email" class="form-control" placeholder="Enter email"/>
                    </div>

                    <div class="form-group mb-3">
                        <label>Password</label>
                        <input type="password" name="password" class="form-control"
                               placeholder="Enter password"/>
                    </div>
                    <div class="form-group mb-3">
                        <label>Confirm Password</label>
                        <input type="password" name="confirmPassword" class="form-control"
                               placeholder="Enter password"/>
                    </div>

                    <button type="submit" class="btn btn-primary">register</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>