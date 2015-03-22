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
public class UsuariosDTO {

    private String nombres = "";
    private String apellidos = "";
    private String tipoDoc = "";
    private long documento = 0;
    private int grupoSangui = 0;
    private int tipoAlergia = 0;
    private String fechadenacimiento = "";
    private String lugardeNacimiento = "";
    private String email = "";
    private String telefono = "";
    private String direccion = "";
    private String ciudad = "";
    private String genero = "";
    private String usuario = "";
    private int clave = 0;
    private String  rol="";
    private int roles=0;

  

    public UsuariosDTO() {

    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    /**
     * @return the tipoDoc
     */
    public String getTipoDoc() {
        return tipoDoc;
    }

    /**
     * @param tipoDoc the tipoDoc to set
     */
    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    @Override
    public String toString() {
        return "UsuariosDTO{" + "nombres=" + nombres + ", apellidos=" + apellidos + ", documento=" + documento + ", tipoDoc=" + tipoDoc + ", grupoSangui=" + grupoSangui + ", tipoAlergia=" + tipoAlergia + ", fechadenacimiento=" + fechadenacimiento + ", lugardeNacimiento=" + lugardeNacimiento + ", email=" + email + ", telefono=" + telefono + ", direccion=" + direccion + ", ciudad=" + ciudad + ", genero=" + genero + ", usuario=" + usuario + ", clave=" + clave + ", rol=" + rol + '}';
    }

    public int getGrupoSangui() {
        return grupoSangui;
    }

    public void setGrupoSangui(int grupoSangui) {
        this.grupoSangui = grupoSangui;
    }

    public int getTipoAlergia() {
        return tipoAlergia;
    }

    public void setTipoAlergia(int tipoAlergia) {
        this.tipoAlergia = tipoAlergia;
    }

    /**
     * @return the fechadenacimiento
     */
    public String getFechadenacimiento() {
        return fechadenacimiento;
    }

    /**
     * @param fechadenacimiento the fechadenacimiento to set
     */
    public void setFechadenacimiento(String fechadenacimiento) {
        this.fechadenacimiento = fechadenacimiento;
    }

    /**
     * @return the lugardeNacimiento
     */
    public String getLugardeNacimiento() {
        return lugardeNacimiento;
    }

    /**
     * @param lugardeNacimiento the lugardeNacimiento to set
     */
    public void setLugardeNacimiento(String lugardeNacimiento) {
        this.lugardeNacimiento = lugardeNacimiento;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad the ciudad to set
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getRoles() {
        return roles;
    }

    public void setRoles(int roles) {
        this.roles = roles;
    }

 

 
}
