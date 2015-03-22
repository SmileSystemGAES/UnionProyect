<%-- 
    Document   : registro
    Created on : 29/01/2015, 07:59:32 AM
    Author     : Administrador
--%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <%@page import="Dtos.UsuariosDTO"%>
        <%@page import="Daos.UsuarioDAO"%>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <title>Smile System</title>
        <meta charset="utf-8" />
        <link rel="shortcut icon" href="../imagenes/favicon.ico" />
        <link href="../css/footer.css" rel="stylesheet" type="text/css">
        <link href="../css/secre.css" rel="stylesheet" type="text/css">
        <script src="../js/jquery.js"></script>
        <script src="../js/jquery.validate.js"></script>
        <script src="../css/bootstrap.css"></script>
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css">        
        <link href="../css/bootstrap-responsive.css" rel="stylesheet" type="text/css">
        <link href='http://fonts.googleapis.com/css?family=Lobster' rel='stylesheet' type='text/css'>

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
                        NombreCompleto: {
                            required: true,
                            minlength: 5,
                            maxlength: 25
                        },
                        ApellidoCompleto: {
                            required: true,
                            minlength: 5,
                            maxlength: 25

                        },
                        Cedula: {
                            required: true,
                            number: true,
                            minlength: 9,
                            maxlength: 13
                        },
                        TipoAlergia: {
                            required: true,
                        },
                        FechaNacimiento: {
                            required: true,
                        },
                        Telefono: {
                            required: true,
                            number: true,
                            minlength: 9,
                            maxlength: 13
                        },
                        Direccion: {
                            required: true,
                            minlength: 5,
                            maxlength: 30
                        }
                    },
                    messages: {
                        NombreCompleto: {
                            required: "Este campo es Requerido",
                            minlength: "Son {0} digitos Mínimo  ",
                            maxlength: "Son {0} digitos Máximo"
                        },
                        ApellidoCompleto: {
                            required: "Este campo es Requerido",
                            minlength: "Son {0} digitos Mínimo  ",
                            maxlength: "Son {0} digitos Míximo"
                        },
                        TipoAlergia: {
                            required: "Este campo es Requerido",
                            minlength: "Son {0} digitos Mínimo  ",
                            maxlength: "Son {0} digitos Máximo"
                        },
                        Cedula: {
                            required: "Este campo es Requerido",
                            number: "El  campo debe ser Numérico ",
                            minlength: "Son {0} digitos Mínimo  ",
                            maxlength: "Son {0} digitos Máximo"
                        },
                        FechaNacimiento: {
                            required: "El campo es Requerido"

                        },
                        Telefono: {
                            required: "Este campo es Requerido",
                            number: "El campo debe ser Numérico ",
                            minlength: "Son {0} digitos Mínimo  ",
                            maxlength: "Son {0} digitos Máximo"
                        },
                        email: {
                            email: "Dirección de correo invalida"
                        },
                        Direccion: {
                            required: "Este campo es Requerido",
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
                <a href="#"><strong>Registrar Paciente</strong></a>
            </div>
            <div class ="menu-session">     
                <button type="button" onClick="javascript:window.location = '../indexout.jsp'">Cerrar Sesión </button>
            </div>
            <div class ="menu-session">
                <span style="color: white;"> <%  out.print(uregistrado.getRol());%>:</span>
                <span style="color: white;"><%  out.print(uregistrado.getNombres());%> <%  out.print(uregistrado.getApellidos());%> </span>                  
            </div>
        </div>
        <div class="contenido">
            <div class="menu2"> 
                <div class="menucoreer"> <img class="vector" src="../imagenes/manu.png " width="70"	height="70"></div>
                    <% out.println(menu); %> 
            </div>
            <div class="mesa">
                <h1>Datos de  Registros</h1>
                <form class="form-horizontal" name="form1" id="form1" action="../../UsuarioServlet">

                    <table>
                        <tr>
                        <td><label for="NombreCompleto" class="  col-lg-2 control-label">Nombres:</label></td>
                        <td>
                            <div class="form-group">

                                <div class="col-lg-10">
                                    <input type="text" value="" name="NombreCompleto" required class="lettersonly form-control" id="NombreCompleto" placeholder="Juan Manuel">
                                </div>
                            </div>
                        </td>
                        <td><label for="TipoAlergia" class="col-lg-2 control-label">T.Alergia:</label></td> 
                        <td><div class="form-group">

                                <div class="col-lg-10">
                                    <select  for="TipoAlergia" name="TipoAlergia" id="TipoAlergia" required class="  form-control">

                                        <option selected>  Seleccione Tipo</option>
                                        <option value="1">Ninguna</option>
                                        <option value="2">Polvo</option>
                                        <option value="3">Acetaminofem </option>
                                        <option value="4">Penisilina</option>
                                    </select>
                                </div>
                            </div></td>

                        </tr>  
                        <tr>
                        <td><label for="ApellidoCompleto" class=" col-lg-2 control-label">Apellidos:</label></td> 
                        <td><div class="form-group">

                                <div class="col-lg-10">
                                    <input type="text" class="form-control lettersonly" required id="ApellidoCompleto" value="" name="ApellidoCompleto" placeholder="lopez Vargas">


                                </div>
                            </div></td>
                        <td><label for="Gruposanguineo" class="col-lg-2 control-label">Rh:</label></td> 
                        <td><div class="form-group">

                                <div class="col-lg-10">
                                    <select  for="Gruposanguineo" name="Gruposanguineo" id="Gruposanguineo" required class="  form-control">
                                        <option selected> Seleccione Tipo</option>
                                        <option value="1">A+</option>
                                        <option value="2">A-</option>
                                        <option value="3">O+ </option>
                                        <option value="4">O-</option>
                                        <option value="5">B+</option>
                                        <option value="6">B-</option>
                                        <option value="7"> AB-</option>
                                        <option value="8">AB+</option>		
                                    </select>
                                </div>
                            </div></td>
                        </tr>
                        <tr>
                        <td><label for="tipodoc" class="col-lg-2 control-label">T.Documento:</label></td> 
                        <td><div class="form-group">

                                <div class="col-lg-10">
                                    <select  for="tipodoc" name="tipodoc" id="tipodoc" required value="" class="nobloqueado  form-control">
                                        <option selected> Seleccione Tipo</option>
                                        <option value="CC">Documento</option>
                                        <option value="TC">Tarjeta de Identidad</option>

                                    </select>
                                </div>
                            </div></td>
                        <td><label for="email" class="InputRequired col-lg-2 control-label">Correo:</label></td> 
                        <td><div class="form-group">

                                <div class="col-lg-10">
                                    <input type="text" class=" email form-control" id="" name="email" required value=""  placeholder="jua.niton@hotmail.com">
                                </div>
                            </div></td>
                        </tr>
                        <tr>
                        <td><label for="Cedula" class="col-lg-2 control-label">Documento:</label></td> 
                        <td><div class="form-group">

                                <div class="col-lg-10">
                                    <input type="text" class="  form-control" required id="ejemplo_email_3" value="" name="Cedula" placeholder="**********"  >
                                </div>
                            </div></td>
                        <td><label for="Telefono" class="InputRequired col-lg-2 control-label">Teléfono</label></td> 
                        <td><div class="form-group">

                                <div class="col-lg-10">
                                    <input type="text" class=" form-control bloqueado" required name="Telefono" value=""  id="" placeholder="3132010029">
                                </div>
                            </div></td>
                        </tr>
                        <tr>
                        <td><label for="FechaNacimiento" class="col-lg-2 control-label">F.Nacimiento:</label></td> 
                        <td><div class="form-group">

                                <div class="col-lg-10">
                                    <input type="date" class=" form-control" required id="ejemplo_email_3" value="" name="FechaNacimiento">
                                </div>
                            </div></td>
                        <td><label for="Direccion" class=" InputRequired col-lg-2 control-label" >Direccion</label></td> 
                        <td><div class="form-group">

                                <div class="col-lg-10">
                                    <input type="text" class=" " id="" name="Direccion" required value=""  placeholder="calle 123 No 54-65" >
                                </div>
                            </div></td>
                        </tr>
                        <tr>
                        <td><label for="LugardeNacimiento" class="col-lg-2 control-label">L.Nacimiento:</label></td> 
                        <td><div class="form-group">

                                <div class="col-lg-10">
                                    <select  for="LugardeNacimiento" name="LugardeNacimiento" id="tipodoc" required class="   form-control">
                                        <option selected> Seleccione Tipo</option>
                                        <option value="Bogota">Bogotá</option>
                                        <option value="Barranquilla">Barranquilla</option>
                                        <option value="Cali">Cali</option>
                                        <option value="Cartagena">Cartagena</option>
                                        <option value="Ibague">Ibagué</option>
                                        <option value="Medellin"> Medellín </option>
                                        <option value="Neiva">Neiva</option>  
                                        <option value="Pereira"> Pereira </option>
                                        <option value="Pasto"> Pasto </option>
                                        <option value="Tesalia">Tesalia</option> 
                                    </select>
                                </div>
                            </div></td>
                        <td><label for="Sexo" class="col-lg-2 control-label InputRequired">Genero:</label></td> 
                        <td><div class="form-group">

                                <div class="col-lg-10">
                                    <select  for="Sexo" name="Sexo" id="Sexo" required class="">
                                        <option> Seleccione Tipo</option>                                     
                                        <option value="F">Mujer</option>
                                        <option value="M">Hombre</option>
                                        <option value="O"> Otros </option>

                                    </select>
                                </div>
                            </div></td>
                        </tr>

                        <tr>
                        <td><label for="Ciudad" class="InputRequired col-lg-2 control-label">Ciudad:</label></td> 
                        <td><div class="form-group">

                                <div class="col-lg-10">
                                    <option></option>
                                    <select  for="Ciudad" name="Ciudad" id="Ciudad" required class="  form-control">


                                        <option selected> Seleccione Tipo</option>
                                        <option value="Bogota">Bogotá</option>
                                        <option value="Cali">Cali</option>
                                        <option value="Medellin"> Medellín </option>
                                        <option value="Neiva">Neiva</option>										
                                    </select>										
                                    </select>
                                </div>
                            </div></td>
                        <td></td> 
                        <td><div class="form-group">

                                <div class="col-lg-10">
                                </div>
                            </div></td>
                        </tr>


                    </table> 
                    <div class="style"><%if (request.getParameter("msg") != null) {
                                out.print(request.getParameter("msg"));
                            } %>  </div>
                    <div class="moverlo">  <input type="submit"   class="boton"  id="guardar" value="Guardar" name="guardarUsuario" /></div>



                </form>
            </div>	      


        </div>		                     
    </div>    
    <%     } else {
            response.sendRedirect("../index.jsp");
        }

    %>

</body>
</html>
