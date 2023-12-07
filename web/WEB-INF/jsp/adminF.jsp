<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        body {
            background-color: #826590;
        }

        h2 {
            font-size: 40px;
            color: #442952;
        }

        .signin-form {
            padding: 30px 60px;
            background: white;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            box-shadow: 10px 5px 20px rgba(0, 0, 0, 0.3);
            text-align: center;
            opacity: 0.5;
        }

        .nav-menu {
            list-style-type: none;
            padding: 0;
        }

        .nav-menu li {
            margin-bottom: 20px;
        }

        .nav-menu a {
            display: block;
            padding: 10px;
            background-color: #442952;
            color: white;
            text-decoration: none;
            border-radius: 10px;
        }

        .nav-menu a i {
            margin-right: 10px;
        }
        .round {
    width: 300px; /* Adjust the width of the image */
}
    </style>
</head>
<body>
<div class="signin-form">
                    <img src="resources/img/icon-university.png" alt="" class="round">

    <ul class="nav-menu">
        <li>
            <a href="addAbiturient" method="post">
                <i class="fas fa-plus"></i> addAbiturient
            </a>
        </li>
        <li>
            <a href="readAbiturient">
                <i class="fas fa-user"></i> readAbiturient
            </a>
        </li>
    </ul>
</div>
</body>
</html>
