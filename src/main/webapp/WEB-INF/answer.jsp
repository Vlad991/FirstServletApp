<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
Hello, ${name}
<c:forEach var="item" items="${list}">
    <c:out value="${item}"/>
</c:forEach>
</body>
</html>
