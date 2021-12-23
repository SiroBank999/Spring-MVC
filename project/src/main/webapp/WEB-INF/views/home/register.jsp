<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>REGISTER</title>
    <style>
        .message{
            color: green;
        }
    </style>
</head>
<%@ page isELIgnored="false" %>
<body>
    <h1>REGISTER</h1>
    <p>
      <c:if test="${msg != null}">
          <span class="message">${msg}</span>
      </c:if>
    </p>
    <form:form action="register" method="post" modelAttribute="user">
        <fieldset>
            <table>
             
                <tr>
                    <td><form:label path="username">Username:</form:label></td>
                    <td><form:input path="username"/> </td>
                    <td><form:errors path="username" cssClass="message" /></td>
                </tr>
                <tr>
                    <td><form:label path="password">Password:</form:label></td>
                    <td><form:password path="password"/> </td>
                    <td><form:errors path="password" cssClass="message" /></td>
                </tr>
                <tr>
                    <td><label>Repassword:</label></td>
                    <td><input type="password" name="repassword"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><form:button>Create</form:button> </td>
                </tr>
            </table>
        </fieldset>
    </form:form>
     <a href="login">Login</a>
</body>
</html>
