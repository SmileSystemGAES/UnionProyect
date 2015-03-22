

<%@page import="Dtos.UsuariosDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>

        <title>Smile System</title>
        <meta charset="utf-8" />
        <link rel="shortcut icon" href="../imagenes/favicon.ico" />
        <link href="../css/footer.css" rel="stylesheet" type="text/css">
        <link href="../css/css.css" rel="stylesheet" type="text/css">
        <script src="../js/jquery.js"></script>
        <script src="../js/jquery.validate.js"></script>

        <link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Abril+Fatface' rel='stylesheet' type='text/css'>
         <link href='http://fonts.googleapis.com/css?family=Bree+Serif' rel='stylesheet' type='text/css'>
        <%
           response.setHeader("Cache-Control", "no-cache");
           response.setHeader("Cache-Control", "no-store");
           response.setDateHeader("Expires", 0);
        %>
    </head>
    <body> 

       <%
        HttpSession miSesion=request.getSession(false);
        if(miSesion.getAttribute("usr")!=null){
            UsuariosDTO uregistrado = (UsuariosDTO)miSesion.getAttribute("usr");
            String menu = (String)miSesion.getAttribute("mp");
        %>
        <div class="logo">

            <img src="../imagenes/banner-enviar.jpg" height="160" width="1200">
        </div>
        <div class="menu">
            <div class ="menu-session">     
                <button type="button" onClick="javascript:window.location = '../indexout.jsp'">Cerrar Sesión </button>
            </div>
            <div class ="menu-session">
                <span style="color:white;">  <%  out.print(uregistrado.getRol());%>:  </span>
                <span style="color:white;"> <%  out.print(uregistrado.getNombres());%> <%  out.print(uregistrado.getApellidos());%></span>                  
            </div>
        </div>

        <div class="contenido">
            <div class="menu2"> 
            
                    <% out.println(menu); %> 
            </div>
            <div class="mesa">
                <div class="lado1"><h1>Bienvenidos</h1>
                    <p> Señor(a) usuario bienvenido y gracia por tomar nuestro servicios  en nuestra gran compaña de odontología, en este principio observara los principales novedades que le muestra nuestro  sistema para su amplia mejoría con el servicio, como pude usted observar podrá programar sus citas odontológicas, también  podrá revisar su historial médico.</p>
                </div>
                <div class="lado2">	       	
                    <img src="../imagenes/imagen.png" width="442" height="380" class="dibujo"> 
                </div>          


            </div> 
        </div>     


      <%  }else{
           response.sendRedirect("../index.jsp");
        }  %> 
    </body>
</html>

