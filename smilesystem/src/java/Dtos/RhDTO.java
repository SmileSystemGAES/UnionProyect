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
public class RhDTO {

    private int idRh = 0;
    private String descripcion = "";

    public RhDTO(int idrh, String descrip) {
        this.idRh = idrh;
        this.descripcion = descrip;

    }

    public RhDTO() {
    }

    @Override
    public String toString() {
        return "RhDTO{" + "idRh=" + idRh + ", descripcion=" + descripcion + '}';
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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
