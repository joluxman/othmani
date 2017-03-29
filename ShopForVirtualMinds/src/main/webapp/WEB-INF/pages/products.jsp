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

<div id="formProd" class="frame">
  <f:form modelAttribute="product" action="saveProd" method="POST" enctype="multipart/form-data">
    <table>
      <tr>
        <td>Id Product</td>
        <td><f:input path="idProduct"/></td>
        <td><f:errors path="idProduct" cssClass="errors"></f:errors></td>
      </tr>
      <tr>
        <td>Name Product</td>
        <td><f:input path="name"/></td>
        <td><f:errors path="name" cssClass="errors"></f:errors></td>
      </tr>
      <tr>
        <td>Category</td>
        <td><f:select path="category.idCategory" items="${categories}" itemValue="idCategory" itemLabel="name"></f:select></td>
        <td><%--<f:errors path="name" cssClass="errors"/>--%></td>
      </tr>
      <tr>
        <td>Description Product</td>
        <td><f:textarea path="description"/></td>
        <td><f:errors path="description" cssClass="errors"></f:errors></td>
      </tr>
      <tr>
        <td>Price</td>
        <td><f:input path="price"/></td>
        <td><f:errors path="price" cssClass="errors"></f:errors></td>
      </tr>
      <tr>
        <td>Quantity</td>
        <td><f:input path="stockQuantity"/></td>
        <td><f:errors path="stockQuantity" cssClass="errors"></f:errors></td>
      </tr>
      <tr>
        <td>Selected?</td>
        <td><f:checkbox path="selected"/></td>
        <td><f:errors path="selected" cssClass="errors"></f:errors></td>
      </tr>

      <tr>
        <td>Photo</td>
        <td>
          <c:if test="${product.idProduct!=null}">
            <img src="photoProd?idProd=${product.idProduct}" />
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
<div id="tabProducts" class="frame">
<table class="tab1">
  <tr>
    <th>Id</th><th>Name</th><th>Description</th><th>Category</th><th>Price</th><th>Quantity</th><th>Selected</th><th>Photo</th>
  </tr>
  <c:forEach items="${products}" var="prod">
    <tr>
      <td>${prod.idProduct}</td>
      <td>${prod.name}</td>
      <td>${prod.description}</td>
      <td>${prod.category.name}</td>
      <td>${prod.price}</td>
      <td>${prod.stockQuantity}</td>
      <td>${prod.selected}</td>
      <td><img src="photoProd?idProd=${prod.idProduct}" /></td>
      <td><a href="deleteProd?idProd=${prod.idProduct}">Delete</a></td>
      <td><a href="editProd?idProd=${prod.idProduct}">Edit</a></td>
    </tr>
  </c:forEach>
</table>
</div>
</body>
</html>
