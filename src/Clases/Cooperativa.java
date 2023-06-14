package Clases;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import persistencia.*;

public class Cooperativa implements Serializable {

    public MaterialDAO MaterialDAO = new MaterialDAO();
    private ArrayList<Carro> carros;
    private ArrayList<Ciruja> cirujas;

    public Cooperativa() {
        carros = new ArrayList<Carro>();
        cirujas = new ArrayList<Ciruja>();
    }

    public Cooperativa(ArrayList<Carro> carros, ArrayList<Ciruja> cirujas) {
        this.carros = carros;
        this.cirujas = cirujas;
    }

    public ArrayList<Carro> getCarros() {
        return carros;
    }

    public ArrayList<Ciruja> getCirujas() {
        return cirujas;
    }

    public void setCarros(ArrayList<Carro> carros) {
        this.carros = carros;
    }

    public void setCirujas(ArrayList<Ciruja> cirujas) {
        this.cirujas = cirujas;
    }

    public double liquidar(int n) {
        double precioVidrio, precioPapel, precioMetal;
        //pongo los precios para cada material por kg
        precioVidrio = 15;
        precioPapel = 10;
        precioMetal = 20;
        double sueldo = 0;
        double descuento = 0;

        //Recorro el array de materiales que tiene el ciruja y verifico que tipo es para acumularlo en el sueldo
        for (int i = 0; i < cirujas.get(n).getMateriales().size(); i++) {
            System.out.println(cirujas.get(n).getMateriales().get(i).getTipo().toLowerCase());
            switch (cirujas.get(n).getMateriales().get(i).getTipo().toLowerCase()) {
                case "cartón y papel":
                    cirujas.get(n).getMateriales().get(i).descuento();
                    sueldo += (cirujas.get(n).getMateriales().get(i).getPeso() * precioPapel);
                    break;
                case "carton y papel":
                    cirujas.get(n).getMateriales().get(i).descuento();
                    sueldo += (cirujas.get(n).getMateriales().get(i).getPeso() * precioPapel);
                    break;
                case "papel":
                    cirujas.get(n).getMateriales().get(i).descuento();
                    sueldo += (cirujas.get(n).getMateriales().get(i).getPeso() * precioPapel);
                    break;
                case "cartón":
                    cirujas.get(n).getMateriales().get(i).descuento();
                    sueldo += (cirujas.get(n).getMateriales().get(i).getPeso() * precioPapel);
                    break;
                case "carton":
                    cirujas.get(n).getMateriales().get(i).descuento();
                    sueldo += (cirujas.get(n).getMateriales().get(i).getPeso() * precioPapel);
                    break;
                case "vidrio":
                    sueldo += (cirujas.get(n).getMateriales().get(i).getPeso() * precioVidrio);
                    break;
                case "metales":
                    sueldo += (cirujas.get(n).getMateriales().get(i).getPeso() * precioMetal);
                    break;
                case "metal":
                    sueldo += (cirujas.get(n).getMateriales().get(i).getPeso() * precioMetal);
                    break;
            }
        }
        
        LocalDate actual = LocalDate.now();
        int aniosTrabajados = actual.getYear() - cirujas.get(n).getFechaIngreso().get(Calendar.YEAR);
        if (aniosTrabajados <= 10) {
            descuento = 10 - aniosTrabajados;
        } else {
            descuento = 0;
        }
        sueldo = sueldo - ((sueldo*descuento)/100);
        
        cirujas.get(n).setMateriales(new ArrayList<>());
        try {
            MaterialDAO.deleteAll(cirujas.get(n).getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("sueldo final: " + sueldo);
        return sueldo;
    }
    
//    public double

    public Carro nuevoCarro(int n) {
        System.out.println("Nuevo carro obtenido");
        Carro c = new Carro();
        c.setCargaActual(0);
        c.setId(carros.size() + 1);
        System.out.println("Ciruja: " + cirujas.get(n).getNombre() + "\nID: " + c.getId() + "\nCapacidad máxima: " + c.getCapacidad() + "\nCarga actual: " + c.getCargaActual());
        cirujas.get(n).setCarros(c);
        carros.add(c);
        return c;
    }
}
