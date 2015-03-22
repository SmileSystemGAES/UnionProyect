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
public class perfilesDTO {

    private int idperfil = 0;
    private String descripcion = "";
    private int estado = 0;

    public perfilesDTO(int idperfil, String descripcion, int estado) {
        this.idperfil = idperfil;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public perfilesDTO() {
    }

    public int getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(int idperfil) {
        this.idperfil = idperfil;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "perfilesDTO{" + "idperfil=" + idperfil + ", descripcion=" + descripcion + ", estado=" + estado + '}';
    }

}
