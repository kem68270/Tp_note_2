<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Liste des films</title>
    <meta charset="UTF-8" />
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
        }
        th {
            text-align: left;
        }
    </style>
</head>
<body>
    <h1>Liste des films</h1>
    <table>
        <tr>
            <th>Titre</th>
            <th>Année</th>
            <th>Acteurs</th>
            <th>Affiche</th>
            <th>Baisser Note</th>
            <th>Note</th>
            <th>Augmenter</th>
        </tr>
        <c:forEach var="film" items="${requestScope.films}">
            <tr>
                <td>${film.title}</td>
                <td>${film.annee}</td>
                <td>${film.acteur}</td>
                <td><img src="${film.poster}" alt="Affiche" style="height: 100px;"/></td>
                <td><a href="updateNote?id=${film.id}&action=decrease">-</a></td>
                <td>${film.note}</td>
                <td><a href="updateNote?id=${film.id}&action=increase">+</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
