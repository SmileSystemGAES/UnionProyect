package Daos;

import Dtos.OdontologosDTO;
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

/**
 *
 * @author Administrador
 */
public class OdontologoDAO {

    PreparedStatement pstmt = null;
    Connection cnn = null;
    int rtdo;
    ResultSet rs = null;

    public OdontologoDAO() {
        cnn = Conexion.getInstance();
    }

    String mensaje = "";

    public List<OdontologosDTO> listarTodos() {
        ArrayList<OdontologosDTO> odontolo = new ArrayList<>();
        try {
            String sqlAll = "SELECT idOdontologo, idjornada, tarjetaProfesional FROM odontologos where 1=1";

            pstmt = cnn.prepareStatement(sqlAll);
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    odontolo.add(new OdontologosDTO(rs.getInt("idOdontologo"), rs.getInt("idjornada"), rs.getInt("tarjetaProfesional")));
                }
            }
        } catch (SQLException ex) {
            mensaje = "Error, datelle " + ex.getMessage();
        }

        return odontolo;
    }

    public String crearOdontologo(OdontologosDTO odto) {
        try {
            String sqlInsert = "INSERT INTO odontologos(idOdontologo,idjornada, tarjetaProfesional) VALUES(?, ?, ?)";

            pstmt = cnn.prepareStatement(sqlInsert);
            pstmt.setInt(1, odto.getIdOdontologo());
            pstmt.setInt(2, odto.getIdJornada());
            pstmt.setInt(3, odto.getTarjetaProfesional());

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

    public OdontologosDTO obtenerUno(int id) {
        OdontologosDTO odto = null;

        String sqlOne = "SELECT  idjornada, tarjetaProfesional FROM odontologos WHERE idOdontologo = ?";
        try {
            pstmt = cnn.prepareStatement(sqlOne);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    odto = new OdontologosDTO(id, rs.getInt("idjornada"), rs.getInt("tarjetaProfesional"));

                }
            }
        } catch (SQLException sqle) {
            mensaje = "Error, detalle " + sqle.getMessage();
        }

        return odto;
    }

    public String modificarOdontologo(OdontologosDTO odto) {
        try {
            String sqlUpdate = "UPDATE odontologos SET idjornada=?,tarjetaProfesional=? WHERE idOdontologo =? AND idJornada=?";

            pstmt = cnn.prepareStatement(sqlUpdate);
            pstmt.setInt(1, odto.getTarjetaProfesional());
            pstmt.setInt(2, odto.getIdOdontologo());
            pstmt.setInt(3, odto.getIdJornada());

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

    public String eliminarOdontologos(OdontologosDTO odto) {
        try {
            String sqlDelete = "DELETE FROM `smilesystemv2`.`odontologos` WHERE `odontologos`.`idOdontologo` = ?";

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
