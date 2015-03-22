/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.AdministrativosDTO;
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
public class AdministrativosDAO {

    PreparedStatement pstmt = null;
    Connection cnn = null;
    int rtdo;
    ResultSet rs = null;

    public AdministrativosDAO() {
        cnn = Conexion.getInstance();

    }

    String mensaje = "";

    public List<AdministrativosDTO> listarTodos() {
        ArrayList<AdministrativosDTO> administ = new ArrayList<>();
        try {
            String sqlAll = "SELECT Documento, idcargo FROM administrativos where 1=1";

            pstmt = cnn.prepareStatement(sqlAll);
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    administ.add(new AdministrativosDTO(rs.getInt("Documento"), rs.getInt("idcargo")));
                }
            }
        } catch (SQLException ex) {
            mensaje = "Error, datelle " + ex.getMessage();
        }

        return administ;
    }

    public String crearAdministrativos(AdministrativosDTO odto) {
        try {
            String sqlInsert = "INSERT INTO administrativos(Documento,idcargo) VALUES( ?, ?)";

            pstmt = cnn.prepareStatement(sqlInsert);
            pstmt.setInt(1, odto.getDocumento());
            pstmt.setInt(2, odto.getIdcargo());

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

    public AdministrativosDTO obtenerUno(int id) {
        AdministrativosDTO odto = null;

        String sqlOne = "SELECT  idcargo FROM administrativos WHERE Documento = ?";
        try {
            pstmt = cnn.prepareStatement(sqlOne);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    odto = new AdministrativosDTO(id, rs.getInt("Idcargo"));

                }
            }
        } catch (SQLException sqle) {
            mensaje = "Error, detalle " + sqle.getMessage();
        }

        return odto;
    }

    public String modificarAdministrativos(AdministrativosDTO odto) {
        try {
            String sqlUpdate = "UPDATE administrativos SET idcargo =? WHERE Documento = ?";
            pstmt = cnn.prepareStatement(sqlUpdate);
            pstmt.setInt(1, odto.getIdcargo());
            pstmt.setInt(2, odto.getDocumento());

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

    public String eliminarAdministrativos(AdministrativosDTO odto) {
        try {
            String sqlDelete = "DELETE FROM `smilesystemv2`.`administrativos` WHERE `administrativos`.`Documento` = ?";

            pstmt = cnn.prepareStatement(sqlDelete);
            pstmt.setInt(1, odto.getDocumento());
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
