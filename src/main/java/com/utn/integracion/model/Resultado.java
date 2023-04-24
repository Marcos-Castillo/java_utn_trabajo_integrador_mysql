package com.utn.integracion.model;

public class Resultado {
    private int idResultado;
    private String descripcion;
    private int puntos;

    public Resultado(int idResultado, String descripcion, int puntos) {
        this.idResultado = idResultado;
        this.descripcion = descripcion;
        this.puntos = puntos;
    }

    public Resultado() {
		// TODO Auto-generated constructor stub
	}

	public int getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(int idResultado) {
        this.idResultado = idResultado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
