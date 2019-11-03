/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author peperony
 */
public class Heroe extends Personaje{
    private String aNombreHeroe;
    private String aArchiEnemigo;
    /**
     * Metodo constructor de la clase
     */
    public Heroe(){
        aNombreHeroe = "";
        aArchiEnemigo = "";       
    } 
    /**
    * Método para setear un nombre de villano
    * @param nNombreHeroe que representa el nuevo nombre del personaje.
    */   
    public void setNombreHeroe(String nNombreHeroe){
        aNombreHeroe = nNombreHeroe;
    }
    
    /**
    * Método para setea el archienemigo
    * @param nArchiEnemigo que representa el nombre del archienemigo del villano.
    */ 
    public void setArchiEnemigo(String nArchiEnemigo){
        aArchiEnemigo = nArchiEnemigo;
    }
    
    /**
    * Método para retornar la el nombre del villano
    * @return retorna el nombre del villano 
    */
    public String getNombreHeroe(){
        return aNombreHeroe;
    }
    
    /**
    * Método para retornar el archienemigo del viallano
    * @return retorna el nombre del archienemigo del villano 
    */
    public String getArchiEnemigo(){
        return aArchiEnemigo;
    }
}
