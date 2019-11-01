/**
 * @author Tim Scarlith H.
 * @author Josué Torre N.
 * @version 1.0
 */
package controlador;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon; 
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
     * @param imagen Un string del nombre de la imagen
     * @param x Un entero de lo alto de la imagen
     * @param y Un entero de el ancho de la imagen
     * @param fichero Un string de la extención de la imagen
     * @return Un ImageIcon con el tamaño esperado
    */
    public  ImageIcon modificarTamanioImagen(String imagen, int x, int y, String fichero) {
        ImageIcon image = new ImageIcon(getClass().getResource("/image/"+imagen+fichero));
        
        Image conversion = image.getImage();
        
        Image tamanio = conversion.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        
        ImageIcon nFinal =  new ImageIcon(tamanio);
        
        return nFinal;
        
    }
    
    public ImageIcon voltearImagen (String imagen, int x, int y, String fichero) throws IOException {
        BufferedImage  temp;
        temp = ImageIO.read(new File (getClass().getResource("/image/"+imagen+fichero).getPath()));
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-temp.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        temp = op.filter(temp, null);
        ImageIcon image = new ImageIcon(temp);
        Image image1 = image.getImage();
        image1 = image1.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        return  new ImageIcon(image1);

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
