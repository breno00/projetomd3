<%-- 
    Document   : resultado
    Created on : 20/09/2018, 21:25:50
    Author     : 42115152016.1
--%>

<%@page import="pacotecinema.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>AmoFilmes - Resultados</title>
    </head>
    <body>
        <h1>Resultado da Pesquisa</h1>
        
        <%
            List<Pessoa> lista = (List<Pessoa>)request.getAttribute("info");
            
            int numeroOtimo = 0;
            int somaOtimo = 0;
            int numeroRegular = 0;
            
            
            for (Pessoa p : lista) {
                
                if (p.getOpiniao()== 4) {
                numeroOtimo ++;
                somaOtimo += p.getIdade();
                // numeroOtimo += 1;
                // numeroOtimo = numeroOtimo +1;
                }
            
            
                if (p.getOpiniao()== 2) {
                    numeroRegular ++;
                }
                
            }
                double media = 0;
                
                try {
                    media = somaOtimo / numeroOtimo;
                } catch (Exception o) {
                }
                    
                    
            
        %>    
           
                <h2>
            Média das idades que responderam ótimo: <%= media %>
        </h2>    
        
        <h2>
            Número de pessoas que responderam regular: <%= numeroRegular %>
         </h2>
         
         <h2>
             Total de pessoas: <%= lista.size() %>
         </h2>

    </body>
</html>