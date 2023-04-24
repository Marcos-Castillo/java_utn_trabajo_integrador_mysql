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
                                
                                    //IO.cargarEquipo("Argentina", "el mejor");
                                    IO.leerEquipos(connection);
                                    IO.cargarResultado(1,1,2,0);
                                    IO.cargarPartido(1,1,1,1," todo  ok");
                                 // cerrar la conexión a la base de datos
                                    connection.close();
	}

}
