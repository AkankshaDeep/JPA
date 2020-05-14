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
<h1>By name or code</h1>
<table>
<c:forEach items="${country}" var="country">
    <tr>
     <td>Code:${country}</td>                
    </tr>
</c:forEach>
</table>
<h3>Sorted</h3>
<table>
<c:forEach items="${countryList}" var="countryList">
    <tr>
     <td>Code:${countryList}</td>                
    </tr>
</c:forEach>
</table>
<h1>by Letter</h1>
<table>
<c:forEach items="${countryByLetter}" var="countryByLetter">
    <tr>
     <td>Code:${countryByLetter}</td>                
    </tr>
</c:forEach>
</table>
<h3>Sorted</h3>
<table>
<c:forEach items="${sortedCountryByLetter}" var="sortedCountryByLetter">
    <tr>
     <td>Code:${sortedCountryByLetter}</td>                
    </tr>
</c:forEach>
</table>
</body>
</html>