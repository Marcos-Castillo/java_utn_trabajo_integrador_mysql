package com.utn.integracion.model;

public class Partido {
    private int idPartido;
    private int idEquipo1;
    private int idEquipo2;
    private int golesEq1;
    private int golesEq2;
    private String descripcion;

    public Partido(int idPartido, int idEquipo1, int idEquipo2, int golesEq1, int golesEq2, String descripcion) {
        this.idPartido = idPartido;
        this.idEquipo1 = idEquipo1;
        this.idEquipo2 = idEquipo2;
        this.golesEq1 = golesEq1;
        this.golesEq2 = golesEq2;
        this.descripcion = descripcion;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public int getIdEquipo1() {
        return idEquipo1;
    }

    public void setIdEquipo1(int idEquipo1) {
        this.idEquipo1 = idEquipo1;
    }

    public int getIdEquipo2() {
        return idEquipo2;
    }

    public void setIdEquipo2(int idEquipo2) {
        this.idEquipo2 = idEquipo2;
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

    @Override
    public String toString() {
        return "Partido{" +
                "idPartido=" + idPartido +
                ", idEquipo1=" + idEquipo1 +
                ", idEquipo2=" + idEquipo2 +
                ", golesEq1=" + golesEq1 +
                ", golesEq2=" + golesEq2 +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}

