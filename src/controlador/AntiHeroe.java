/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Tim
 */
public class AntiHeroe extends Personaje{
    private String aAntiHeroe;
    private String aArchiEnemigo;
    
     /**
     * Metodo constructor de la clase
     */
    public AntiHeroe(){
        aAntiHeroe = "";
        aArchiEnemigo = "";
    }
    
    /**
    * Método para setear un nombre de AntiHeroe
    * @param nAntiHeroe que representa el nuevo nombre del personaje.
    */   
    public void setNombreAntiHeroe(String nAntiHeroe){
        aAntiHeroe = nAntiHeroe;
    }
    
    /**
    * Método para setea el archienemigo
    * @param nArchiEnemigo que representa el nombre del archienemigo del Antiheroe.
    */ 
    public void setArchiEnemigo(String nArchiEnemigo){
        aArchiEnemigo = nArchiEnemigo;
    }
    /**
    * Método para retornar la el nombre del Anthiheroe
    * @return retorna el nombre del Antiheroe 
    */
    public String getaNombreAntiheroe(){
        return aAntiHeroe;
    }
    
    /**
    * Método para retornar el archienemigo del Antiheroe
    * @return retorna el nombre del archienemigo del Antiheroe 
    */
    public String getArchiEnemigo(){
        return aArchiEnemigo;
    }
}
