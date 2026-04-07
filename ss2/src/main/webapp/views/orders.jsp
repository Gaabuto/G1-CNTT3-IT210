<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ad
  Date: 4/8/2026
  Time: 12:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  Xin chào, ${sessionScope.loggedUser}! Vai trò: ${sessionScope.role}
</head>
<body>
<table>
  <tr>
    <th>Mã</th>
    <th>Sản phẩm</th>
    <th>Tổng tiền</th>
    <th>Ngày đặt</th>
  </tr>

  <c:forEach var="o" items="${orders}">
    <tr>
      <td>${o.id}</td>
      <td>${o.productName}</td>

      <td>
        <fmt:formatNumber value="${o.total}" type="currency"/>
      </td>

      <td>
        <fmt:formatDate value="${o.date}" pattern="dd/MM/yyyy"/>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
