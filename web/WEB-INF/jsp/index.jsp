<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "err" tagdir="/WEB-INF/tags" %>


<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
         <fmt:bundle basename="com.localization.messages.msg">
        <title><fmt:message key="loginTitle" /></title>
        <style>
            <%@include file="/resources/css/logincss.css"%>
        </style>
    </head>
    <body>
        <div class="registration">

            <!-- Форма для отправки данных на сервлет "welcomeServlet" при входе -->
            <form method="post" action="LoginServlet">
                <img src="resources/img/icon-university.png" alt="" class="round">
                <h2><fmt:message key="loginHeading" /></h2><br>

                <!-- Поле для ввода логина -->
                <div class="form-group">
                    <input class="form-control item" type="text" name="login"  
                           id="login" placeholder="<fmt:message key="loginPlaceholder" />">
                </div>

                <!-- Поле для ввода пароля -->
                <div class="form-group">
                    <input class="form-control item" type="password" name="password" 
                          id="password" placeholder="<fmt:message key="passwordPlaceholder" />">
                </div>

                <!-- Кнопка для отправки формы -->
                <div class="form-group">
                    <input type="submit" name="signin" id="signin"
                           class="submit" value="<fmt:message key="loginButton" />" />
                </div>
            </form>
                 <err:error />
                
                 <table>
                                    <tr>
                                        <td>
                                            <form action="LocalServlet"> 
                                                <div class="form-group form-button">
                                                    <input type="hidden" name="locale" value="en"/>
                                                    <input class="form-submit" type="submit" value='<fmt:message key = "en" />'/>
                                                </div>
                                            </form> 
                                        </td>
                                        <td>

                                            <form action="LocalServlet"> 
                                                <div class="form-group form-button">
                                                    <input type="hidden" name="locale" value="ru"/>
                                                    <input class="form-submit"  type="submit" name="locale" value='<fmt:message key = "ru" />'/>
                                                </div>
                                            </form>
                                        </td>
                                    </tr>
                                </table> 
                
        </div>
    </body>
    </fmt:bundle>
</html>

