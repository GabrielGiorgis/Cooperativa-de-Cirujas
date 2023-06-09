package Clases;

import java.io.Serializable;
import java.util.ArrayList;
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

        //Recorro el array de materiales que tiene el ciruja y verifico que tipo es para acumularlo en el sueldo
        for (int i = 0; i < cirujas.get(n).getMateriales().size(); i++) {
            switch (cirujas.get(n).getMateriales().get(i).getTipo().toLowerCase()) {
                case "vidrio":
                    sueldo += (cirujas.get(n).getMateriales().get(i).getPeso() * precioVidrio);
                case "papel":
                    sueldo += (cirujas.get(n).getMateriales().get(i).getPeso() * precioPapel);
                case "metal":
                    sueldo += (cirujas.get(n).getMateriales().get(i).getPeso() * precioMetal);
            }
        }
        cirujas.get(n).setMateriales(new ArrayList<>());
        try {
            MaterialDAO.deleteAll(cirujas.get(n).getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sueldo;
    }

    public Carro nuevoCarro(int n) {
        n = n - 1;
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
