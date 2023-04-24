package com.utn.integracion.IO;

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
	public static void cargarResultado (int ronda, int partido, int golesequipo1, int golesequipo2) throws SQLException {
		// Se asume que se ha establecido una conexión con la base de datos
		Connection conn = ConexionJDBC.getInstance().getConexion();

		// Se prepara la sentencia SQL
		String sql = "INSERT INTO resultados (ronda, partido, golesequipo1, golesequipo2) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, ronda);
		ps.setInt(2, partido);
		ps.setInt(3, golesequipo1);
		ps.setInt(4, golesequipo2);

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
	
public static void leerEquipos(Connection connection) throws SQLException {

        
        // Crear la consulta
        String selectSql = "select * from equipo;";//"SELECT * FROM mi_tabla WHERE columna1 = ? AND columna2 = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(selectSql);

        
        // Ejecutar la consulta y obtener el resultado
        ResultSet resultSet = preparedStatement.executeQuery();
        
        // Recorrer el resultado y hacer algo con él
        while (resultSet.next()) {
            String columna1 = resultSet.getString("idequipo");
            String columna2 = resultSet.getString("nombre");
            String columna3 = resultSet.getString("descripcion");
            System.out.println("columna1 = " + columna1 + ", columna2 = " + columna2 + ", columna3 = " + columna3);
        }
        
        // Cerrar los recursos
        resultSet.close();
        preparedStatement.close();
		
	}
	
	

}
