/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.bhintranet.client;
import java.sql.*;
/**
 *
 * @author moises_rodriguez
 */
public class Conexion {
   private static Connection cnx = null;
   public static Connection obtener() throws SQLException, ClassNotFoundException {
      if (cnx == null) {
         try {
            // String dbUrl = props.getProperty("jdbc.url");
            String dbUrl = "jdbc:mysql://127.0.0.1:3306/bdboldhouseperu";
            // String dbDriver = props.getProperty("jdbc.driver");
            String dbDriver = "com.mysql.jdbc.Driver";
            // String dbUname = props.getProperty("db.username");
            String dbUname = "root";
            // String dbPwd = props.getProperty("db.password");
            String dbPwd = "toor";
            Class.forName(dbDriver);
            cnx = DriverManager.getConnection(dbUrl, dbUname, dbPwd);
         } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
      }
      return cnx;
   }
   public static void cerrar() throws SQLException {
      if (cnx != null) {
         cnx.close();
      }
   }    
}
