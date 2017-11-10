
package trabalhoead2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
    public static Connection getConnection() throws SQLException{
            String url = "jdbc:mysql://localhost:3306/ead_sp";
            String usuario = "root";
            String senha = "1234";
            return DriverManager.getConnection(url, usuario, senha);     
    
    }
}
