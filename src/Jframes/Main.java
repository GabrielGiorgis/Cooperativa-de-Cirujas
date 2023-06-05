package Jframes;

import Clases.Cooperativa;
import java.util.ArrayList;
import persistencia.CarroDAO;

public class Main {

    static Cooperativa cooperativa = new Cooperativa();

    public static void main(String[] args) {
        styledMainFrame main = new styledMainFrame();
        main.setVisible(true);
    }
    
}
