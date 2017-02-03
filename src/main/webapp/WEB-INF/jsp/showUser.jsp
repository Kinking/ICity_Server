<%--
  Created by IntelliJ IDEA.
  User: huangzhiyuan
  Date: 2017/1/17
  Time: 下午8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户信息列表</title>
</head>
<body>
<c:if test="${!empty userList}">
    <c:forEach var="user" items="${userList}">
        姓名：${user.userName} &nbsp;&nbsp;昵称：${user.userPwd} &nbsp;&nbsp;<br>
    </c:forEach>
</c:if>
</body>
</html>

