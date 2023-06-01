/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;
import java.util.Calendar;


/**
 *
 * @author admin
 */
public class Ciruja {
    private Carro carros;
    private String especialidad;
    private Calendar fechaIngreso;
    private int id;
    private ArrayList<Material> materiales;
    private String nombre;

    public Ciruja() {
    }

    public Ciruja(Carro carros, String especialidad, Calendar fechaIngreso, int id, ArrayList<Material> materiales, String nombre) {
        this.carros = carros;
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
    
    public void juntar(Material material, double n){
        double pesoActualCarro = n;
        if ((pesoActualCarro + material.getPeso())<=carros.getCapacidad()){
            carros.setCapacidadActual(pesoActualCarro + material.getPeso());
            System.out.println("Se cargaron "+material.getPeso()+"kgs, peso actual del carro "+carros.getCapacidadActual());
        }else if (pesoActualCarro < carros.getCapacidad()){
            double suma = pesoActualCarro + material.getPeso();
            material.setPeso(suma- carros.getCapacidad());
            carros.setCapacidadActual(carros.getCapacidad());
            System.out.println("No se pudo cargar todo el material, quedo sin recoger "+material.getPeso()+"kgs, peso actual del carro "+ carros.getCapacidadActual()+"kgs" );
        }else{
            System.out.println("No se pueden cargar mas materiales, el material encontrado se quedara en su lugar");
        }
        
    }
}
