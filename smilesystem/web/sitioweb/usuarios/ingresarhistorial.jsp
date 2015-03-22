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
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css">        
        <link href="../css/bootstrap-responsive.css" rel="stylesheet" type="text/css">
        <script src="../js/jquery.js"></script>
        <script src="../js/jquery.validate.js"></script>
        <link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Roboto+Slab' rel='stylesheet' type='text/css'>
         <link href='http://fonts.googleapis.com/css?family=Bree+Serif' rel='stylesheet' type='text/css'>
        <script type="text/javascript">

            $(document).ready(function () {

                //codigo para validar que los campos solo sean letras
                jQuery.validator.addMethod("lettersonly", function (value, element) {
                    return this.optional(element) || /^[a-zA-ZÃ¡Ã©Ã­Ã³ÃºÃ Ã¨Ã¬Ã²Ã¹ÃÃÃÃÃÃÃÃÃÃÃ±ÃÃ¼Ã_\s]+$/i.test(value);
                }, "Digite solo caracteres");

                // sirver para validar los campos del formulario
                $('#form1').validate({
                    rules: {
                        password: {
                            required: true,
                            number: true,
                            minlength: 8,
                            maxlength: 10
                        }
                    },
                    messages: {
                        password: {
                            required: "Este campo es Requerido",
                            number: "El campo debe ser Numérico ",
                            minlength: "Son {0} digitos Mínimo  ",
                            maxlength: "Son {0} digitos Máximo"
                        }
                    }
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
                <a href="#"><strong>Ingresar Historial</strong></a>
            </div>
            <div class ="menu-session">          
                <button type="button" onClick="javascript:window.location = '../indexout.jsp'">Cerrar Sesión </button>
            </div>
            <div class ="menu-session">
                <span style="color: white;">  <%  out.print(uregistrado.getRol());%>  -</span>
                <span style="color: white;"><%  out.print(uregistrado.getNombres());%> <%  out.print(uregistrado.getApellidos());%> </span>                  
            </div>
        </div>
        <div class="contenido">
            
              <div class="menu2">  
                  <div class="menucoreer"> <img class="vector" src="../imagenes/manu.png " width="70"	height="70"></div>
                   <% out.println(menu); %> 
              </div>
            
            <div class="mesa">
                <div class="lado1">
                    <div class="formulario-session form-gris">
                        <form action="historial.jsp" id="form1" class="form-format1" method="POST"> 
                            <h1 class="h1-session">Smile System</h1>    

                            <div class="formularrioodonto">
                                <label for ="password"> Documento</label>
                                <div class="corr">
                             
                                    <input type="password" name="password" id="password" required max-length="20" value=""  placeholder="1081407291"/>
                                </div>
                                </div>
                                
                            <input type="submit" value="Ingresar">
                        </form>
                    </div>
                </div>
                <div class="lado2">           
                    <img src="../imagenes/imagen.png" width="400" height="400" class="dibujo"> 
                </div>  
            </div>		           


        </div>     
 <%     }else{
           response.sendRedirect("../index.jsp");
        }

%>
   
    </body>
</html>
