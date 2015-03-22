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
public class perfilaccionDTO {

    private int perfilid = 0;
    private int accionid = 0;
    private int estado = 0;

    public perfilaccionDTO(int perfilid, int accionid, int estado) {
        this.perfilid = perfilid;
        this.accionid = accionid;
        this.estado = estado;
    }

    public perfilaccionDTO() {
    }

    public int getPerfilid() {
        return perfilid;
    }

    public void setPerfilid(int perfilid) {
        this.perfilid = perfilid;
    }

    public int getAccionid() {
        return accionid;
    }

    public void setAccionid(int accionid) {
        this.accionid = accionid;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "perfilaccionDTO{" + "perfilid=" + perfilid + ", accionid=" + accionid + ", estado=" + estado + '}';
    }

}
