package com.utn.integracion.IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexion.ConexionJDBC;

public class IO  {
	
	public static void cargarPartido(int idEquipo1, int idEquipo2, int GolesEq1, int GolesEq2,String descripcion) throws SQLException {
		// Se asume que se ha establecido una conexión con la base de datos
		Connection conn = ConexionJDBC.getInstance().getConexion();

		// Se prepara la sentencia SQL
		String sql = "INSERT INTO partido (idEquipo1, idEquipo2, GolesEq1, GolesEq2,descripcion) VALUES (?, ?, ?, ?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, idEquipo1);
		ps.setInt(2, idEquipo2);
		ps.setInt(3, GolesEq1);
		ps.setInt(4, GolesEq2);
		ps.setString(5, descripcion);

		// Se ejecuta la sentencia SQL
		ps.executeUpdate();

	}
	public static void cargarPronostico (String equipo1,int goleseq1, String equipo2,  int goleseq2 ,String jugador, int ronda) throws SQLException {
		// Se asume que se ha establecido una conexión con la base de datos
		Connection conn = ConexionJDBC.getInstance().getConexion();
	

		// Se prepara la sentencia SQL
		String sql = "INSERT INTO pronostico ( equipo1, equipo2, goleseq1, goleseq2, jugador, ronda) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, equipo1);
		ps.setString(2, equipo2);
		ps.setInt(3, goleseq1);
		ps.setInt(4, goleseq2);
		ps.setString(5, jugador);
		ps.setInt(6, ronda);
		// Se ejecuta la sentencia SQL
		ps.executeUpdate();

	}	
	
	public static void cargarEquipo(String nombre, String descripcion) throws SQLException {
		// Se asume que se ha establecido una conexión con la base de datos
		Connection conn = ConexionJDBC.getInstance().getConexion();

		// Se prepara la sentencia SQL
		String sql = "INSERT INTO equipo (nombre, descripcion) VALUES (?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, nombre);
		ps.setString(2, descripcion);


		// Se ejecuta la sentencia SQL
		ps.executeUpdate();
		
	}
	
	public static void leerCsvPronostico() {
		
			String file="Pronostico.csv";
			//List<Producto> data = new ArrayList<>();
			String line;
			
			try {
				BufferedReader reader = new BufferedReader(new FileReader(file));
				while ((line = reader.readLine()) != null) {
					System.out.println(line.split(";")[0]+" "+line.split(";")[1]+" "+line.split(";")[2]+" "+line.split(";")[3]+" "+line.split(";")[4]+" "+line.split(";")[5]);
					cargarPronostico(line.split(";")[0],Integer.parseInt(line.split(";")[1]),line.split(";")[2],Integer.parseInt(line.split(";")[3]),line.split(";")[4],Integer.parseInt(line.split(";")[5]));
				
				}
				reader.close();
			} catch (Exception e) {
				System.out.println("File not found in specifid path " + file);
			}
		
	}
    
	public static void leerPuntos(Connection connection) throws SQLException {

        
        // Crear la consulta
        String selectSql = "select * from jugadores order by puntos desc;";//"SELECT * FROM mi_tabla WHERE columna1 = ? AND columna2 = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
        

        
        // Ejecutar la consulta y obtener el resultado
        ResultSet resultSet = preparedStatement.executeQuery();
        
        // Recorrer el resultado y hacer algo con él
        while (resultSet.next()) {
            String columna1 = resultSet.getString("idjugadores");
            String columna2 = resultSet.getString("Nombre");
            String columna3 = resultSet.getString("puntos");
            System.out.println("ID " + columna1 + ", Nombre: " + columna2 + ", Puntos: " + columna3);
        }
        
        // Cerrar los recursos
        resultSet.close();
        preparedStatement.close();
		
	}
	
	public static void CalcularPuntos(Connection connection) {
			
				try {	
					// Crear la consulta
			        String selectSql = "SELECT pro.jugador, count(pro.ganaEq = res.resultadoEqGanador) as \"suma puntos\"\r\n"
			        		+ "FROM utn_integracion.resultados as res\r\n"
			        		+ "INNER JOIN utn_integracion.pronostico as pro ON res.id = pro.idpronostico\r\n"
			        		+ "GROUP BY pro.jugador;";//compara las tablas y calcula los puntos
			        PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
			        
			
			        
			        // Ejecutar la consulta y obtener el resultado
			        ResultSet resultSet = preparedStatement.executeQuery();
			        
			        // Recorrer el resultado y hacer algo con él
			        while (resultSet.next()) {
			            String columna1 = resultSet.getString("jugador");
			            String columna2 = resultSet.getString("suma puntos");
			            
			            
			            	// Se prepara la sentencia SQL
			        		String sql = "update jugadores set puntos=puntos + (?)  Where Nombre = (?)";
			        		PreparedStatement ps = connection.prepareStatement(sql);
			        		
			        		ps.setInt(1, Integer.parseInt(columna2));
			        		ps.setString(2, columna1);
			        		
			
			        		// Se ejecuta la sentencia SQL
			        		ps.executeUpdate();
			            
			            
			            System.out.println("jugador " + columna1 + ", suma puntos: " + columna2 );
			        }
			        
			        // Cerrar los recursos
			        resultSet.close();
			        
			        preparedStatement.close();
				}catch(Exception e) {
					System.out.println(e);
				}
	}
		
	}
	