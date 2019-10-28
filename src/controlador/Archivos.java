/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author peperony
 */
public class Archivos {
    public Archivos () {}
    
    public void moverImagen (String imagen, String destino) {
        Path origen = Paths.get(imagen);
        destino = getClass().getResource("/image").getPath();
        System.out.println(destino);
        //Path nPath = Paths.get(getClass().getResource());
    }
}
