package sistemadeinventario.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String USS = "root";
    private static final String PASS = "";
    private static final String URL = "jdbc:mysql://localhost:3306/bdsistemainventario?useServerPrepStmts=true";
    protected static PreparedStatement pst=null;
    protected static ResultSet rs=null;

    private Connection con = null;

    public Connection getCon() { 
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void createConnection() {

        try {
            Class.forName(DRIVER);

            con = DriverManager.getConnection(URL, USS, PASS);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Conexion Erronea");
        }
    }

    public void closeConnection() {
        try {
            if (con != null) {
                if (con.isClosed() == false) {
                    con.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("NO SE CERRO LA CONEXION");
        }
    }
}
