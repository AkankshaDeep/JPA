<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="getCountry">
<input type="text" name="coCode">
<input type="submit">
</form>

<form action="displayCountry">
<c:forEach var="i" begin="97" end="122">
    <input type="submit" name="cLetter" value="<%=Character.toChars((Integer)pageContext.getAttribute("i"))%>">
</c:forEach>
</form>
</body>
</html>