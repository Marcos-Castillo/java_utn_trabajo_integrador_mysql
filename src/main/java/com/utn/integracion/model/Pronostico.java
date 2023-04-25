package com.utn.integracion.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.utn.integracion.IO.IO;

public class Pronostico {
    private int idPronostico;
    private String equipo1;
    private String equipo2;
    private int golesEq1;
    private int golesEq2;
    private String descripcion;
    private int ronda;
    

    public Pronostico(int idPronostico, String equipo1, String equipo2, int golesEq1, int golesEq2, String descripcion, Resultado resultado) {
        this.idPronostico = idPronostico;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEq1 = golesEq1;
        this.golesEq2 = golesEq2;
        this.descripcion = descripcion;
        
    }

    public int getIdPronostico() {
        return idPronostico;
    }

    public void setIdPronostico(int idPronostico) {
        this.idPronostico = idPronostico;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void String(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGolesEq1() {
        return golesEq1;
    }

    public void setGolesEq1(int golesEq1) {
        this.golesEq1 = golesEq1;
    }

    public int getGolesEq2() {
        return golesEq2;
    }

    public void setGolesEq2(int golesEq2) {
        this.golesEq2 = golesEq2;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static void pronosticoCsv() {
		String file="pronostico.csv";
		
		String line;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			while ((line = reader.readLine()) != null) {
				
				
			IO.cargarResultado(Integer.parseInt(line.split(",")[0]), Integer.parseInt(line.split(",")[1]), Integer.parseInt(line.split(",")[2]), Integer.parseInt(line.split(",")[3]));			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found in specifid path " + file);
		} catch (Exception e) {
			System.out.println("Error while reading the xml file");
		}
		
	}



}
