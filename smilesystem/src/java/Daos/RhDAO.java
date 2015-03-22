/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.RhDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Conexion.Conexion;

/**
 *
 * @author Administrador
 */
public class RhDAO {

    PreparedStatement pstmt = null;
    Connection cnn = Conexion.getInstance();
    int rtdo;
    ResultSet rs = null;

    public RhDAO() {
        cnn = Conexion.getInstance();
    }

    String mensaje;

    public List<RhDTO> listarTodos() {
        ArrayList<RhDTO> rh = new ArrayList();
        try {
            String sqlAll = " SELECT idRh, Descripcion FROM  rh where 1=1";
            pstmt = cnn.prepareStatement(sqlAll);
            rs = pstmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    rh.add(new RhDTO(rs.getInt("idRh"), rs.getString("Descripcion")));
                }
            }

        } catch (SQLException ex) {
            mensaje = "error, detalle" + ex.getMessage();
        }
        return rh;
    }

    public String crearRh(RhDTO odto) {
        try {
            String sqlInsert = "INSERT INTO rh(idRh,Descripcion) VALUES(?, ?)";

            pstmt = cnn.prepareStatement(sqlInsert);
            pstmt.setInt(1, odto.getIdRh());
            pstmt.setString(2, odto.getDescripcion());

            rtdo = pstmt.executeUpdate();
            if (rtdo != 0) {
                mensaje = "Registro éxitoso";
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

    public RhDTO obtenerUno(int id) {

        RhDTO odto = null;
        String sqlOne = "SELECT  Descripcion FROM rh WHERE idRh = ?";
        try {
            pstmt = cnn.prepareStatement(sqlOne);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {

                    odto = new RhDTO(id, rs.getString("Descripcion"));
                }
            }
        } catch (SQLException sqle) {
            mensaje = "Error, detalle " + sqle.getMessage();
        }

        return odto;
    }

    public String modificarRh(RhDTO odto) {
        try {
            String sqlUpdate = "UPDATE  rh SET  Descripcion = ? WHERE idRh = ?";
            pstmt = cnn.prepareStatement(sqlUpdate);
            pstmt.setString(1, odto.getDescripcion());
            pstmt.setInt(2, odto.getIdRh());

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

    public String eliminarRh(RhDTO odto) {
        try {
            String sqlDelete = "DELETE FROM `smilesystemv2`.`rh` WHERE `rh`.`idRh` = ?";

            pstmt = cnn.prepareStatement(sqlDelete);
            pstmt.setInt(1, odto.getIdRh());
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
