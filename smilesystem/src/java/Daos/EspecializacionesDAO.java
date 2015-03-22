/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Conexion.Conexion;
import Dtos.EspecializacionesDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class EspecializacionesDAO {

    PreparedStatement pstmt = null;
    Connection cnn = Conexion.getInstance();
    int rtdo;
    ResultSet rs = null;

    public EspecializacionesDAO() {
        cnn = Conexion.getInstance();
    }

    String mensaje;

    public List<EspecializacionesDTO> listarTodos() {
        ArrayList<EspecializacionesDTO> Especializaciones = new ArrayList();
        try {
            String sqlAll = " SELECT idEspecializacion, Descripcion FROM  especializaciones where 1=1";
            pstmt = cnn.prepareStatement(sqlAll);
            rs = pstmt.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Especializaciones.add(new EspecializacionesDTO(rs.getInt("idEspecializacion"), rs.getString("Descripcion")));
                }
            }

        } catch (SQLException ex) {
            mensaje = "error, detalle" + ex.getMessage();
        }
        return Especializaciones;
    }

    public String crearEspecializaciones(EspecializacionesDTO odto) {
        try {
            String sqlInsert = "INSERT INTO cargos VALUES(?, ?)";

            pstmt = cnn.prepareStatement(sqlInsert);
            pstmt.setInt(1, odto.getIdEspecializacion());
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

    public EspecializacionesDTO obtenerUno(int id) {

        EspecializacionesDTO odto = null;
        String sqlOne = "SELECT  Descripcion FROM especializaciones WHERE idEspecializacion = ?";
        try {
            pstmt = cnn.prepareStatement(sqlOne);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {

                    odto = new EspecializacionesDTO(id, rs.getString("Descripcion"));
                }
            }
        } catch (SQLException sqle) {
            mensaje = "Error, detalle " + sqle.getMessage();
        }

        return odto;
    }

    public String modificarEspecializaciones(EspecializacionesDTO odto) {
        try {
            String sqlUpdate = "UPDATE  especializaciones SET  Descripcion = ? WHERE idEspecializacion = ?";
            pstmt = cnn.prepareStatement(sqlUpdate);
            pstmt.setString(1, odto.getDescripcion());
            pstmt.setInt(2, odto.getIdEspecializacion());

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

    public String eliminarCargo(EspecializacionesDTO odto) {
        try {
            String sqlDelete = "DELETE FROM `smilesystemv2`.`especializaciones` WHERE `especializaciones`.`idEspecializacion` = ?";

            pstmt = cnn.prepareStatement(sqlDelete);
            pstmt.setInt(1, odto.getIdEspecializacion());
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
