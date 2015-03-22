/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Conexion.Conexion;
import Dtos.usuarioperfilesDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class usuarioperfilesDAO {
  PreparedStatement pstmt = null;
    Connection cnn = Conexion.getInstance();
    int rtdo;
    ResultSet rs = null; 
    
     public usuarioperfilesDAO (){
      cnn = Conexion.getInstance();     
      }
      
      String mensaje = "";
      
     
    public List<usuarioperfilesDTO> listarTodos() {
        ArrayList<usuarioperfilesDTO> usuario = new ArrayList<>();
        try {
            String sqlAll = "SELECT  usuarioid,perfilid, estado FROM usuariosperfiles where 1=1";                
            
            pstmt = cnn.prepareStatement(sqlAll);
            rs = pstmt.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    usuario.add( new usuarioperfilesDTO(rs.getLong("usuarioid"), rs.getInt("perfilid"),rs.getInt("estado")));
                }
            }
        } catch (SQLException ex) {
            mensaje = "Error, datelle " + ex.getMessage();
        }
        
        return usuario;
    }

    
    public String crearUsuarioDocumento(usuarioperfilesDTO odto) {
        try {
            String sqlInsert = "INSERT INTO usuariosperfiles VALUES(?, ?,?)";
            
            pstmt = cnn.prepareStatement(sqlInsert);
            pstmt.setLong(1, odto.getUsuarioperfiles());
            pstmt.setInt(2, odto.getPerfilid());
             pstmt.setInt(3, odto.getEstado());
          
           
             rtdo = pstmt.executeUpdate();
            if (rtdo != 0) {
                mensaje = "Registro éxitoso";
            } else {
                mensaje = "No se pudo realizar la insert";
            }

        } catch (SQLException sqle) {
            mensaje =" "+sqle.getMessage()+" - error: "+sqle.getSQLState()+" ";
        }catch(NullPointerException  np){
            mensaje = "no se encuentra:  "+np+ "  "+np.getLocalizedMessage();
        }
        
        return mensaje;
    }

   
    public usuarioperfilesDTO obtenerUno(int idusu, int idrol) {
        
        usuarioperfilesDTO odto = null;
        String sqlOne = "SELECT usuarioid, perfilid, estado FROM usuariosperfiles WHERE usuarioid = ? AND perfilid=? ";
        try {
            pstmt =cnn.prepareStatement(sqlOne);
            pstmt.setInt(1, idusu);
            pstmt.setInt(2, idrol);
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    
                    odto = new usuarioperfilesDTO(); 
                    odto.setUsuarioperfiles(rs.getLong("usuarioid"));
                    odto.setPerfilid(rs.getInt("perfilid"));
                }
            }
        } catch (SQLException sqle) {
            mensaje = "Error, detalle " + sqle.getMessage();
        }

        return odto;
    } 

    
    public String modificarUsuarioDocumento(usuarioperfilesDTO odto) {
        try {
            String sqlUpdate = "UPDATE  usuariosperfiles SET  estado = ? WHERE usuarioid = ? AND perfilid=? ";
            pstmt = cnn.prepareStatement(sqlUpdate);            
            pstmt.setLong(1, odto.getUsuarioperfiles());
            pstmt.setInt(2, odto.getPerfilid());
            
            

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
      
    public String eliminarUsuarioDocumento(usuarioperfilesDTO odto) {
        try {
            String sqlDelete = "DELETE FROM `smilesystemv2`.`usuariosperfiles` WHERE `usuarioDocumento`.`usuarioid` = ? AND `usuarioDocumento`.`perfilid` = ? ";

            pstmt = cnn.prepareStatement(sqlDelete);
            pstmt.setLong(1, odto.getUsuarioperfiles());
            pstmt.setInt(2, odto.getPerfilid());
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

  

 

}
