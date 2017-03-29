<%--
  Created by IntelliJ IDEA.
  User: jocopernicus
  Date: 3/22/2017
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html lang="en">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Insert title here</title>
</head>
<body>
<%--<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
Spring error
</c:if>--%>
<form action="${contextPath}/login" method="post">
  <table>
    <tr>
      <td>Login</td>
      <td><input type="text" name="username"></td>
    </tr>
    <tr>
      <td>Pass word</td>
      <td><input type="password" name="password"></td>
    </tr>
    <tr>
      <td><input type="submit" value="Login"></td>
    </tr>
  </table>
</form>
</body>
</html>
