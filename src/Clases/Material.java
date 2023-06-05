
package Clases;

import java.io.Serializable;


public class Material implements Serializable {
    private double peso;
    private String tipo;
    private int idExtraccion;

    public Material(double peso, String tipo, int idExtraccion) {
        this.peso = peso;
        this.tipo = tipo;
        this.idExtraccion = idExtraccion;
    }

    public Material() {
    }

    public int getIdExtraccion() {
        return idExtraccion;
    }

    public void setIdExtraccion(int idExtraccion) {
        this.idExtraccion = idExtraccion;
    }

    public double getPeso() {
        return peso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void descuento(){
        if (tipo.equals("papel")){
            peso = peso - ((peso*5)/100);
        }
    }
    
}
