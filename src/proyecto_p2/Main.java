package Proyecto_p2;

import Clases.Cooperativa;
import Jframes.*;
import java.util.ArrayList;
import persistencia.CarroDAO;

public class Main {

    public static Cooperativa cooperativa = new Cooperativa();

    public static void main(String[] args) {
        styledMainFrame main = new styledMainFrame();
        main.setVisible(true);
    }
    
}