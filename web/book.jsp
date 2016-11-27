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
        <h1>${book.getTitle()}</h1>
        <br/>
        <p>
            Ce livre conte la merveilleuse histoire d'amour qu'il peut y avoir entre un animal d'une part, et une femme d'autre part.
        </p>
        <h4>Prix : ${book.getPrice()} euros</h4>
        <p>
            <a href="${context}/book/${id}/edit">Modifier</a>
        </p>
        <p>
            <a href="${context}">Retour à l'accueil</a>
        </p>
    </body>
</html>