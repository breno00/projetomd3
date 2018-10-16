<%-- 
    Document   : saudacao
    Created on : 18/09/2018, 21:13:56
    Author     : 42115152016.1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Obrigado</title>
    </head>
    <body>
        
        <h1>Ola, <%= request.getAttribute("individuo") %> </h1>
        <h1>idade, <%= request.getAttribute("ida") %> </h1>
        <h1>opiniao, <%= request.getAttribute("opi") %> </h1>
        <h1>Muito obrigado por responder a nossa pesquisa!</h1>
        
        <a href="index.html">Voltar ao Inicio</a>
        
    </body>
</html>
