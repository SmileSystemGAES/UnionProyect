/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Conexion.Conexion;
import Dtos.accionesDTO;
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
public class accionesDAO {

    PreparedStatement pstmt = null;
    Connection cnn = null;
    int rtdo;
    ResultSet rs = null;

    public accionesDAO() {
        cnn = Conexion.getInstance();

    }

    String mensaje = "";

    public List<accionesDTO> listarTodos() {
        ArrayList<accionesDTO> acciones = new ArrayList<>();
        try {
            String sqlAll = "SELECT idaccion, descripcion,estado, url, parent FROM acciones  where 1=1";

            pstmt = cnn.prepareStatement(sqlAll);
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    acciones.add(new accionesDTO(rs.getInt("idaccion"), rs.getString("descripcion"), rs.getInt("estado"), rs.getString("url"), rs.getInt("parent")));
                }
            }
        } catch (SQLException ex) {
            mensaje = "Error, datelle " + ex.getMessage();
        }

        return acciones;
    }

    public String crearPermisos(accionesDTO odto) {
        try {
            String sqlInsert = "INSERT INTO acciones VALUES(?, ?, ?, ?,?)";

            pstmt = cnn.prepareStatement(sqlInsert);
            pstmt.setInt(1, odto.getIdaccion());
            pstmt.setString(2, odto.getDescripcion());
            pstmt.setInt(3, odto.getEstado());
            pstmt.setString(4, odto.getUrl());
            pstmt.setInt(4, odto.getParent());

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

    public accionesDTO obtenerUno(int id) {
        accionesDTO odto = null;
        String sqlOne = "SELECT  descripcion,estado, url, parent FROM acciones WHERE `idaccion` = ?";
        try {
            pstmt = cnn.prepareStatement(sqlOne);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    odto = new accionesDTO(id, rs.getString("descripcion"), rs.getInt("estado"), rs.getString("url"), rs.getInt("parent"));

                }
            }
        } catch (SQLException sqle) {
            mensaje = "Error, detalle " + sqle.getMessage();
        }

        return odto;
    }

    public String modificarPermisos(accionesDTO odto) {
        try {
            String sqlUpdate = "UPDATE acciones SET descripcion=?, ,estado =?, url = ?, parent= ? WHERE idacciones = ?";
            pstmt = cnn.prepareStatement(sqlUpdate);
            pstmt.setString(1, odto.getDescripcion());
            pstmt.setInt(2, odto.getEstado());
            pstmt.setString(3, odto.getUrl());
            pstmt.setInt(4, odto.getParent());
            pstmt.setInt(5, odto.getIdaccion());

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

    public String eliminarUsuario(accionesDTO odto) {
        try {
            String sqlDelete = "DELETE FROM `smilesystemv2`.`acciones` WHERE `acciones`.`idaccion` = ?";

            pstmt = cnn.prepareStatement(sqlDelete);
            pstmt.setInt(1, odto.getIdaccion());
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
