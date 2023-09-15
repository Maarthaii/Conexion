/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectiondb;

/**
 *
 * @author Liyi
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Conectiondb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String usuario ="root";
        String password="30888898";
        String url="jdbc:mysql://localhost:3306/tienda_antojitosfrit";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conectiondb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            conexion=DriverManager.getConnection(url,usuario,password);
            statement=conexion.createStatement();
            statement.executeUpdate("INSERT INTO USUARIOS(nombre_cliente,telefono,correo) VALUES('Corina', '320000' ,'corina@gmail.com')");
            rs=statement.executeQuery("SELECT * FROM USUARIOS");
            rs.next();
            
            do{
                System.out.println(rs.getInt("id_cliente")+" : "+rs.getString("nombre_cliente")+" : "+rs.getString("telefono")+" : "+rs.getString("correo"));
            }while(rs.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(Conectiondb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
