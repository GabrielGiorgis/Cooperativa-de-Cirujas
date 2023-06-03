
package Clases;


public class Material {
    private double peso;
    private String tipo;

    public Material(double peso, String tipo) {
        this.peso = peso;
        this.tipo = tipo;
    } 

    public Material() {
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
