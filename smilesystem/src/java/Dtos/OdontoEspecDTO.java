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
public class OdontoEspecDTO {
    private int idOdontologo=0;
    private int  idEspecializacion=0;

    public OdontoEspecDTO(int idodo, int idespe) {
        this.idOdontologo=idodo;
        this.idEspecializacion=idespe;
    }

    public OdontoEspecDTO() {
    }

    @Override
    public String toString() {
        return "OdontoEspecDTO{" + "idOdontologo=" + getIdOdontologo() + ", idEspecializacion=" + getIdEspecializacion() + '}';
    }

    /**
     * @return the idOdontologo
     */
    public int getIdOdontologo() {
        return idOdontologo;
    }

    /**
     * @param idOdontologo the idOdontologo to set
     */
    public void setIdOdontologo(int idOdontologo) {
        this.idOdontologo = idOdontologo;
    }

    /**
     * @return the idEspecializacion
     */
    public int getIdEspecializacion() {
        return idEspecializacion;
    }

    /**
     * @param idEspecializacion the idEspecializacion to set
     */
    public void setIdEspecializacion(int idEspecializacion) {
        this.idEspecializacion = idEspecializacion;
    }
    
}
