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
public class CargosDTO {

    private int idCargos = 0;
    private String descripcion = "";

    public CargosDTO(int idcarg, String descrip) {
        this.idCargos = idcarg;
        this.descripcion = descrip;

    }

    public CargosDTO() {
    }

    @Override
    public String toString() {
        return "CargosDTO{" + "idCargos=" + idCargos + ", descripcion=" + descripcion + '}';
    }

    /**
     * @return the idCargos
     */
    public int getIdCargos() {
        return idCargos;
    }

    /**
     * @param idCargos the idCargos to set
     */
    public void setIdCargos(int idCargos) {
        this.idCargos = idCargos;
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
