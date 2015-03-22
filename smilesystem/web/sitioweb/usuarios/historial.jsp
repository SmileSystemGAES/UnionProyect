<html>
    <head>
        <%@page import="Dtos.UsuariosDTO"%>
        <%@page import="Daos.UsuarioDAO"%>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <title>Smile System</title>
        <meta charset="utf-8" />
        <link rel="shortcut icon" href="../imagenes/favicon.ico" />	
        <link rel="stylesheet" href="../js/jquery-ui-1.11.1/jquery-ui.css">
        <link href="../css/footer.css" rel="stylesheet" type="text/css">
        <link href="../css/css.css" rel="stylesheet" type="text/css">
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css">        
        <link href="../css/bootstrap-responsive.css" rel="stylesheet" type="text/css">
        <link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Pathway+Gothic+One' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=PT+Sans+Narrow' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Bree+Serif' rel='stylesheet' type='text/css'>
        <script src="../js/jquery.js"></script>
        <script src="../js/jquery.PrintArea.js"></script>
        <script src="../js/jquery-ui-1.11.1/jquery-ui.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {

                /*$(".printer").click(function(){
                 $('.Divprint').printArea();
                 });*/

                $("#dialog").dialog({
                    autoOpen: false,
                    width: 400,
                    height: 300,
                    close: function () {
                        $('input').prop('checked', false);
                    }
                });
            });

            function mostrar(indentidad) {

                if ($(".check-" + indentidad).is(':checked')) {

                    valor = $(".check-" + indentidad).val();
                    $("#dialog").html(valor);
                    $("#dialog").dialog("open");
                }
            }

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
                <a href="ingresarhistorial.jsp"><strong>Ingresar Historial</strong></a>
                <a href="#"><strong> Historial Paciente</strong></a>
            </div>  
            <div class ="menu-session"> 		   
                <button type="button" onClick="javascript:window.location = '../indexout.jsp'">Cerrar Sesión </button>
            </div>
            <div class ="menu-session">
                <span style="color: white;"> <%  out.print(uregistrado.getRol());%>:</span>
                <span style="color: white;"><%  out.print(uregistrado.getNombres());%> <%  out.print(uregistrado.getApellidos());%>  </span>                  
            </div>
        </div>
        <div class="contenido">
            <div class="menu2"> 
                <div class="menucoreer"> <img class="vector" src="../imagenes/manu.png " width="70"	height="70"></div>
                    <% out.println(menu); %> 
            </div>
            <div class="mesa mesa-overflow">
                <h1 class="h1-session">Historial Odontológico </h1>
                <h2>Carta Dental</h2>
                <div class="lado1" style="text-align: center;">

                </div>
                <div class="lado2">

                </div>
                <div class="mesa">
                    <div class ="nombre">
                        <span style="color: ">Paciente: </span> 
                        <span style="color: ">José  Fabián  López  Giraldo </span>                                  
                    </div>
                    <div class="Divprint">
                        <table class="Divprint">
                            <thead>
                                <tr>

                                    <td>No.Documento</td>								
                                    <td> Fecha Cita</td>
                                    <td> Hora</td>
                                    <td>Profesional</td>
                                    <td>Procedimiento</td>
                                    <td>Acciones</td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>							
                                    <td >1081407291 </td>								
                                    <td> 15/08/2014</td>
                                    <td> 9:00 am</td>
                                    <td> Alberto HernÃ¡ndez</td>
                                    <td> Exodencia</td>
                                    <td> AsistiÃ³ </td>	
                                </tr>
                                <tr>	                       
                                    <td >1081407291 </td>								
                                    <td> 27/09/2014</td>
                                    <td> 1:00 pm</td>
                                    <td> Alberto HernÃ¡ndez</td>
                                    <td> Endodoncias</td>
                                    <td> AsistiÃ³ </td>	
                                </tr>
                                <tr>
                                    <td >1081407291 </td>								
                                    <td> 1/10/2014</td>
                                    <td> 3:00 pm</td>
                                    <td> Alberto HernÃ¡ndez</td>
                                    <td> Exodencia</td>
                                    <td> AsistiÃ³ </td>										
                                </tr>
                                <tr>
                                    <td >1081407291 </td>								
                                    <td> 1/11/2014</td>
                                    <td> 8:00 am</td>
                                    <td> Alberto HernÃ¡ndez</td>
                                    <td> Exodencia</td>
                                    <td> AsistiÃ³ </td>										
                                </tr>
                                <tr>
                                    <td >1081407291 </td>								
                                    <td> 25/11/2014</td>
                                    <td> 1:00 pm</td>
                                    <td> Alberto HernÃ¡ndez</td>
                                    <td> Exodencia</td>
                                    <td> AsistiÃ³ </td>	

                                </tr>
                                <tr>
                                    <td >1081407291 </td>								
                                    <td> 1/12/2014</td>
                                    <td> 10:00 am</td>
                                    <td> Alberto HernÃ¡ndez</td>
                                    <td> Exodencia</td>
                                    <td> AsistiÃ³ </td>									
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <a href="pdf/medico.pdf" target="_blank"> <button  class="printer" type="button">Descargar</button> </a>
                </div>            
            </div> 
        </div>
        <div id="dialog" title="Odontolgia" style="display:none">
        </div>  
        <%     } else {
                response.sendRedirect("../index.jsp");
            }

        %>

    </body>
</html>