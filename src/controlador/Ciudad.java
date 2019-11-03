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
}
