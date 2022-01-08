

package clienteDAL;
import java.sql.*;




public class conexionBD {
    //String strConexionBD = "";
    Connection conn = null;
    String driver = "com.mysql.cj.jdbc.Driver";
    String user = "root";
    String pass = "root";
    //String url = "jdbc:mysql://127.0.0.1:3306/tablasproytecto";
    String url = "jdbc:mysql://127.0.0.1:3306/transportebd";
    
    public conexionBD(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pass);
            System.out.println("Conexión establecida");
        }catch(Exception e){
        
            System.out.println("Error de conexión"+e);
        }
    }
    
    public int ejecutarSentenciaSQL(String strSentenciaSQL)
    {
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            pstm.execute();
            return 1;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }
    
    public ResultSet consultarDatos(String strSentenciaSQL)
    {
        try {
            PreparedStatement pstm = conn.prepareStatement(strSentenciaSQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
