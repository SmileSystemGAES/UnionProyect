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
public class TelefonoDTO {

    private int idTelefono = 0;
    private int documento = 0;

    public TelefonoDTO(int idte, int docu) {
        this.idTelefono = idte;
        this.documento = docu;

    }

    public TelefonoDTO() {
    }

    public int getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(int idTelefono) {
        this.idTelefono = idTelefono;
    }

    public int getDocumento() {
        return documento;
    }

    @Override
    public String toString() {
        return "TelefonoDTO{" + "idTelefono=" + idTelefono + ", documento=" + documento + '}';
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }


    
    

}