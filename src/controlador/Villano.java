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
public class Villano extends Personaje{
    private String aNombreVillano;
    private String aTipoVillano;
    private String aArchiEnemigo;
    
    public Villano(){
        aNombreVillano = ""; 
        aTipoVillano = "";
        aArchiEnemigo = "";
    } 
    
    /**
    * Método para setear un nombre de villano
    * @param nNombreVillano que representa el nuevo nombre del personaje.
    */   
    public void setNombreVillano(String nNombreVillano){
        aNombreVillano = nNombreVillano;
    }
    
    /**
    * Método para setea el tipo del villano
    * @param nTipoVillano que representa el tipo de villano que es.
    */ 
    public void setTipoVillano(String nTipoVillano){
        aTipoVillano = nTipoVillano;
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
    public String getNombreVillano(){
        return aNombreVillano;
    }
    
    /**
    * Método para retornar el tipo del villano
    * @return retorna el tipo del villano
    */
    public String getTipoVillano(){
        return aTipoVillano;
    }
    
    /**
    * Método para retornar el archienemigo del viallano
    * @return retorna el nombre del archienemigo del villano 
    */
    public String getArchiEnemigo(){
        return aArchiEnemigo;
    }
}
