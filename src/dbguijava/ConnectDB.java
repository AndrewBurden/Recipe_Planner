
package dbguijava;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

public class ConnectDB {
   
    public static Connection setupConnection(){
        String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
        String jdbcUrl = "jdbc:oracle:thin:@csshrpt.eku.edu:1521:cscdb";  // URL for the database including the protocol (jdbc), the vendor (oracle), the driver (thin), the server (csshrpt.eku.edu), the port number (1521), database instance name (cscdb)

        String username = "washah5452017";
        String password = "6201";
        
        try{
            // Load jdbc driver.            
            Class.forName(jdbcDriver);
            
            // Connect to the Oracle database
            Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
            return conn;
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    static void close(Connection conn){ 
        if(conn != null) {
            try{
                conn.close();
            }
            catch(Throwable whatever)
            {}
        }
    }

    static void close(OraclePreparedStatement st){
        if(st != null){
            try{
                st.close();
            }
            catch(Throwable whatever)
            {}
        }
    }

    static void close(OracleResultSet rs){
        if(rs != null){
            try{
                rs.close();
            }
            catch(Throwable whatever)
            {}
        }
    }
}
