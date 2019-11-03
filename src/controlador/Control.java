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
    
    Control () {
        documento = new DocumentXML();
        ciudades = new ArrayList<>();
        batallas = new Batalla();
    }
    
    public void registrarCiudad (double indCriminalidad, String nombreCiudad, String imagen) {
        documento.registrarCiudad(indCriminalidad, nombreCiudad, imagen);
        ArrayList<Ciudad> a = documento.listaCiudades();
        System.out.println(a.toString());
    }
    
    public ArrayList listaCiudades() {
        return documento.listaCiudades();
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

    
}
