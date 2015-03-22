/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

/**
 *
 * @author Administrador
 */
public class PacienteDTO  extends UsuariosDTO{
    private int idPaciente=0;
    private int idRh =0;
    private  String FechaIngreso="";
    
    
    public PacienteDTO( int idpa, int idrh, String fechain){
        this.idPaciente=idpa;
        this.idRh=idrh;
        this.FechaIngreso=fechain;
        
    }
      public PacienteDTO(){
        
    }

    /**
     * @return the idPaciente
     */
    public int getIdPaciente() {
        return idPaciente;
    }

    /**
     * @param idPaciente the idPaciente to set
     */
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    /**
     * @return the idRh
     */
    public int getIdRh() {
        return idRh;
    }

    /**
     * @param idRh the idRh to set
     */
    public void setIdRh(int idRh) {
        this.idRh = idRh;
    }

    /**
     * @return the FechaIngreso
     */
    public String getFechaIngreso() {
        return FechaIngreso;
    }

    /**
     * @param FechaIngreso the FechaIngreso to set
     */
    public void setFechaIngreso(String FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }

    @Override
    public String toString() {
        return "PacienteDTO{" + "idPaciente=" + idPaciente + ", idRh=" + idRh + ", FechaIngreso=" + FechaIngreso + '}';
    }
    
}
