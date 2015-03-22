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
                    <h1>Programar Citas</h1>
                    <form class="form-horizontal" name="form1" id="form1" action="../../UsuarioServlet">
                        <table>
                            <tr>
                                <td><label for="cedula" class="  col-lg-2 control-label">Documento:</label></td>
                                <td>
                                    <div class="form-group">

                                        <div class="col-lg-10">
                                            <input type="text" value="" name="cedula" required class="lettersonly form-control" id="cedula" placeholder="********">
                                        </div>
                                    </div>
                                </td>
                            </tr>  
                            <tr>
                                <td><label for="fechacita" class=" InputRequired col-lg-2 control-label">Fecha Cita:</label></td> 
                                <td><div class="form-group">

                                        <div class="col-lg-10">
                                            <input type="date" class="form-control " required id="fechacita" value="" name="fechacita" placeholder="">
                                        </div>
                                    </div></td>
                            </tr>
                            <tr>
                                <td><label for="turno" class=" InputRequired col-lg-2 control-label">Hora:</label></td> 
                                <td><div class="form-group">

                                        <div class="col-lg-10">
                                            <select  for="turno" name="turno" id="turno" required class="  form-control">
                                                <option value="1">09:00am </option>
                                                <option value="2">09:30am </option>
                                                <option value="3">10:00am</option>
                                                <option value="4">10:30am </option>
                                                <option value="5">11:00am </option>
                                                <option value="6">11:30am</option>
                                                <option value="7">12:00pm </option>
                                                <option value="8">12:30pm </option>
                                                <option value="9">01:00pm</option>
                                                <option value="10">01:30pm </option>
                                                <option value="11">02:00pm </option>
                                                <option value="12">02:30pm</option>
                                                <option value="13">03:00pm</option>
                                                <option value="14">03:30pm </option>
                                                <option value="15">04:00pm </option>
                                                <option value="16">04:30pm</option>
                                                <option value="17">05:00pm</option>

                                            </select>

                                        </div>
                                    </div></td> 
                            </tr>
                            <tr>
                                <td><label for="Especialidad" class=" InputRequired col-lg-2 control-label">Procedimientos:</label></td> 
                                <td><div class="form-group">

                                        <div class="col-lg-10">
                                            <select  for="Especialidad" name="Especialidad" id="Especialidad" required class="  form-control">
                                                <option value="1">Odontología</option>
                                                <option value="2">Periodoncia </option>
                                                <option value="3" selected>Endodoncia </option>
                                                <option value="4">Odontopediatría  </option>    
                                                <option value="5">Ortodoncia </option>
                                                <option value="6">Odontogeriatría </option>
                                                <option value="7">Cirugía maxilofacial  </option>
                                            </select>
                                        </div>
                                    </div></td> 
                            </tr>
                        </table> 
                        <input type="submit" name="citar2" class="botones" value="Asignar">
                    </form>
                </div>                            
                <div class="lado4">

                    <img src="../imagenes/imagenes.png" width="450" height="450" class="dibu">                
                </div>



            </div>
        </div>     

        <%     } else {
                response.sendRedirect("../index.jsp");
            }

        %>

    </body>
</html>