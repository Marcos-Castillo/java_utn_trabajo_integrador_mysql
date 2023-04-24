package Conexion;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.*;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConexionJDBC {
    private static ConexionJDBC instancia;
    private Connection conexion;

    private ConexionJDBC() {
    	String url ="jdbc:mysql://localhost/utn_integracion";
        String user = "root";
        String password= "root1234";
    	//obtenindo config desde propieties inicio
    	try {
            java.util.Properties props = new Properties();
            props.load(new FileInputStream("config.properties"));
            url = props.getProperty("database.url");
            user = props.getProperty("database.user");
            password = props.getProperty("database.password");
            

            // Use the values...
          } catch (IOException e) {
            System.err.println("Error loading properties file: " + e.getMessage());
          }
    	//obtenindo config desde propieties fin
        try {
         
            conexion = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            System.out.println("Error al conectar con la base de datos.");
        }
    }

    public static ConexionJDBC getInstance() {
        if (instancia == null) {
            instancia = new ConexionJDBC();
        }
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }
}
