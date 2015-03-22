/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dtos;

/**
 *
 * @author USUARIO
 */
public class jornadasDTO {

    private int idjornada = 0;
    private String horario = "";

    public int getIdjornada() {
        return idjornada;
    }

    public void setIdjornada(int idjornada) {
        this.idjornada = idjornada;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public jornadasDTO(int idjornada, String horario) {
        this.idjornada = idjornada;
        this.horario = horario;
    }

    public jornadasDTO() {
    }

    @Override
    public String toString() {
        return "jornadasDTO{" + "idjornada=" + idjornada + ", horario=" + horario + '}';
    }
      
    
}
