/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author admin
 */
public class Carro {
    private static int capacidad = 200;
    private int id;
    private double cargaActual;

    public Carro() {
    }

    public Carro(int id, int capacidadActual) {
        this.id = id;
        this.cargaActual = capacidadActual;
    }

    public double getCargaActual() {
        return cargaActual;
    }

    public static void setCapacidad(int capacidad) {
        Carro.capacidad = capacidad;
    }

    public void setCargaActual(double capacidadActual) {
        this.cargaActual = capacidadActual;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
