/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Daos.UsuarioDAO;
import Daos.menuDAO;
import Dtos.UsuariosDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USUARIO
 */
public class UsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("btnIngresar") != null && request.getParameter("btnIngresar").equals("Ingresar")) {
            String usr = request.getParameter("user");
            String psw = request.getParameter("pass");

            menuDAO menu = new menuDAO();
            UsuariosDTO datosUsuario = new UsuariosDTO();
            String menuAPintar = "";
            HashMap<UsuariosDTO, String> hs = new HashMap<UsuariosDTO, String>();
            hs = menu.validarUsuario(usr, psw);
            for (Map.Entry<UsuariosDTO, String> registro : hs.entrySet()) {
                datosUsuario = registro.getKey();
                menuAPintar = registro.getValue();
            }

            // out.print("documento " + datosUsuario.getDocumento());
            if (datosUsuario.getDocumento() != 0) {
                HttpSession miSesion = request.getSession(true);
                miSesion.setAttribute("usr", datosUsuario);
                miSesion.setAttribute("mp", menuAPintar);
                response.sendRedirect("sitioweb/usuarios/iniciarsesion.jsp");

            } else {
                response.sendRedirect("sitioweb/index.jsp?msg=no existe");
            }
        } else if (request.getParameter("guardarUsuario") != null) {

            UsuariosDTO usnuevo = null;
            UsuarioDAO usnudao = new UsuarioDAO();
            try {

                usnuevo = new UsuariosDTO();
                usnuevo.setNombres(request.getParameter("NombreCompleto"));
                usnuevo.setApellidos(request.getParameter("ApellidoCompleto"));
                usnuevo.setTipoDoc(request.getParameter("tipodoc"));
                usnuevo.setDocumento(Long.parseLong(request.getParameter("Cedula")));
                usnuevo.setGrupoSangui(Integer.parseInt(request.getParameter("Gruposanguineo")));
                usnuevo.setTipoAlergia(Integer.parseInt(request.getParameter("TipoAlergia").trim()));
                usnuevo.setFechadenacimiento(request.getParameter("FechaNacimiento"));
                usnuevo.setLugardeNacimiento(request.getParameter("LugardeNacimiento"));
                usnuevo.setEmail(request.getParameter("email"));
                usnuevo.setTelefono(request.getParameter("Telefono"));
                usnuevo.setDireccion(request.getParameter("Direccion"));
                usnuevo.setCiudad(request.getParameter("Ciudad"));
                usnuevo.setGenero(request.getParameter("Sexo"));

                String mensa = usnudao.crearUsuario(usnuevo);

                response.sendRedirect("sitioweb/usuarios/registro.jsp?msg= Usuario Registrado" + mensa);
            } catch (IOException ex) {
                response.sendRedirect("sitioweb/sitioes/paciente/error");
            }

        }else if(request.getParameter("btnActualizarusu") != null) {
                UsuarioDAO usuarDao = new UsuarioDAO();
                
                boolean salida = usuarDao.modfificarUsuario(Integer.parseInt(request.getParameter("Cedula")), request.getParameter("NombreCompleto"));
                if(salida == true){
                    
                    response.sendRedirect("sitioweb/usuarios/perfil.jsp?sal=actualizado!!!!");
                }else{
                    response.sendRedirect("sitioweb/usuarios/perfil.jsp?sal= fallo al actualizar");
                }
                
            } else {
            response.sendRedirect("sitioweb/index.jsp?msg=no puede ingresar");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
