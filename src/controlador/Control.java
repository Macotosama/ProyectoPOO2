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
public class Control {
    private DocumentXML documento;
    private ArrayList<Ciudad> ciudades;
    private Batalla batallas;
    private Personaje P1;
    private Personaje P2;
    
    Control () {
        documento = new DocumentXML();
        ciudades = new ArrayList<>();
        batallas = new Batalla();
    }
    
    public ArrayList buscarEnciudadHeore(String ciudad) {
        ArrayList<Heroe> personas = new ArrayList<>();
        for (int i = 0; i < ciudades.size(); i++) {
            if (ciudad.equals(ciudades.get(i).getNombre())) {
                personas = ciudades.get(i).getHeroes();
                break;
            }
        }
        return personas;
    }
    
    public ArrayList buscarEnCiudadAntiHeroe (String ciudad) {
        ArrayList<Personaje> personas = new ArrayList<>();
        for (int i = 0; i < ciudades.size(); i++) {
            if (ciudad.equals(ciudades.get(i).getNombre())) {
                personas = ciudades.get(i).getAntiHeroes();
                break;
            }
        }
        return personas;
    }
    public ArrayList buscarEnciudadVillano (String ciudad) {
        ArrayList<Personaje> personas = new ArrayList<>();
        for (int i = 0; i < ciudades.size(); i++) {
            if (ciudad.equals(ciudades.get(i).getNombre())) {
                personas = ciudades.get(i).getVillanos();
                break;
            }
        }
        return personas;
    }
    
    public void registrarCiudad (double indCriminalidad, String nombreCiudad, String imagen) {
        documento.registrarCiudad(indCriminalidad, nombreCiudad, imagen);
        ArrayList<Ciudad> a = documento.listaCiudades();
        System.out.println(a.toString());
    }
    
    public ArrayList listaCiudades() {
        ciudades = documento.listaCiudades();
        return ciudades;
    }
    
    public boolean registrarHeroe(String pNombre, int pEdad, String pSexo, float pAltura, String pCiudadOrigen, 
        String pNombreCiudad,String pOcupacion, String pOrientacionSexual,String pPersonaCercana, 
        String pImg, int pID, String pNombreHeroe, String pArchiEnemigo){
        
        Personaje nPersonacercana = new Personaje();
        nPersonacercana.setNombre(pPersonaCercana);
        
        documento.registrarHeroe(pNombre, pEdad, pSexo, pAltura, pCiudadOrigen, pNombreCiudad, pOcupacion, pOrientacionSexual, nPersonacercana, pImg, pID, pNombreHeroe, pArchiEnemigo);
        return true; 
    }
    
    public boolean registrarAntiHeroe(String pNombre, int pEdad, String pSexo, float pAltura, String pCiudadOrigen, String pNombreCiudad,
            String pOcupacion, String pOrientacionSexual,String pPersonaCercana, String pImg, int pID, String pNombreAntiHeroe, String pArchiEnemigo){
            
            Personaje nPersonacercana = new Personaje();
            nPersonacercana.setNombre(pPersonaCercana);
        
            documento.registrarAntiHeroe(pNombre, pEdad, pSexo, pAltura, pCiudadOrigen, pNombreCiudad, pOcupacion, pOrientacionSexual, nPersonacercana, pImg, pID, pNombreAntiHeroe, pArchiEnemigo);
        return true; 
    }
    
    public boolean registrarVillano(String pNombre, int pEdad, String pSexo, float pAltura, String pCiudadOrigen, String pNombreCiudad,
        String pOcupacion, String pOrientacionSexual,String pPersonaCercana, String pImg, int pID, String pNombreVillano, String pArchiEnemigo){
        
            Personaje nPersonacercana = new Personaje();
            nPersonacercana.setNombre(pPersonaCercana);
        
        documento.registrarVillano(pNombre, pEdad, pSexo, pAltura, pCiudadOrigen, pNombreCiudad, pOcupacion, pOrientacionSexual, nPersonacercana, pImg, pID, pNombreVillano, pArchiEnemigo);
        return true;
    }
    
    
    
    public ArrayList<Integer> retornarPelea(Personaje nP1, Personaje nP2){
        batallas.setPrimerPersonaje(nP1);
        batallas.setSegundoPersonaje(nP2);
        ArrayList<Integer> retornarArrayAInterfaz;
        retornarArrayAInterfaz =  batallas.retornarArrayAInterfaz();
        return retornarArrayAInterfaz;
    }

/**
     * Funcion la cual cambia el esrtado de una perosna cercana a un personaje
     * @param nEstado variable la cual representa el nuevo estado de la persona cecana al personaje
     * @param pPersonaje el personaje al cual se le desea hacer el cambio del estado de la persona cercana 
     * @return retorna un valor boleano true;
     */
    public boolean seleccionarEstado(String nEstado, Personaje pPersonaje){
        Personaje nPersonaje  = pPersonaje.getPersonaCercana();
        
        nPersonaje.setEstadoPersonacerna(nEstado);
        
        return true;
        
    }

/**
     * Funcion la cual retorna el resulatado de la pelea 
     * @param nP1 Un personaje
     * @param nP2 Un personaje
     * @return nVar variable la cual representa el resultado de la pelea del personaje izquierdo 
     */
    public int retornarPelea2(Personaje nP1, Personaje nP2){
        
        batallas.setPrimerPersonaje(nP1);
        
        batallas.setSegundoPersonaje(nP2);
        
        int nVar =  batallas.validacionBatalla();
        
        return nVar;   
    }    
}
