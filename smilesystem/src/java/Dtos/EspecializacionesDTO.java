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
public class EspecializacionesDTO {

    private int idEspecializacion = 0;
    private String Descripcion = "";

    public EspecializacionesDTO(int idespec, String descrip) {
        this.idEspecializacion = idespec;
        this.Descripcion = descrip;
    }

    public EspecializacionesDTO() {
    }

    @Override
    public String toString() {
        return "EspecializacionesDTO{" + "idEspecializacion=" + getIdEspecializacion() + ", Descripcion=" + getDescripcion() + '}';
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

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

}
