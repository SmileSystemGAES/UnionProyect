/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Dtos.PacienteDTO;
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
public class PacienteDAO {

    PreparedStatement pstmt = null;
    Connection cnn = null;
    int rtdo;
    ResultSet rs = null;

    public PacienteDAO() {
        cnn = Conexion.getInstance();
    }

    String mensaje = "";

    public List<PacienteDTO> listarTodos() {
        ArrayList<PacienteDTO> Paciente = new ArrayList<>();
        try {
            String sqlAll = "SELECT idPaciente, idRh, FechaIngreso FROM pacientes where 1=1";

            pstmt = cnn.prepareStatement(sqlAll);
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    Paciente.add(new PacienteDTO(rs.getInt("idPaciente"), rs.getInt("idRh"), rs.getString("FechaIngreso")));
                }
            }
        } catch (SQLException ex) {
            mensaje = "Error, datelle " + ex.getMessage();
        }

        return Paciente;
    }

    public String crearPaciente(PacienteDTO odto) {
        try {
            String sqlInsert = "INSERT INTO pacientes(idPaciente,idRh, FechaIngreso) VALUES(?, ?, ?)";

            pstmt = cnn.prepareStatement(sqlInsert);
            pstmt.setInt(1, odto.getIdPaciente());
            pstmt.setInt(2, odto.getIdRh());
            pstmt.setString(3, odto.getFechaIngreso());

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

    public PacienteDTO obtenerUno(int id) {
        PacienteDTO odto = null;
        String sqlOne = "SELECT  idRh, FechaIngreso FROM pacientes WHERE `idPaciente` = ?";
        try {
            pstmt = cnn.prepareStatement(sqlOne);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    odto = new PacienteDTO(id, rs.getInt("idRh"), rs.getString("FechaIngreso"));

                }
            }
        } catch (SQLException sqle) {
            mensaje = "Error, detalle " + sqle.getMessage();
        }

        return odto;
    }

    public String modificarUsuario(PacienteDTO odto) {
        try {
            String sqlUpdate = "UPDATE pacientes SET idRh=?, FechaIngreso =? WHERE idPaciente =?";
            pstmt = cnn.prepareStatement(sqlUpdate);
            pstmt.setInt(1, odto.getIdRh());
            pstmt.setString(2, odto.getFechaIngreso());
            pstmt.setInt(3, odto.getIdPaciente());

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

    public String eliminarPaciente(PacienteDTO odto) {
        try {
            String sqlDelete = "DELETE FROM `smilesystemv2`.`pacientes` WHERE `pacientes`.`idPaciente` = ?";

            pstmt = cnn.prepareStatement(sqlDelete);
            pstmt.setInt(1, odto.getIdPaciente());
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
