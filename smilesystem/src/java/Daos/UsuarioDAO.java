package Daos;

import Conexion.MyException;
import Dtos.UsuariosDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Conexion.Conexion;
import Conexion.MyException;
import java.sql.*;
import java.util.Random;

/**
 *
 * @author Administrador
 */
public class UsuarioDAO {

    Connection cnn = null;
    PreparedStatement pstmt = null;
    int rtdo;
    ResultSet rs = null;

    public UsuarioDAO() {
        cnn = Conexion.getInstance();
    }
    String mensaje = "";

 
 
    public List<UsuariosDTO> listarTodos() {
        ArrayList<UsuariosDTO> usuario = new ArrayList<UsuariosDTO>();
        try {
            String sqlAll = "SELECT   documento, tipoDoc,nombres, apellidos, direccion, fechadenacimiento,usuario, clave,genero, correo,lugarDeNacimiento, ciudad   FROM usuarios where 1=1";

            pstmt = cnn.prepareStatement(sqlAll);
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    //  usuario.add( new UsuariosDTO(rs.getLong("documento") ,rs.getString("tipoDoc"),rs.getString("nombres"), rs.getString("apellidos"), rs.getString("grupoSangui"), rs.getString("tipoAlergia"),rs.getString("fechadenacimiento"), rs.getString("lugarDeNacimiento"),rs.getString("correo"),rs.getString("telefono") ,rs.getString("direccion"), rs.getString("ciudad"), rs.getString("genero")));
                }
            }
        } catch (SQLException ex) {
            mensaje = "Error, datelle " + ex.getMessage();
        }

        return usuario;
    }

    public String crearUsuario(UsuariosDTO odto){
        // recibe usuario, retorna entero 1: exitoso, 2: fallo;
        
        try {
            
             String sqlInsert = "INSERT INTO usuarios VALUES(?,?,?,?,?,?,?,md5(?),?,?,?,?)";    
             String concat= "Update usuarios set usuario=concat( left("+odto.getNombres()+",2) , "+odto.getApellidos()+") where  documento="+odto.getDocumento()+" ";
             String sqlinsert2 = "INSERT INTO telefonos VALUES (?,?)";
             String sqlinsert3 = "INSERT INTO pacientes  VALUES (?,?,?)";
             String sqlinsert4 = "INSERT INTO pacienteAlergias  VALUES (?,?)";
             String sqlinsert5="INSERT INTO usuariosperfiles VALUES(?,?,?)";
            int  estado=1;
            String usuariosss="jvargas";
            long numero = (long) (Math.random() * 100000000 + 1);
            pstmt = cnn.prepareStatement(sqlInsert);
            pstmt.setLong(1, odto.getDocumento());
            pstmt.setString(2, odto.getTipoDoc());
            pstmt.setString(3, odto.getNombres());
            pstmt.setString(4, odto.getApellidos());
            pstmt.setString(5, odto.getDireccion());
            pstmt.setString(6, odto.getFechadenacimiento());
            pstmt.setString(7, usuariosss);
            pstmt.setLong(8, numero);
            pstmt.setString(9, odto.getGenero());
            pstmt.setString(10, odto.getEmail());
            pstmt.setString(11, odto.getLugardeNacimiento());
            pstmt.setString(12, odto.getCiudad());
            rtdo = pstmt.executeUpdate();
          
            if (rtdo != 0) {                
                pstmt = cnn.prepareStatement(sqlinsert2);
                pstmt.setString(1, odto.getTelefono());
                pstmt.setLong(2, odto.getDocumento());
                rtdo = pstmt.executeUpdate();
                if (rtdo != 0) {                    
                                       
                    pstmt = cnn.prepareStatement(sqlinsert3);
                    pstmt.setLong(1, odto.getDocumento());
                    pstmt.setInt(2, odto.getGrupoSangui());
                    pstmt.setString(3, null);
                    rtdo = pstmt.executeUpdate();

                    if (rtdo != 0) {                        
                        pstmt = cnn.prepareStatement(sqlinsert4);
                        pstmt.setLong(1, odto.getDocumento());
                        pstmt.setInt(2, odto.getTipoAlergia());
                        rtdo = pstmt.executeUpdate();
                    if(rtdo!=0){
                        int rol=1;
                        pstmt=cnn.prepareStatement(sqlinsert5);
                        pstmt.setLong(1, odto.getDocumento());
                        pstmt.setInt(2, rol);
                        pstmt.setInt (3, estado);
                        rtdo= pstmt.executeUpdate();
                    }
                    }

                }       
//                
//                if(rtdo != 0){
//                   mensaje = "";
//                    
//                }
            } else {
                mensaje = "No se pudo realizar la insert";
            }

        } catch (SQLException sqle) {
            mensaje = " " + sqle.getMessage() + " - error: " + sqle.getSQLState() + " ";
        } catch (NullPointerException np) {
            mensaje = "no se encuentra:  " + np + "  " + np.getLocalizedMessage();
        }

        return mensaje;
    }

    public UsuariosDTO obtenerUno(int id) {

        UsuariosDTO odto = new UsuariosDTO();

        try {
            String sqlOne = "SELECT  nombres, apellidos , tipoDoc, fechadenacimiento, lugarDeNacimiento, correo,direccion,  ciudad , genero,usuario, clave FROM usuarios WHERE documento = ?";
            pstmt = cnn.prepareStatement(sqlOne);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {                    
                    odto.setNombres("nombres");
                    odto.setApellidos("apellidos");
                    odto.setTipoDoc("tipoDoc");
                    odto.setFechadenacimiento("fechadenacimiento");
                    odto.setLugardeNacimiento("lugarDeNacimiento");
                    odto.setEmail("correo");
                    odto.setDireccion("direccion");
                    odto.setCiudad("ciudad");
                    odto.setGenero("genero");
                    odto.setUsuario("usuario");
                    odto.setClave(id);
                    odto.setDocumento(id);
                }
            }
        } catch (SQLException sqle) {
            mensaje = "Error, detalle " + sqle.getMessage();
        }

        return odto;
    }

    public String modificarUsuario(UsuariosDTO odto) {
        try {
            String sqlUpdate = "UPDATE  usuarios SET  nombres=?, apellidos=?, tipoDoc = ?,fechadenacimiento=?, lugarDeNacimiento=?, correo=?, direccion=?,ciudad=?, genero= ?,usuario=?, clave=? WHERE documento = ?";
            pstmt = cnn.prepareStatement(sqlUpdate);
            pstmt.setString(1, odto.getNombres());
            pstmt.setString(2, odto.getApellidos());
            pstmt.setString(3, odto.getTipoDoc());
            pstmt.setString(4, odto.getFechadenacimiento());
            pstmt.setString(5, odto.getLugardeNacimiento());
            pstmt.setString(6, odto.getEmail());
            pstmt.setString(7, odto.getDireccion());
            pstmt.setString(8, odto.getCiudad());
            pstmt.setString(9, odto.getGenero());
            pstmt.setString(10, odto.getUsuario());
            pstmt.setInt(11, odto.getClave());
            pstmt.setLong(12, odto.getDocumento());

            rtdo = pstmt.executeUpdate();
            if (rtdo != 0) {
                mensaje = "Actualización éxitosa";
            } else {
                mensaje = "No se pudo realizar la actualización";
            }
        } catch (SQLException sqle) {
            mensaje = sqle.getMessage();
        }
        return mensaje;
    }

    public String eliminarUsuario(UsuariosDTO odto) {
        try {
            String sqlDelete = "DELETE FROM `smilesystemv2`.`usuarios` WHERE `usuarios`.`documento` = ?";

            pstmt = cnn.prepareStatement(sqlDelete);
            pstmt.setLong(1, odto.getDocumento());
            rtdo = pstmt.executeUpdate();
            if (rtdo != 0) {
                mensaje = "Se elimino correctamente";
            } else {
                mensaje = "No se pudo realizar la eliminación";
            }
        } catch (SQLException ex) {
            mensaje = "Error, detalle: " + ex.getMessage();
        }
        return mensaje;

    }
    
public boolean modfificarUsuario(int id, String nombre){
        boolean salida = false;
        try {
            pstmt = cnn.prepareStatement("UPDATE  usuarios SET  nombres=?, apellidos=?, tipoDoc = ?,fechadenacimiento=?, lugarDeNacimiento=?, correo=?, direccion=?,ciudad=?, genero= ?,usuario=?, clave=? WHERE documento = ?");
            pstmt.setString(1, nombre);
            pstmt.setInt(2, id);
            int valor = 0;
                valor = pstmt.executeUpdate();
            if(valor != 0){
                salida = true;
            }else{
                salida = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return salida;
    }

    public UsuariosDTO consultarById(int id) {
        UsuariosDTO usuar = new UsuariosDTO();
        try {
            pstmt = cnn.prepareStatement("select nombres, apellidos , tipoDoc, fechadenacimiento,"
                    + " lugarDeNacimiento, correo, telefono,direccion,  ciudad , genero,usuario,"
                    + " clave from usuarios where documento = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                usuar.setDocumento(id);
                usuar.setNombres(rs.getString("nombres"));
                usuar.setApellidos(rs.getString("apellidos"));
                usuar.setTipoDoc(rs.getString("tipoDoc"));                
                usuar.setFechadenacimiento(rs.getString("fechadenacimiento"));
                usuar.setLugardeNacimiento(rs.getString("lugarDeNacimiento"));
                usuar.setEmail(rs.getString("correo"));                
                usuar.setDireccion(rs.getString("direccion"));
                usuar.setCiudad(rs.getString("ciudad"));
                usuar.setGenero(rs.getString("genero"));
                usuar.setUsuario(rs.getString("usuario"));
                usuar.setClave(rs.getInt("clave"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuar;
    }

//       public UsuariosDTO validarUs(String userName, int clave) {
//        UsuariosDTO us = null;
//        String rol = null;
//        String sql = "";
//        try {
//            sql = "select us.documento, us.nombres, us.apellidos,us.tipoDoc,us.direccion,us.fechadenacimiento,us.usuario,\n"
//                    + "                    us.clave,us.genero, us.correo,us.lugarDeNacimiento,us.ciudad, descripcion as rol, idTelefono,\n"
//                    + "                     idAlergia, idRh  \n"
//                    + "                     from usuarios as us \n"
//                    + "                     left join usuariodocumento on us.documento = usuariodocumento.idusuarioDocumento \n"
//                    + "		      left join roles on usuariodocumento.idRol= roles.idRoles \n"
//                    + "                     left join  telefonos on us.documento=telefonos.Documento\n"
//                    + "                     left join pacientes on  us.documento=pacientes.idPaciente\n"
//                    + "		      left join pacientealergias on  pacientes.idPaciente=pacientealergias.idPaciente\n"
//                    + "                     where us.usuario=? and us.clave=?";
//            pstmt = cnn.prepareStatement(sql);
//            pstmt.setString(1, userName);
//            pstmt.setInt(2, clave);
//            rs = pstmt.executeQuery();
//            if (rs != null) {
//                while (rs.next()) {          
//                    us = new UsuariosDTO();
//                    us.setDocumento(rs.getLong("documento"));
//                    us.setNombres(rs.getString("nombres"));
//                    us.setApellidos(rs.getString("apellidos"));
//                    us.setTipoDoc(rs.getString("tipoDoc"));
//                    us.setDireccion(rs.getString("direccion"));
//                    us.setFechadenacimiento(rs.getString("fechadenacimiento"));
//                    us.setUsuario(rs.getString("usuario"));
//                    us.setClave(rs.getInt("clave"));
//                    us.setGenero(rs.getString("genero"));
//                    us.setEmail(rs.getString("correo"));
//                    us.setLugardeNacimiento(rs.getString("lugarDeNacimiento"));
//                    us.setCiudad(rs.getString("ciudad"));
//                    us.setRol(rs.getString("rol"));
//                    us.setGrupoSangui(rs.getInt("idRh"));
//                    us.setTipoAlergia(rs.getInt("idAlergia"));
//                    us.setTelefono(rs.getString("idTelefono"));
//                }
//
//            }
//
//        } catch (SQLException sqle) {
//            mensaje = " " + sqle.getMessage() + " - error: " + sqle.getSQLState() + " ";
//        } catch (NullPointerException np) {
//            mensaje = "no se encuentra:  " + np + "  " + np.getLocalizedMessage();
//        }
//        //us.setDireccion(mensaje);
//
//        return us;
//
//    }

}
