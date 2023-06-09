/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;


/**
 *
 * @author admin
 */
public class Ciruja implements Serializable{
    private Carro carros;
    private String especialidad;
    private Calendar fechaIngreso;
    private int id;
    private ArrayList<Material> materiales;
    private String nombre;

    public Ciruja() {
        materiales = new ArrayList<>();
    }

    public Ciruja(String especialidad, Calendar fechaIngreso, int id, ArrayList<Material> materiales, String nombre) {
        this.especialidad = especialidad;
        this.fechaIngreso = fechaIngreso;
        this.id = id;
        this.materiales = materiales;
        this.nombre = nombre;
    }

    public Carro getCarros() {
        return carros;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public Calendar getFechaIngreso() {
        return fechaIngreso;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Material> getMateriales() {
        return materiales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCarros(Carro carros) {
        this.carros = carros;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setFechaIngreso(Calendar fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMateriales(ArrayList<Material> materiales) {
        this.materiales = materiales;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Material juntar(Material material){
        if (especialidad.equals(material.getTipo())){
            double pesoActualCarro = carros.getCargaActual();
            if ((pesoActualCarro + material.getPeso())<=carros.getCapacidad()){
                carros.setCargaActual(pesoActualCarro + material.getPeso());
                materiales.add(material);
                return material;
            }else if (pesoActualCarro < carros.getCapacidad()){
                material.setPeso(carros.getCapacidad()-carros.getCargaActual());
                carros.setCargaActual(carros.getCapacidad());
                materiales.add(material);
                return material;
            }else{
                return null;
            }
        }else{
            System.out.println("Este Ciruja no junta este tipo de material");
            return null;
        }
    }
    
}
