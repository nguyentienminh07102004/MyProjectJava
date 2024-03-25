<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
    </head>

    <body>
        <form action="game" method="GET">
            <label>
                number guessing game</label><br>
                <% String hadValue = "";
                    if(session.getAttribute("hadValue") != null){
                        hadValue = (String)session.getAttribute("hadValue");
                    }
                %>
            <label for="maxLength">Max length: </label><input type="number" id="maxLength" name="maxNumberLength" style="display: <%= hadValue %>"><br>
            <label for="number">Your number you choose is: </label><input type="number" name="number" id="number">
            <input type="submit" value="SUBMIT">
        </form>
        <% if(request.getAttribute("result") != null){ %>
        <h1>You must <%= (String)request.getAttribute("result") %>
        </h1>
        <%
                if(((String)request.getAttribute("result")).equals("Accpect")){
                   session.invalidate();
                   response.sendRedirect("gameDoanSo");
                }
            }
        %>
    </body>

</html>