/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSP05_CTR;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    public static Connection Conectar(){
      Connection cnx=null;
      try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_fruteria", "root", "");
            return cnx;
        }
        catch (Exception ex) 
        {
            ex.printStackTrace();
            return null;
        }  
    }
    public static void main(String[] args) {
        Connection cnx = Conectar();
        if(cnx == null){
            System.out.println("Error conexion");
        }else{
            System.out.println("Conectado");
        }
    }
}
