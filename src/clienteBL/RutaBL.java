/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteBL;

import clienteDAL.conexionBD;
import java.sql.ResultSet;

/**
 *
 * @author Yisus
 */
public class RutaBL {
    String ciudadOrigen;
    String horaorigen;
    String ciudaddestino;
    String horadestino;

    public RutaBL(String ciudadOrigen, String horaorigen, String ciudaddestino, String horadestino) {
        this.ciudadOrigen = ciudadOrigen;
        this.horaorigen = horaorigen;
        this.ciudaddestino = ciudaddestino;
        this.horadestino = horadestino;
    }

    public RutaBL() {
      
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getHoraorigen() {
        return horaorigen;
    }

    public void setHoraorigen(String horaorigen) {
        this.horaorigen = horaorigen;
    }

    public String getCiudaddestino() {
        return ciudaddestino;
    }

    public void setCiudaddestino(String ciudaddestino) {
        this.ciudaddestino = ciudaddestino;
    }

    public String getHoradestino() {
        return horadestino;
    }

    public void setHoradestino(String horadestino) {
        this.horadestino = horadestino;
    }
    
    
    
    
        public int ingresarRutaBL(RutaBL objRuta)
    {
        conexionBD objConexion = new conexionBD();
        String ciudadorigen = "";
        String horasalida = "";
        String ciudaddestino = "";
        String horallegada ="";
        
       
        try{
            ciudadorigen = objRuta.getCiudadOrigen();
            horasalida = objRuta.getHoraorigen();
            ciudaddestino = objRuta.getCiudaddestino();
            horallegada = objRuta.getHoradestino();
         
            String datos = String.format("INSERT INTO ruta ( idRUT , ciudadorigenRUT ,horasalidadRUT, ciudaddestinoRUT, horallegadaRUT) VALUES (null,'%s','%s','%s','%s')", ciudadorigen, horasalida , ciudaddestino, horallegada);
            
            objConexion.ejecutarSentenciaSQL(datos);
            return 1;
        }catch(Exception e){
            System.out.println(e);
            return 0;
        }
  
    }
        
        
        
        
        
      public ResultSet mostrarDatoRuta()
    {
        
        
        conexionBD objConexion = new conexionBD();
        
        try {
            ResultSet resultado = objConexion.consultarDatos("SELECT * FROM ruta");
            return resultado;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
      
      
     
     public void editarDatoRuta(String ciudad1, String ciudad2, String hora1, String hora2, String id){
         conexionBD objConexion = new conexionBD();
         
         String datos = String.format("UPDATE ruta SET ciudadorigenRUT='"+ciudad1+"',horasalidadRUT='"+hora1+"',ciudaddestinoRUT='"+ciudad2+"',horallegadaRUT='"+hora2+"' WHERE idRUT='" +id + "'" );

         objConexion.ejecutarSentenciaSQL(datos);
     
     }
    
    
     public void eliminarDatoRuta(String id){
        conexionBD objConexion = new conexionBD();
        String datos = String.format("DELETE FROM ruta WHERE idRUT='" + id + "' ");

        objConexion.ejecutarSentenciaSQL(datos);
     
     }
    
    
    
      
      
      
      
    
    
}
