/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Conexion.Conexion;
import Dtos.perfilesDTO;
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
public class perfilesDAO {

    PreparedStatement pstmt = null;
    Connection cnn = null;
    int rtdo;
    ResultSet rs = null;

    public perfilesDAO() {
        cnn = Conexion.getInstance();
    }

    String mensaje = "";

    public List<perfilesDTO> listarTodos() {
        ArrayList<perfilesDTO> perfiles = new ArrayList<>();
        try {
            String sqlAll = "SELECT idperfil, descripcion, estado FROM perfiles where 1=1";

            pstmt = cnn.prepareStatement(sqlAll);
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    perfiles.add(new perfilesDTO(rs.getInt("idperfil"), rs.getString("descripcion"), rs.getInt("estado")));
                }
            }
        } catch (SQLException ex) {
            mensaje = "Error, datelle " + ex.getMessage();
        }

        return perfiles;
    }

    public String crearRoles(perfilesDTO odto) {
        try {
            String sqlInsert = "INSERT INTO perfiles VALUES(?, ?,?)";

            pstmt = cnn.prepareStatement(sqlInsert);
            pstmt.setInt(1, odto.getIdperfil());
            pstmt.setString(2, odto.getDescripcion());
            pstmt.setInt(3, odto.getEstado());

            rtdo = pstmt.executeUpdate();
            if (rtdo != 0) {
                mensaje = "Registro éxitoso";
            } else {
                mensaje = "No se pudo realizar la insert";
            }

        } catch (SQLException sqle) {
            mensaje = sqle.getMessage();
        }
        return mensaje;
    }

    public perfilesDTO obtenerUno(int id) {
        perfilesDTO odto = null;

        String sqlOne = "SELECT  descripcion, estado FROM perfiles WHERE `idperfil` = ?";
        try {
            pstmt = cnn.prepareStatement(sqlOne);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    odto = new perfilesDTO(id, rs.getString("descripcion"), rs.getInt("estado"));

                }
            }
        } catch (SQLException sqle) {
            mensaje = "Error, detalle " + sqle.getMessage();
        }

        return odto;
    }

    public String modificarRoles(perfilesDTO odto) {
        try {
            String sqlUpdate = "UPDATE  perfiles SET  descripcion = ?, estado=? WHERE idperfiles=?";
            ;
            pstmt = cnn.prepareStatement(sqlUpdate);
            pstmt.setString(1, odto.getDescripcion());
            pstmt.setInt(1, odto.getEstado());
            pstmt.setInt(2, odto.getIdperfil());

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

    public String eliminarRoles(perfilesDTO odto) {
        try {
            String sqlDelete = "DELETE FROM `smilesystemv2`.`perfiles` WHERE `perfiles`.`idperfil` = ?";

            pstmt = cnn.prepareStatement(sqlDelete);
            pstmt.setInt(1, odto.getIdperfil());
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
