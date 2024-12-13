<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Movies</title>
</head>
<body>
    <table>
        <tr>
            <th>Title</th>
            <th>Note</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="movie" items="${movies}">
            <tr>
                <td>${movie.title}</td>
                <td>${movie.note}</td>
                <td>
                    <a href="updateNote?id=${movie.id}&action=increase">+</a>
                    <a href="updateNote?id=${movie.id}&action=decrease">-</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>