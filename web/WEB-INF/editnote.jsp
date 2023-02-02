<%-- 
    Document   : editnote
    Created on : 30-Jan-2023, 10:04:59 AM
    Author     : lynnpark
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="post" action="hello">
            Title: <input type="text" name="firstname" value="${firstname}"><br>
            Contents:<br> <input type="text" name="lastname" value="${lastname}"><br>
            <input type="submit" value="Submit">
        </form>
            <p>${message}</p>
            <a href="note?edit"> 
    </body>
</html>
