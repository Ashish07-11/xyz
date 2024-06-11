<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Multiplication Table</title>
</head>
<body>
    <%-- Retrieve the num value from the attribute set in the servlet --%>
    <% int num = (Integer) request.getAttribute("num"); %>

    <h2>Multiplication Table of <%= num %></h2>
    <table border='1'>
        <%-- Generate the multiplication table using a loop --%>
        <% for (int i = 1; i <= 10; i++) { %>
            <tr>
                <td><%= num %> * <%= i %></td>
                <td><%= num * i %></td>
            </tr>
        <% } %>
    </table>
</body>
</html>
