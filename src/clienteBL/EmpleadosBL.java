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
public class EmpleadosBL {
    
   private int identificacion;
   private String nombre;
   private String cargo;
   
   
    public EmpleadosBL(){
    
    }
    public EmpleadosBL(int identificacion, String nombre, String cargo) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.cargo = cargo;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
   
   
     public int ingresarEmpleadoBL(EmpleadosBL objEmpleado)
    {
        conexionBD objConexion = new conexionBD();
        String nombre = "";
        String cargo = "";
        int identificacion = 0;
       
        try{
            nombre = objEmpleado.getNombre();
            identificacion = objEmpleado.getIdentificacion();
            cargo = objEmpleado.getCargo();
         
            String datos = String.format("INSERT INTO empleado ( identificacionEM ,nombreEM ,cargoEM) VALUES ('%s','%s','%s')", identificacion, nombre , cargo);
            
            objConexion.ejecutarSentenciaSQL(datos);
            return 1;
        }catch(Exception e){
            System.out.println(e);
            return 0;
        }
  
    }
    
    
    
    
        public ResultSet mostrarDatoEmpleado()
    {
        
        
        conexionBD objConexion = new conexionBD();
        
        try {
            ResultSet resultado = objConexion.consultarDatos("SELECT * FROM empleado");
            return resultado;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
     
    
        
        
    
    
    
    
    
    
    
    
    
}
