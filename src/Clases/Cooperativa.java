
package Clases;

import java.util.ArrayList;


public class Cooperativa {
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
    
    public void liquidar(Material material){
        double precioCarton,precioVidrio, precioMetal, precioPapel, paga;
        precioCarton = 10;
        precioVidrio = 20;
        precioMetal = 25;
        precioPapel = 7;
        paga = 0;
        switch(material.getTipo()){
            case "carton":
                paga = material.getPeso()*precioCarton;
            case "vidrio":
                paga = material.getPeso()*precioVidrio;
            case "metal":
                paga = material.getPeso()*precioMetal;
            case "papel":
                paga = material.getPeso()*precioPapel;
        }
        System.out.println("Se ha pagado un total de $"+paga);
    }
    public void nuevoCarro(int n){
        System.out.println("Nuevo carro obtenido");
        Carro c = new Carro();
        c.setCargaActual(0);
        c.setId(n);
        System.out.println("ID: "+c.getId()+"Capacidad máxima: "+c.getCapacidad()+"Carga actual: "+c.getCargaActual());
        carros.add(c);
    }
}
