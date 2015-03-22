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
public class AdministrativosDTO  {
    private int Documento=0;
    private int idcargo=0;

    public AdministrativosDTO(int docu, int idc) {
        this.Documento=docu;
        this.idcargo=idc;
    }
    
     public AdministrativosDTO() {
    }

    public int getDocumento() {
        return Documento;
    }

    public void setDocumento(int Documento) {
        this.Documento = Documento;
    }

    public int getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(int idcargo) {
        this.idcargo = idcargo;
    }

    @Override
    public String toString() {
        return "AdministrativosDTO{" + "Documento=" + Documento + ", idcargo=" + idcargo + '}';
    }

   
     
} 
    
    
    

   