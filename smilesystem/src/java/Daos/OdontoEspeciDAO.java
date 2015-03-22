/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;


import Dtos.OdontoEspecDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Conexion.Conexion;


/**
 *
 * @author Administrador
 */
public class OdontoEspeciDAO {
  PreparedStatement pstmt = null;
    Connection cnn = Conexion.getInstance();
    int rtdo;
    ResultSet rs = null; 
    
     public  OdontoEspeciDAO (){
         cnn = Conexion.getInstance(); 
          
      }
      
      String mensaje = "";
      
     
    public List< OdontoEspecDTO> listarTodos() {
        ArrayList< OdontoEspecDTO> OdontoEspec = new ArrayList<>();
        try {
            String sqlAll = "SELECT  idOdontologo,idEspecializacion FROM odontoespec where 1=1";                
            
            pstmt = cnn.prepareStatement(sqlAll);
            rs = pstmt.executeQuery();
            
            if (rs != null) {
                while (rs.next()) {
                    OdontoEspec.add( new OdontoEspecDTO(rs.getInt("idOdontologo"), rs.getInt("idEspecializacion")));
                }
            }
        } catch (SQLException ex) {
            mensaje = "Error, datelle " + ex.getMessage();
        }
        
        return OdontoEspec;
    }

    
    public String crearRolOdontoEspec(OdontoEspecDTO odto) {
        try {
            String sqlInsert = "INSERT INTO odontoespec(idOdontologo,idEspecializacion) VALUES(?, ?)";
            
            pstmt = cnn.prepareStatement(sqlInsert);
            pstmt.setInt(1, odto.getIdOdontologo());
            pstmt.setInt(2, odto.getIdEspecializacion());
          
           
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

   
    public OdontoEspecDTO obtenerUno(int idusu, int idrol) {
        
        OdontoEspecDTO odto = null;
        String sqlOne = "SELECT  idOdontologo, idEspecializacion FROM odontoespec WHERE idOdontologo = ? AND idEspecializacion=? ";
        try {
            pstmt =cnn.prepareStatement(sqlOne);
            pstmt.setInt(1, idusu);
            pstmt.setInt(1, idrol);
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    
                    odto = new OdontoEspecDTO(); 
                    odto.setIdOdontologo(rs.getInt("idOdontologo"));
                    odto.setIdEspecializacion(rs.getInt("idEspecializacion"));
                }
            }
        } catch (SQLException sqle) {
            mensaje = "Error, detalle " + sqle.getMessage();
        }

        return odto;
    } 

    
    public String modificarOdontoEspec(OdontoEspecDTO odto) {
        try {
            String sqlUpdate = "UPDATE  odontoespec SET  idEspecializacion = ?  AND idOdontologo WHERE idOdontologo = ? AND idEspecializacion=?";
            pstmt = cnn.prepareStatement(sqlUpdate);            
            pstmt.setInt(1, odto.getIdOdontologo());
            pstmt.setInt(2, odto.getIdOdontologo());
            
            

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
      
    public String eliminarOdontoEspec(OdontoEspecDTO odto) {
        try {
            String sqlDelete = "DELETE FROM `smilesystemv2`.`odontoespec` WHERE `odontoespec`.`idOdontologo` = ? AND `odontoespec`.`idEspecializacion` = ? ";

            pstmt = cnn.prepareStatement(sqlDelete);
            pstmt.setInt(1, odto.getIdOdontologo());
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
