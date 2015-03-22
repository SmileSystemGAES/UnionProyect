/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.CargosDTO;
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
public class CargosDAO {

    PreparedStatement pstmt = null;
    Connection cnn = Conexion.getInstance();
    int rtdo;
    ResultSet rs = null;

    public CargosDAO() {
        cnn = Conexion.getInstance();
    }

    String mensaje;

    public List<CargosDTO> listarTodos() {
        ArrayList<CargosDTO> cargos = new ArrayList();
        try {
            String sqlAll = " SELECT idCargos, Descripcion FROM  cargos where 1=1";
            pstmt = cnn.prepareStatement(sqlAll);
            rs = pstmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    cargos.add(new CargosDTO(rs.getInt("idCargos"), rs.getString("Descripcion")));
                }
            }

        } catch (SQLException ex) {
            mensaje = "error, detalle" + ex.getMessage();
        }
        return cargos;
    }

    public String crearCargo(CargosDTO odto) {
        try {
            String sqlInsert = "INSERT INTO cargos(idCargos,Descripcion) VALUES(?, ?)";

            pstmt = cnn.prepareStatement(sqlInsert);
            pstmt.setInt(1, odto.getIdCargos());
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

    public CargosDTO obtenerUno(int id) {

        CargosDTO odto = null;
        String sqlOne = "SELECT  Descripcion FROM cargos WHERE idCargos = ?";
        try {
            pstmt = cnn.prepareStatement(sqlOne);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {

                    odto = new CargosDTO(id, rs.getString("Descripcion"));
                }
            }
        } catch (SQLException sqle) {
            mensaje = "Error, detalle " + sqle.getMessage();
        }

        return odto;
    }

    public String modificarCargo(CargosDTO odto) {
        try {
            String sqlUpdate = "UPDATE  cargos SET  Descripcion = ? WHERE idCargos = ?";
            pstmt = cnn.prepareStatement(sqlUpdate);
            pstmt.setString(1, odto.getDescripcion());
            pstmt.setInt(2, odto.getIdCargos());

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

    public String eliminarCargo(CargosDTO odto) {
        try {
            String sqlDelete = "DELETE FROM `smilesystemv2`.`cargos` WHERE `cargos`.`idCargos` = ?";

            pstmt = cnn.prepareStatement(sqlDelete);
            pstmt.setInt(1, odto.getIdCargos());
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
