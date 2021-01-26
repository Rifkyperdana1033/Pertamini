/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pertaminifx;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Java Source Code
 */
public class koneksi {
        
        public static String MYSQLhost = "jdbc:mysql://localhost/pertamini";
        public static String user = "root";
        public static String pass = "";
        
        public static Connection koneksi(String driver)throws SQLException {
        Connection conn = null;
       if ("MYSQL".equals(driver)){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(MYSQLhost,user,pass);
            System.out.println("Koneksi Berhasil");
            return conn;
            }
        catch (SQLException e) {
            System.out.println("Koneksi Gagal "+e);
        }
        catch (ClassNotFoundException e){
            System.out.println("Koneksi Gagal "+e);
        }
       }
      
       return null; 
    }
}
