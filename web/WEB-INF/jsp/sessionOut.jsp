<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
         <fmt:bundle basename="com.localization.messages.msg">
        <title>error</title>
        <style>
        body {
            background-color: #826590;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h2 {
            font-size: 40px;
            color: #ff0000; /* Red color for the error message */
            text-align: center;}
 .registration {
    padding: 30px 60px;
    background: white;
    position: fixed;
    top: 40%;
    left: 50%;
    transform: translate(-50%, -50%);
    box-shadow: 10px 5px 20px rgba(0, 0, 0, 0.3);
    text-align: center;
    opacity: 0.5;
}

.registration .item {
    border-radius:20px;
    border-color: #442952;
    margin-bottom:35px;
    padding:20px 30px;
}
input[type="submit"] {
    padding: 10px 20px;
    background-color: #442952;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
        
        </style>
    </head>
    <body>
 <h2>
      <div class="registration">
     <fmt:message key="error.sessionExpired" /><br></h2>
     <br>
     <form action="page" method="post">
            <input type="hidden" name="page" value="toLogin">
            <input type="submit" value="<fmt:message key="toHomepage" />">
        </form>  
    
    </body>
    </fmt:bundle>
</html>
