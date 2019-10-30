/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import javax.imageio.ImageIO;
import java.io.File.*;
import javax.swing.ImageIcon; 

/**
 *
 * @author peperony
 */
public class Imagenes {    
    //Constante para un ancho máximo de imagen
    private final int maxAncho = 900;
    //Constante para un alto máximo de imagen
    private final int maxLargo = 900;
    /**
     * Metodo el cual Mueve un archivo de un fichero a uno ubicado en una carpeta del programa
     * @param nString Ruta de la imagen que se desea mover.
     * @throws Exception 
     */
    public void moverArchivo(String nString) throws Exception {
        
        Path origen = Paths.get(nString);
        
        String direccion = getClass().getResource("/image").getPath();
        
        String nDireccion = (String) direccion.subSequence(1, direccion.length());
        
        Path nPath = Paths.get(nDireccion);
            
        Files.move(origen,nPath.resolve(origen.getFileName()));
        
        System.out.println("Archivo movido con exito");

    }
    
    /**
    * Funcion la cual modifica el tamanio de una image y retrona un ImageIcon
    * @param filePath cadena de caracteres la cual representa la ruta de la imagen.
    * @return 
    */
    public  ImageIcon modificarTamanioImagen(String imagen, int x, int y) {
        ImageIcon image = new ImageIcon(getClass().getResource("/image/"+imagen+".jpg"));
        
        Image conversion = image.getImage();
        
        Image tamanio = conversion.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        
        ImageIcon nFinal =  new ImageIcon(tamanio);
        
        return nFinal;
        
    }
    
    /**
     * Funcion cuando cambia el nombre de un archivo
     * @param nArchivovViejo direccion de la imagen que se desea cambiar el nombre
     * @param nNuevoArchvo nueva direccion donde se desea ingresar el nuevo archivo
     * @return correcto es una variable de tipo bolean la cual representa si se cambia o no el nombre del archivo.
     */
    public boolean cambiarNombre(String nArchivovViejo, String nNuevoArchvo){
        File f1 = new File(nArchivovViejo);
        
        File f2 = new File(nNuevoArchvo);
        
        boolean correcto = f1.renameTo(f2);
  
        return correcto;
    }
}
