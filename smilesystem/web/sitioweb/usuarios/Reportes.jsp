<html>
    <head>
        <%@page import="Dtos.UsuariosDTO"%>
        <%@page import="Daos.UsuarioDAO"%>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <title>Smile System</title>
        <meta charset="utf-8" />
        <link rel="shortcut icon" href="../imagenes/favicon.ico" />
        <link href="../css/footer.css" rel="stylesheet" type="text/css">
        <link href="../css/css.css" rel="stylesheet" type="text/css">
        <script src="../js/jquery.js"></script>
        <script src="../js/jquery.validate.js"></script>
        <script src="../css/bootstrap.css"></script>
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css">        
        <link href="../css/bootstrap-responsive.css" rel="stylesheet" type="text/css">
        <link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Roboto+Slab' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Bree+Serif' rel='stylesheet' type='text/css'>
        <script type="text/javascript">

            $(document).ready(function () {

                // sirve para bloquear los campos input
                $('.bloqueado').attr('disabled', 'disabled');

                //sirve para desbloquear los campos input y ocultar el boton actualizar
                $('#actualizar').click(function () {
                    $('.bloqueado').removeAttr('disabled');
                    $('#actualizar').hide();
                    $('#guardar').show();
                });

                // sirver para validar los campos del formulario
                $('#form1').validate({
                    rules: {
                        Documento: {
                            required: true,
                            number: true,
                            minlength: 8,
                            maxlength: 10
                        }
                    },
                    messages: {
                        Documento: {
                            required: "Este campo es Requerido",
                            number: "El campo debe ser Numérico ",
                            minlength: "Son {0} digitos Mínimo  ",
                            maxlength: "Son {0} digitos Máximo"
                        }
                    },
                });
            });
        </script>
        <%
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setDateHeader("Expires", 0);
        %>
    </head>
    <body>
        <%
            HttpSession miSesion = request.getSession(false);
            if (miSesion.getAttribute("usr") != null) {
                UsuariosDTO uregistrado = (UsuariosDTO) miSesion.getAttribute("usr");
                String menu = (String) miSesion.getAttribute("mp");

        %>

        <div class="logo">        
            <img src="../imagenes/banner-enviar.jpg" height="160" width="1200">
        </div>
        <div class="menu">
            <div class="tags">
                <a href="iniciarsesion.jsp"><strong>Iniciar Sesión</strong></a>
                <a href="#"><strong>Citas Paciente</strong></a>
            </div>
            <div class ="menu-session">     
                <button type="button" onClick="javascript:window.location = '../indexout.jsp'">Cerrar Sesión </button>
            </div>
            <div class ="menu-session">
                <span style="color: white;"> <%  out.print(uregistrado.getRol());%>  </span>
                <span style="color: white;"><%  out.print(uregistrado.getNombres());%>  <%  out.print(uregistrado.getApellidos());%></span>                  
            </div>
        </div>
        <div class="contenido">
            	
            <div class="menu2"> 
                <div class="menucoreer"> <img class="vector" src="../imagenes/manu.png " width="70"	height="70"></div>
                    <% out.println(menu); %> 
            </div>
            <div class="mesa">
                <div class="lado3">
                  
                </div>                            
                <div class="lado4">

                </div>



            </div>
        </div>     

        <%     } else {
                response.sendRedirect("../index.jsp");
            }

        %>

    </body>
</html>