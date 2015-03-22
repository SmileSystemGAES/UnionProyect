
<html>
    <head>
        <title>Smile System</title>
        <%@page import="Daos.menuDAO"%>
        <%@page errorPage="error404.jsp" %>        
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <link rel="shortcut icon" href="imagenes/favicon.ico" />
        <link href="css/footer.css" rel="stylesheet" type="text/css">
        <link href="css/css_1.css" rel="stylesheet" type="text/css">
        
        <script src="js/jquery.js"></script>
        <script src="js/jquery.validate.js"></script>
        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">
        <link rel="stylesheet" type="text/css" href="css/estiloi.css">
        <script type="text/javascript" src="js/bootstrap-carousel.js"></script>


        <script type="text/javascript">

            function OcultarForm(parm1, parm2) {
                $('#' + parm2).show();
                $('#' + parm1).hide();
            }
            $(document).ready(function () {
                //codigo para validar que los campos solo sean letras
                jQuery.validator.addMethod("lettersonly", function (value, element) {
                    return this.optional(element) || /^[a-zA-ZáéíóúàèìòùÀÈÌÒÙÁÉÍÓÚñÑüÜ_\s]+$/i.test(value);
                }, "Solo puedes ingresar letras");

                // sirver para validar los campos del formulario
                $('#form1').validate({
                    rules: {
                        pass: {
                            required: true,
                            number: true,
                            minlength: 9,
                            maxlength: 11
                        },
                        user: {
                            required: true,
                            minlength: 5,
                            maxlength: 15

                        }

                    },
                    messages: {
                        pass: {
                            required: "El campo es Requerido",
                            number: "El campo debe ser Numérico ",
                            minlength: "Son {0} digitos Mínimo  ",
                            maxlength: "Son {0} digitos Máximo"
                        },
                        user: {
                            required: "El campo es Requerido",
                            minlength: "Son {0} digitos Mínimo  ",
                            maxlength: "Son {0} digitos Máximo"

                        }
                    }
                });


                $('#form2').validate({
                    rules: {
                        correo: {
                            required: true,
                            email: true
                        }

                    },
                    messages: {
                        correo: {
                            required: "El campo es requerido",
                            email: "El Correo es invalido"
                        }
                    },
                    submitHandler: function (form) {
                        alert('Su contraseña fue enviada a este  correo');
                        OcultarForm('Recuperar', 'Formlogin');
                    }
                });

            });
        </script>



    </head>

    <body>
        <div class="logo">

            <img src="imagenes/banner-enviar.jpg" height="160" width="1200">
        </div>

        <div class="menu">
            <ul>
                <li><a href="inicio.jsp"><img src="imagenes/home.png" class="imagen" width="100%" height="210" alt="logo"/>Inicio</a></li>
                <li><a href="quienessomos.jsp">Contáctenos</a></li>
                <li><a href="servicios.jsp"> Servicios</a></li>                   
                <li><a href="index.jsp">Afiliados</a></li>
                <li><a href="preguntas.jsp">Inquietudes</a></li>
            </ul>

        </div>
        <div class="contenido">
            <div class="lado3">
                <div class="row">
                    <div class="span9 columns">
                        <div id="myCarousel" class="carousel slide" style="width:500px;">
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img src="imagenes/imagen4.jpg" height="500"  width="500" alt="">
                                    <div class="carousel-caption">
                                        <h4>Bienvenido Señor usuario.</h4>
                                        <p></p>
                                    </div>
                                </div>
                                <div class="item">
                                    <img src="imagenes/imagen1.jpg"  height="500"  width="500" alt="">
                                    <div class="carousel-caption">
                                        <h4>Bienvenido Señor usuario.</h4>
                                        <p></p>
                                    </div>
                                </div>
                                <div class="item">
                                    <img src="imagenes/imagen2.jpg" height="500"  width="500"  alt="">
                                    <div class="carousel-caption">
                                        <h4>Bienvenido Señor usuario.</h4>
                                        <p></p>
                                    </div>
                                </div>
                            </div>
                            <!-- Carousel nav -->
                            <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
                            <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
                        </div>
                    </div>
                </div>     
            </div>
            <div class="lado4">
                <div class="formulario-session" id="Formlogin">						
                    <form name="frmUsuario" action="../UsuarioServlet" id="form1" class="formlogin" method="POST">


                        <h1 class="h1-session">Iniciar Sesión</h1>

                        <div class="formularrioodonto">
                            <label for ="user">Usuario</label>
                            <input type="text" class="mover lettersonly "  id="user" required name="user" value=""  placeholder="jvargas"/>
                        </div>  

                        <div class="formularrioodonto">
                            <label for ="pass">Contraseña</label>
                            <input type="password" name="pass" id="pass" class="mover" required  value=""  placeholder="**********"/>
                        </div>
                        <div class="formularrioodonto">
                            <label  class="ayuda"><a onClick="OcultarForm('Formlogin', 'Recuperar');" href="#">Recordar Contraseña ?</a></label>
                        </div>
                        <input type="submit" name="btnIngresar" value="Ingresar">
                        <div class="style"><%if (request.getParameter("msg") != null) {
                                out.print(request.getParameter("msg"));
                            }%>  </div>
                    </form>
                </div>
                <!-- formulario recuperar contrasena-->
                <div class="formulario-session" style="display:none;" id="Recuperar">                       
                    <form class="formlogin" id="form2"> 
                        <h1 class="h1-session">Smile System</h1>                            
                        <div class="formularrioodonto">
                            <label for ="correo">E-mail</label>
                            <input type="text" name="correo" id="correo" class="mover" required max-length="20" tabindex="2" value=""  placeholder="m@correo.com"/>
                        </div>
                        <input type="submit" value="Enviar">
                      
                    </form>
                </div>

            </div>
        </div>

    </body>
</html>
