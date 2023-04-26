package com.utn.integracion;

import java.sql.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.utn.integracion.IO.IO;

import Conexion.ConexionJDBC;

@SpringBootApplication
public class IntegracionApplication {

	
	public static void main(String[] args) throws SQLException {
		
		
                                SpringApplication.run(IntegracionApplication.class, args);
                        	   	// Obtener la conexión a la base de datos
                                  ConexionJDBC ConexJDBC = ConexionJDBC.getInstance();
                                  Connection connection = ConexJDBC.getConexion();

                                  //carga los archivos del csv a la bbdd
                                  
                                   // IO.leerCsvPronostico();
                                    IO.CalcularPuntos(connection);

                                    
                                    //mustra resultados
                                    IO.leerPuntos(connection);
                                    
                                 // cerrar la conexión a la base de datos
                                    connection.close();
	}

}
