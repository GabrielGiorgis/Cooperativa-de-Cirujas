
package Clases;

import java.util.ArrayList;


public class Cooperativa {
    private ArrayList<Carro> carros;
    private ArrayList<Ciruja> cirujas;

    public Cooperativa() {
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
    
    public void liquidar(int n){
        
    }
    public void nuevoCarro(int n){
        
    }
}
