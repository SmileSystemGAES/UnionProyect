/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Conexion.Conexion;
import Dtos.perfilaccionDTO;
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
public class perfilaccionDAO {

    PreparedStatement pstmt = null;
    Connection cnn = Conexion.getInstance();
    int rtdo;
    ResultSet rs = null;

    public perfilaccionDAO() {
        cnn = Conexion.getInstance();
    }

    String mensaje = "";

    public List< perfilaccionDTO> listarTodos() {
        ArrayList< perfilaccionDTO> perfil = new ArrayList<>();
        try {
            String sqlAll = "SELECT  perfilid,accionid,estado FROM perfilaccion where 1=1";

            pstmt = cnn.prepareStatement(sqlAll);
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    perfil.add(new perfilaccionDTO(rs.getInt("perfilid"), rs.getInt("accionid"), rs.getInt("estado")));
                }
            }
        } catch (SQLException ex) {
            mensaje = "Error, datelle " + ex.getMessage();
        }

        return perfil;
    }

    public String crearperfilaccion(perfilaccionDTO odto) {
        try {
            String sqlInsert = "INSERT INTO perfilaccion VALUES(?, ?,?)";

            pstmt = cnn.prepareStatement(sqlInsert);
            pstmt.setInt(1, odto.getPerfilid());
            pstmt.setInt(2, odto.getAccionid());
            pstmt.setInt(3, odto.getEstado());

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

    public perfilaccionDTO obtenerUno(int idusu, int idrol) {

        perfilaccionDTO odto = null;
        String sqlOne = "SELECT  perfilid, accionid, estado FROM perfilaccion WHERE perfilid = ? AND accionid=?";
        try {
            pstmt = cnn.prepareStatement(sqlOne);
            pstmt.setInt(1, idusu);
            pstmt.setInt(1, idrol);
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {

                    odto = new perfilaccionDTO();
                    odto.setPerfilid(rs.getInt("perfilid"));
                    odto.setAccionid(rs.getInt("accionid"));
                    odto.setEstado(rs.getInt("estado"));
                }
            }
        } catch (SQLException sqle) {
            mensaje = "Error, detalle " + sqle.getMessage();
        }

        return odto;
    }

    public String modificarRolPermiso(perfilaccionDTO odto) {
        try {
            String sqlUpdate = "UPDATE  perfilaccion SET  estado = ? WHERE perfilid = ? AND accionid=?";
            pstmt = cnn.prepareStatement(sqlUpdate);
            pstmt.setInt(1, odto.getPerfilid());
            pstmt.setInt(2, odto.getAccionid());

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

    public String eliminarRolPermiso(perfilaccionDTO odto) {
        try {
            String sqlDelete = "DELETE FROM `smilesystemv2`.`perfilaccion` WHERE `perfilaccion`.`perfilid ` = ? AND  `perfilaccion`.`accionid ` = ?";

            pstmt = cnn.prepareStatement(sqlDelete);
            pstmt.setInt(1, odto.getPerfilid());
            pstmt.setInt(1, odto.getAccionid());
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
