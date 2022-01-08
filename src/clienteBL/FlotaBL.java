/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteBL;

import clienteDAL.conexionBD;

/**
 *
 * @author Yisus
 */
public class FlotaBL {
    String placa;
    String capacidad;
    String galones;
    String asignarConductor;
    String asignarRu;
    

    public FlotaBL(String placa, String capacidad, String galones, String asignarRu, String asignarConductor) {
        this.placa = placa;
        this.capacidad = capacidad;
        this.galones = galones;
        this.asignarRu=asignarRu;
        this.asignarConductor=asignarConductor;
    }

    public String getAsignarConductor() {
        return asignarConductor;
    }

    public void setAsignarConductor(String asignarConductor) {
        this.asignarConductor = asignarConductor;
    }

    public String getAsignarRu() {
        return asignarRu;
    }

    public void setAsignarRu(String asignarRu) {
        this.asignarRu = asignarRu;
    }

    
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getGalones() {
        return galones;
    }

    public void setGalones(String galones) {
        this.galones = galones;
    }
    
    
    
    
    
    
      public int ingresarFlotaBL(FlotaBL objflota)
    {
        conexionBD objConexion = new conexionBD();
        String placa = "";
        String pasajero  = "";
        String galon = "";
        String conductor ="";
        String ruta ="";
       
        try{
             placa = objflota.getPlaca();
             pasajero  = objflota.getCapacidad();
             galon = objflota.getGalones();
             conductor = objflota.getAsignarConductor();
             ruta = objflota.getAsignarRu();
         
            String datos = String.format("INSERT INTO bus ( idBUS , placaBUS , pasajeroBUS, galonBUS, conductorBUS, rutaBUS) VALUES (null,'%s','%s','%s','%s','%s')", placa, pasajero , galon, conductor,ruta);
            
            objConexion.ejecutarSentenciaSQL(datos);
            return 1;
        }catch(Exception e){
            System.out.println(e);
            return 0;
        }
  
    }
        
    
    
    
    
    
    
    
    
    
}
