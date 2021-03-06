<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bibliothèque</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <style>
            body {
                width: 960px;
                margin: 30px;
            }
        </style>
    </head>
    <body>
        <h1>Liste des livres</h1>
        <br/>
        <c:if test="${books.size() > 0}">
            <table class="table table-bordered table-striped">
                <tr>
                    <th>ISBN</th>
                    <th>Nom du livre</th>
                    <th>Auteur(s)</th>
                    <th>Prix</th>
                </tr>
                <c:forEach items="${books}" var="book">
                    <tr>
                        <td>${book.getIsbn()}</td>
                        <td><a href="${context}/book/${book.getIsbn()}">${book.getTitle()}</a></td>
                        <td>
                            <c:forEach items="${book.getAuthors()}" var="author">
                            ${author.gestLastName()} ${author.getFirstName()}
                            </c:forEach>
                        </td>
                        <td>${book.getPrice()}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>