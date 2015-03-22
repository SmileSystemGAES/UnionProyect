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
public class accionesDTO {

    private int idaccion = 0;
    private String descripcion = "";
    private int estado = 0;
    private String url = "";
    private int parent = 0;

    public accionesDTO(int idaccion, String descripcion, int estado, String url, int parent) {

        this.idaccion = idaccion;
        this.descripcion = descripcion;
        this.estado = estado;
        this.url = url;
        this.parent = parent;

    }

    public accionesDTO() {
    }

    public int getIdaccion() {
        return idaccion;
    }

    public void setIdaccion(int idaccion) {
        this.idaccion = idaccion;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "accionesDTO{" + "idaccion=" + idaccion + ", descripcion=" + descripcion + ", estado=" + estado + ", url=" + url + ", parent=" + parent + '}';
    }

}
