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
public class Personaje {
    private int aEdad;
    private String aNombre;
    private String aSexo;
    private double aAltura;
    private String aCiudadOrigen;
    private String aOCupacion;
    private String aOrientacionSexual;
    private Personaje aPersonasercana;
    private String aEstadoPersonacercana;
    private int aID;
    private int aCantidadEventosPerdidos;
    private int aCantidadEventosGanados;

     /**
     * Método para inicializador
     * 
     */
    public Personaje(){
        aEdad = 0;
        aNombre = "";
        aSexo = "";
        aAltura = 0;
        aCiudadOrigen = "";
        aOCupacion = "";
        aOrientacionSexual = "";
        aID = 0;
        aPersonasercana = null;
        aEstadoPersonacercana = "";
        aCantidadEventosPerdidos  = 0;
        aCantidadEventosGanados = 0;
    }
    
    /**
     * Método para setear una nueva Edad
     * @param nEdad parametro el cual representa la nueva edad del personaje
     */
    public void setEdad(int nEdad){
        aEdad = nEdad;
    }
    /**
     * Funcionla cual setea la cantidad de eventos perdidos
     * @param nCantidadPerdidos El numero de eventos perdidos
     */
    public void setCantidadEventosPerdidos(int nCantidadPerdidos){
        aCantidadEventosPerdidos = nCantidadPerdidos;
    }
    
    /**
     * Funcion la cual setea la cantidad de eventos ganados
     * @param nCantidadEventosGanados cantidad de eventos ganados
     */
    public void setCantidadEventosGanados(int nCantidadEventosGanados){
        aCantidadEventosGanados  = nCantidadEventosGanados;
    }
    
    /**
    * Método para setear una nuevo nombre
    * @param nNombre  parametro el cual representa el nuevo nombre del personaje
    */
    public void setNombre(String nNombre){
        aNombre = nNombre;
    }
    
    /**
    * Método para setear una nuevo estado de la persona cercana nombre
    * @param nEstado prametro el cual representa el estado de la persona cercana al personaje
    */
    public void setEstadoPersonacerna(String nEstado){
        aEstadoPersonacercana = nEstado;
    }
    
    /**
    * Método para setear un sexo al personaje
    * @param nSexo parametro el cual representa el nuevo sexo del nombre del personaje
    */
    public void setSexo(String nSexo){
        aSexo = nSexo;
    }
    
    /**
    * Método para setear la altura de un personaje
    * @param nAltura parametro que representa la altura nueva del personaje
    */
    public void setAltura(double nAltura){
        aAltura = nAltura;
    }
    
    /**
    * Método para setear la altura de un personaje
    * @param nCiudadOrigen parametro que representa la nueva ciudad de origen del personaje
    */
    public void setCiudadOrigen(String nCiudadOrigen){
        aCiudadOrigen = nCiudadOrigen;
    }
    
    /**
    * Método para setear la una nueva ocupacion.
    * @param nOcupacion parametro que representa la nueva ciudad de origen del personaje
    */
    public void setOCupacion(String nOcupacion){
        aOCupacion = nOcupacion;
    }
    
    /**
    * Método para setear la orientacion sexual.
    * @param nOrientacionSexual parametro que representa la nueva orientacion sexual del personaje.
    */
    public void setOrientacionSexual(String nOrientacionSexual){
        aOrientacionSexual = nOrientacionSexual;
    }
    
    /**
    * Método para setear un personaje.
    * @param nPersonasercana que representa la  nueva persona cercana.
    */
    public void aPersonasercana(Personaje nPersonasercana){
        aPersonasercana = nPersonasercana; 

    }
    
    /**
    * Método para setear un nuevo identificador
    * @param nID  que representa el nuevo identificador del personaje.
    */    
    public void setID(int nID){
        aID = nID;
    }
    
    
    /**
     * Método para retornar la Edad
     * @return retorna la edad del personaje. 
     */
    public int getEdad(){
        return aEdad;
    }
    
    
    /**
     * Método para retornar el nombre
     * @return retorna el nombre del personaje. 
     */
    public String getNombre(){
        return aNombre;
    }
        
    /**
    * Método para retornar el sexo del perosnaje
    * @return retorna el sexo del perosnaje
    */
    public String getSexo(){
       return  aSexo;
    }
    
    /**
    * Método para retornar la altura del perosnaje
    * @return retorna la altura del personaje 
    */
    public double getAltura(){
        return aAltura;
    }
    
    /**
    * Método para retornar la altura el estado de la perosna cercana al perosnaje
    * @return retorna el estado de la persona cercana al personaje 
    */
    public String getEstadoPersonaCercana(){
        return aEstadoPersonacercana;
    }
   
    /**
    * Método para retornar la ciudad de origen
    * @return retorna la ciudad de origen del personaje 
    */
    public String getCiudadOrigen(){
        return aCiudadOrigen;
    }
    
    /**
    * Método para retornar la ocupacion del personaje
    * @return retorna la ocupacion del personaje 
    */
    public String getOCupacion(){
        return aOCupacion;
    }
   
    /**
    * Método para retornar la orientacin sexual del personaje
    * @return retorna la orientacion sexual del personaje 
    */
    public String getOrientacionSexual(){
        return aOrientacionSexual;
    }
    
    /**
    * Método para retornar la persona cercana.
    * @return retorna la persona cercana del personaje 
    */
    public Personaje getPersonaCercana(){
        return aPersonasercana;
    }
   
    /**
     * Funcion la cual retorna la cantidad de enventos perdidos por un usuario
     * @return return aCantidadEventosPerdidos variable que representa la cantidad de enventos perdidos por el usuario
     */
    public int getEventosPerdidos(){
        return aCantidadEventosPerdidos;
    } 
    
    /**
     * Funcion la cual retorna la cantidad de enventos ganados por un usuario
     * @return aCantidadEventosGanados variable que representa la cantidad de enventos ganados por el usuario
     */
    public int getEventosGanados(){
        return aCantidadEventosGanados;
    }
    /**
    * Método para retornar el identificador 
    * @return retorna el id personaje 
    */
    public int getID(){
        return aID;
    }
}
