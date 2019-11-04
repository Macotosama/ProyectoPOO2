/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.ArrayList;
/**
 *
 * @author peperony
 */
public class Ciudad {
    private ArrayList<Heroe> aHeroes;
    private ArrayList<AntiHeroe> aAntiHeroes;
    private ArrayList<Villano> aVillanos;
    private double aIndiceCriminalidad;
    private String aNombre;
    
    /**
     * Metodo constructor 
     */
    public Ciudad(){
        aHeroes = new ArrayList<>();
        aAntiHeroes = new ArrayList<>();
        aVillanos = new ArrayList<>();
        aIndiceCriminalidad = 0;
        aNombre = "";
    }
    
    /**
     * Funcion la cual setea el nuevo arreglo de antiheroes
     * @param nArregloAntiHeroe Varible la cual representa el nuevo arreglo de antiheroes
     */
    public void setAntiheroes( ArrayList<AntiHeroe> nArregloAntiHeroe){
        aAntiHeroes = nArregloAntiHeroe;
    }
    
        /**
     * Funcion la cual setea el nuevo arreglo de Heroes
     * @param nArregloHeroe Varible la cual representa el nuevo arreglo de heroes
     */
    public void setHeroes( ArrayList<Heroe> nArregloHeroe){
        aHeroes = nArregloHeroe;
    }
    
            /**
     * Funcion la cual setea el nuevo arreglo de villanos
     * @param nArregloVillanos Varible la cual representa el nuevo arreglo de villanos
     */
    public void setVillanos( ArrayList<Villano> nArregloVillanos){
        aVillanos = nArregloVillanos;
    }
    
    /**
    * Método para setear el nombre de la ciudad
    * @param nNombre que representa el nombre de la ciudad
    */
    public void setNombre(String nNombre){
        aNombre = nNombre;
    }
    
    /**
    * Método para setear el indice de criminalidad de la ciudad
    * @param nIndiceCriminalidad que representa el indice de criminalidad de la ciudad
    */  
    public void setIndiceCriminalidad(double nIndiceCriminalidad){
        aIndiceCriminalidad = nIndiceCriminalidad;
    }
    
    /**
    * Método para agregar un villano
    * @param nVillano que representa el nuevo villano que se ingresara a la lista.
    */ 
    public void addVillanos(Villano nVillano){
        aVillanos.add(nVillano);
    }
    
    /**
    * Método para agregar un nHeroe
    * @param nHeroe que representa el nuevo nHeroe que se ingresara a la lista.
    */   
    public void addHeroe(Heroe nHeroe){
        aHeroes.add(nHeroe);
    }
    
    /**
    * Método para agregar un antiheroe
    * @param nAntiHeroe que representa el nuevo antiheroe que se ingresara a la lista.
    */   
    public void addAntiHeroe(AntiHeroe nAntiHeroe){
        aAntiHeroes.add(nAntiHeroe);
    }
    
    /**
     * Devuelve el nombre de la ciudad
     * @return El nombre de la ciudad
     */
    public String getNombre () {
        return aNombre;
    }
    
    public ArrayList getHeroes () {
        return aHeroes;
    }
    
    public ArrayList getVillanos () {
        return aVillanos;
    }
    
    public ArrayList getAntiHeroes () {
        return aAntiHeroes;
    }
}
