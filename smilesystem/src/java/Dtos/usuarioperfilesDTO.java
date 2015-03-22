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
public class usuarioperfilesDTO {
    
    private long usuarioperfiles=0;
    private int perfilid=0;
    private int estado=0;

    public usuarioperfilesDTO(long usaperf, int perfilid, int estado) {
        this.usuarioperfiles=usaperf;
        this.perfilid=perfilid;
        this.estado=estado;
    }
    
    
      public usuarioperfilesDTO() {
    }
    
    
    

    @Override
    public String toString() {
        return "usuarioperfiles{" + "usuarioperfiles=" + usuarioperfiles + ", perfilid=" + perfilid + ", estado=" + estado + '}';
    }
    
    

    public long getUsuarioperfiles() {
        return usuarioperfiles;
    }

    public void setUsuarioperfiles(long usuarioperfiles) {
        this.usuarioperfiles = usuarioperfiles;
    }

    public int getPerfilid() {
        return perfilid;
    }

    public void setPerfilid(int perfilid) {
        this.perfilid = perfilid;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}

