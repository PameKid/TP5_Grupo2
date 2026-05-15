package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
    private static final String HOST = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "sistema_clientes";
    private static final String USER = "";
    private static final String PASS = "";

    private static Conexion instancia;
    private Connection connection;

    private Conexion() {
        String cadenaConexion = HOST + DB_NAME;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            this.connection = DriverManager.getConnection(cadenaConexion, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection getConnection() {
        if (connection == null) {
            throw new IllegalStateException("No se pudo establecer la conexion con la base de datos.");
        }
        return connection;
    }

    public void cerrarConexion() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
