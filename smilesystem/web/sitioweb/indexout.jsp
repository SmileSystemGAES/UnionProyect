<%-- 
    Document   : indexout
    Created on : 2/02/2015, 10:06:46 AM
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cerrar Sesión</title>
    </head>
    <body>
        <h1>Salir</h1>

        <%
         
            HttpSession miSesion = request.getSession(false);
            
            if (miSesion.getAttribute("usr") == null  ) {
                response.sendRedirect("index.jsp");

            
        }else{
                miSesion.invalidate();
                 response.sendRedirect("index.jsp");
            }    
                   
       
        %>    



    </body>
</html>
