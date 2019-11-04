/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.Date;
import javax.swing.JLabel;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author peperony
 */
public class Animacion{
    private static int cont;    
    private JLabel actual;
    private String imagenActual;
    private Imagenes imagenEdit;
    public Animacion(){
        imagenEdit = new Imagenes();
    }

    
    public void correr1() {
        TimerTask cambio;
        int tiempo = 200;
        Timer timer;
        cont = 2;
        cambio = new TimerTask() {
            @Override
            public void run() {
                
                switch (cont) {
                    case 1:
                        actual.setIcon(imagenEdit.modificarTamanioImagen(imagenActual+cont, 210, 230, ".png"));
                        cont = 2;
                        this.cancel();
                        break;
                    case 2:
                        actual.setIcon(imagenEdit.modificarTamanioImagen(imagenActual+cont, 210, 230, ".png"));
                        cont = 3;
                        break;
                    case 3:
                        actual.setIcon(imagenEdit.modificarTamanioImagen(imagenActual+cont, 210, 230, ".png"));
                        cont = 4;
                        break;
                    case 4:
                        actual.setIcon(imagenEdit.modificarTamanioImagen(imagenActual+cont, 210, 230, ".png"));
                        cont = 5;
                        break;
                    case 5:
                        actual.setIcon(imagenEdit.modificarTamanioImagen(imagenActual+cont, 210, 230, ".png"));
                        cont = 1;
                        break;
                }
            }
        };
        timer  = new Timer();
        timer.scheduleAtFixedRate(cambio, new Date(), tiempo);
    }
    
    public void correr2() {
        TimerTask cambio;
        int tiempo = 200;
        Timer timer;
        cont = 2;
        cambio = new TimerTask() {
            @Override
            public void run() {
                
                switch (cont) {
                    case 1:
                        actual.setIcon(imagenEdit.voltearImagen(imagenActual+cont, 210, 230, ".png"));
                        cont = 2;
                        this.cancel();
                        break;
                    case 2:
                        actual.setIcon(imagenEdit.voltearImagen(imagenActual+cont, 210, 230, ".png"));
                        cont = 3;
                        break;
                    case 3:
                        actual.setIcon(imagenEdit.voltearImagen(imagenActual+cont, 210, 230, ".png"));
                        cont = 4;
                        break;
                    case 4:
                        actual.setIcon(imagenEdit.voltearImagen(imagenActual+cont, 210, 230, ".png"));
                        cont = 5;
                        break;
                    case 5:
                        actual.setIcon(imagenEdit.voltearImagen(imagenActual+cont, 210, 230, ".png"));
                        cont = 1;
                        break;
                }
            }
        };
        timer  = new Timer();
        timer.scheduleAtFixedRate(cambio, new Date(), tiempo);
    }
    
    public void correr3() {
        TimerTask cambio;
        int tiempo = 200;
        Timer timer;
        cont = 2;
        cambio = new TimerTask() {
            @Override
            public void run() {
                
                switch (cont) {
                    case 1:
                        actual.setIcon(imagenEdit.voltearImagen(imagenActual, 210, 230, ".png"));
                        cont = 2;
                        this.cancel();
                        break;
                    case 2:
                        actual.setIcon(imagenEdit.modificarTamanioImagen(imagenActual, 210, 230, ".png"));
                        cont = 3;
                        break;
                    case 3:
                        actual.setIcon(imagenEdit.voltearImagen(imagenActual, 210, 230, ".png"));
                        cont = 4;
                        break;
                    case 4:
                        actual.setIcon(imagenEdit.modificarTamanioImagen(imagenActual, 210, 230, ".png"));
                        cont = 5;
                        break;
                    case 5:
                        actual.setIcon(imagenEdit.voltearImagen(imagenActual, 210, 230, ".png"));
                        cont = 6;
                        break;
                    case 6:
                        actual.setIcon(imagenEdit.modificarTamanioImagen(imagenActual, 210, 230, ".png"));
                        cont = 1;
                        break;
                }
            }
        };
        timer  = new Timer();
        timer.scheduleAtFixedRate(cambio, new Date(), tiempo);
    }
    
    public void correr4() {
        TimerTask cambio;
        int tiempo = 200;
        Timer timer;
        cont = 2;
        cambio = new TimerTask() {
            @Override
            public void run() {
                
                switch (cont) {
                    case 1:
                        actual.setIcon(imagenEdit.modificarTamanioImagen(imagenActual, 210, 230, ".png"));
                        cont = 2;
                        this.cancel();
                        break;
                    case 2:
                        actual.setIcon(imagenEdit.voltearImagen(imagenActual, 210, 230, ".png"));
                        cont = 3;
                        break;
                    case 3:
                        actual.setIcon(imagenEdit.modificarTamanioImagen(imagenActual, 210, 230, ".png"));
                        cont = 4;
                        break;
                    case 4:
                        actual.setIcon(imagenEdit.voltearImagen(imagenActual, 210, 230, ".png"));
                        cont = 5;
                        break;
                    case 5:
                        actual.setIcon(imagenEdit.modificarTamanioImagen(imagenActual, 210, 230, ".png"));
                        cont = 6;
                        break;
                    case 6:
                        actual.setIcon(imagenEdit.voltearImagen(imagenActual, 210, 230, ".png"));
                        cont = 1;
                        break;
                }
            }
        };
        timer  = new Timer();
        timer.scheduleAtFixedRate(cambio, new Date(), tiempo);
    }
    
    public void actualizarActual(JLabel nActual,String imagen) {
        actual = nActual;
        imagenActual = imagen;  
    }
}
