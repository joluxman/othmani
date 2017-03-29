<%--
  Created by IntelliJ IDEA.
  User: jocopernicus
  Date: 3/19/2017
  Time: 12:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css">
</head>
<body>
<div class="errors">
  ${exception}
</div>
<div id="formCat" class="frame">
  <f:form modelAttribute="category" action="saveCat" method="POST" enctype="multipart/form-data">
    <table>
      <tr>
        <td>Id Category</td>
        <td><f:input path="idCategory"/></td>
        <td><f:errors path="idCategory" cssClass="errors"></f:errors></td>
      </tr>
      <tr>
        <td>Name Category</td>
        <td><f:input path="name"/></td>
        <td><f:errors path="name" cssClass="errors"></f:errors></td>
      </tr>
      <tr>
        <td>Name Category</td>
        <td><f:textarea path="description"/></td>
        <td><f:errors path="description" cssClass="errors"></f:errors></td>
      </tr>
      <tr>
        <td>Photo</td>
        <td>
          <c:if test="${category.idCategory!=null}">
            <img src="photoCat?idCat=${category.idCategory}" />
          </c:if>
        </td>
        <td>
          <input type="file" name="file"/>
        </td>
      </tr>
      <tr>
        <td><input type="submit" value="Save"/></td>
      </tr>
    </table>
  </f:form>
</div>
<div id="showData" class="frame">
<table class="tab1">
  <tr>
    <th>Id</th><th>Name Category</th><th>Description</th><th>Photo</th>
  </tr>
  <c:forEach items="${categories}" var="cat">
    <tr>
      <td>${cat.idCategory}</td>
      <td>${cat.name}</td>
      <td>${cat.description}</td>
      <td><img src="photoCat?idCat=${cat.idCategory}" /></td>
      <td><a href="deleteCat?idCat=${cat.idCategory}">Delete</a></td>
      <td><a href="editCat?idCat=${cat.idCategory}">Edit</a></td>
    </tr>
  </c:forEach>
</table>
</div>
</body>
</html>
