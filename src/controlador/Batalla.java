/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author peperony
 */
public class Batalla {
    private final int win = 1;
    private final int loose = 2;
    private final int draw = 3;   
    private final int error = 0;   
    private int tipoDePealea;
    private Personaje aP1;
    private Personaje aP2;    
    private final Random nRandom;
    
    /**
    * Metodo constructos 
    */
    public Batalla(){
        nRandom = new Random();
        aP2 = null;
        aP1 = null;
    }
    
    /**
    * Funcion encargada de resivir el primer personaje a al objeto
    * @param nPersonaje Variable resivida la cual se asigan como el segundo personaje 
    */
    public void setPrimerPersonaje(Personaje nPersonaje){
        aP1 = nPersonaje;
    }
     
    /**
    * Funcion encargada de resivir el segundo personaje a al objeto 
    * @param nPersonaje Variable resivida la cual se asigan como el segundo personaje
    */
    public void setSegundoPersonaje(Personaje nPersonaje){
        aP2 = nPersonaje;
    }
    
    /**
    * Funcion la cual realiza la validacion de los personajes y si el enfrentamiento entre estos es posible.
    * @return retorna el resultado de la batallo o retorna un numero entero representando un error
    */
    public int validacionBatalla(){
        Personaje nPersonaje1 = aP1;
        Personaje nPersonaje2 = aP2;
        if (nPersonaje1 instanceof Heroe && nPersonaje2 instanceof Heroe || 
            nPersonaje1 instanceof AntiHeroe && nPersonaje2 instanceof AntiHeroe ||
            nPersonaje1 instanceof Heroe && nPersonaje2 instanceof AntiHeroe ||
            nPersonaje1 instanceof AntiHeroe && nPersonaje2 instanceof Heroe  ||
            nPersonaje1 instanceof Villano && nPersonaje2 instanceof Villano || nPersonaje1 == null && nPersonaje2 == null
            ){
            System.out.println("Error esta combinacion es invalida ");
            return 696;
        }else {
            System.out.println("Estamos bien ");
            return BatallaEspiritual(nPersonaje1, nPersonaje2);
        }
        
    }
    /**
     * Funcion la cual define el tipo los personajes que se enfrentaran y realiza el enfrentamiento entre ambos. 
     * @param nPersonaje1 reprsenta a un personaje
     * @param nPersonaje2 reprsenta a un personaje
     * @return retorna el resultado de los combates entre el heroe o antiheroe contra el villano
     */
    public int BatallaEspiritual(Personaje nPersonaje1, Personaje nPersonaje2){
           
        if(nPersonaje1 instanceof Heroe){
            Heroe nHeroe = (Heroe) nPersonaje1;
            Villano nVillano = (Villano) nPersonaje2;
            return heroeVsVillano(nHeroe, nVillano);     
        }
        else if (nPersonaje1 instanceof AntiHeroe){
            Villano nVillano = (Villano) nPersonaje2;
            AntiHeroe nAntiHeroe = (AntiHeroe) nPersonaje1;
            return  antiHeroeVsVillano(nAntiHeroe, nVillano);
            
        }else if (nPersonaje1 instanceof Villano && nPersonaje2 instanceof Heroe){
            Heroe nHeroe = (Heroe) nPersonaje1;
            Villano nVillano = (Villano) nPersonaje2;
            return convertirGaneVillano(heroeVsVillano(nHeroe, nVillano));
           
        }else if (nPersonaje1 instanceof Villano && nPersonaje2 instanceof AntiHeroe){
            AntiHeroe nAntiHeroe = (AntiHeroe) nPersonaje1;
            Villano nVillano = (Villano) nPersonaje2;
            return convertirGaneVillano(antiHeroeVsVillano(nAntiHeroe, nVillano));
        }
        //Que deberia de retornar en este caso?
        return 22;
    }
    
    /**
     * Funcion la cual retorna el resultado de un enfrentamiento de cualquier antiheroe con cualquier villano.
     * @param nPersonaje1 reprsenta a un personaje
     * @param nPersonaje2 reprsenta a un personaje
     * @return retorna el calculo de la probabilidad con respecto al factor de definicion. 
     */
    private int antiHeroeVsVillano(Personaje nPersonaje1, Personaje nPersonaje2){
        
        AntiHeroe nAntiHeroe = (AntiHeroe) nPersonaje1;
        Villano nVillano = (Villano) nPersonaje2;
        int nProbabilidad = 50;
        int factorDefinicion = generarRandom();
        
        if(nVillano.getArchiEnemigo().equals(nAntiHeroe.getaNombreAntiheroe())){
            tipoDePealea = 7;
            nProbabilidad = 50;   
        }
        else if(nVillano.getTipoVillano().equals("malvado socialmente")){
            tipoDePealea = 5;
           nProbabilidad += 30;
        }
        else if(nVillano.getTipoVillano().equals("malvado económicamente")){
            tipoDePealea = 3;
            nProbabilidad -=10;
        }       
        nProbabilidad =  calculosPerosnaImportanteAntiheroe(nAntiHeroe,nProbabilidad);
        
        nProbabilidad = calculosPersonaImportanteVillano(nVillano,nProbabilidad);
        
        return retornarProbabilidad( nProbabilidad , factorDefinicion);
    }
    /**
     * Funcion la cual retorna el resultado de un enfrentamiento de cualquier heroe con cualquier villano.
     * @param nPersonaje1 reprsenta a un personaje
     * @param nPersonaje2 reprsenta a un personaje
     * @return retorna el calculo de la probabilidad con respecto al factor de definicion.
     */
    private int heroeVsVillano(Personaje nPersonaje1, Personaje nPersonaje2){
        
        Heroe nHeroe = (Heroe) nPersonaje1;
        Villano nVillano = (Villano) nPersonaje2;
        int nProbabilidad = 50;
        int factorDefinicion = generarRandom();
        
        if(nVillano.getArchiEnemigo().equals(nHeroe.getNombreHeroe())){
            tipoDePealea = 7;
            nProbabilidad = 50;   
        }
        else if(nVillano.getTipoVillano().equals("malvado socialmente")){
            tipoDePealea = 5;
           nProbabilidad -= 10;
        }
        else if(nVillano.getTipoVillano().equals("malvado económicamente")){
            tipoDePealea = 3;
            nProbabilidad +=30;
        }
        nProbabilidad = calculosPerosnaImportanteHeroe(nHeroe,nProbabilidad);
        
        nProbabilidad = calculosPersonaImportanteVillano(nVillano,nProbabilidad);
        
        return retornarProbabilidad(nProbabilidad,factorDefinicion);
    }
    
    /**
     * Funcion la cual retorna la probabilidad despues de que se haya evaluado el estado de la persona importante del Antiheroe
     * @param nAntiHeroe representa a un heroe
     * @param nProbabilidad representa la probabilidad del enfrentamiento
     * @return nProbabilidad variable la cual representa la probabilidad despues de evaluarse el estado de la persona importante del Antiheroe
     */
    private int calculosPerosnaImportanteAntiheroe(AntiHeroe nAntiHeroe, int nProbabilidad){
        if(nAntiHeroe.getEstadoPersonaCercana().equals("Fallecer")){
            if (viveMuere()==1){
                nProbabilidad = nProbabilidad + 20;
            }
            else{
                nProbabilidad = nProbabilidad - 20;
            }
        }else if (nAntiHeroe.getEstadoPersonaCercana().equals("Cooperar")){
            nProbabilidad += 5;
        }
        return nProbabilidad;
    }
    
    /**
     * Funcion la cual retorna la probabilidad despues de que se haya evaluado el estado de la persona importante del heroe
     * @param nHeroe representa a un heroe
     * @param nProbabilidad representa la probabilidad del enfrentamiento
     * @return nProbabilidad variable la cual representa la probabilidad despues de evaluarse el estado de la persona importante del heroe
     */
    private int calculosPerosnaImportanteHeroe(Heroe nHeroe, int nProbabilidad){
        if(nHeroe.getEstadoPersonaCercana().equals("Fallecer")){
            if (viveMuere()==1){
                nProbabilidad = nProbabilidad + 20;
            }
            else{
                nProbabilidad = nProbabilidad - 20;
            }
        }else if (nHeroe.getEstadoPersonaCercana().equals("Cooperar")){
            nProbabilidad += 5;
        }
        return nProbabilidad;
    }
    
    /**
     * Funcion la cual calcula como afectar la persona importante del villano en el calculo de una pelea contra un heroe o Antiheroe
     * @param nVillano representa a un villano
     * @param nProbabilidad representa la probabilidad del enfrentamiento
     * @return nProbabilidad funcion la cual retorna la probabilidad modificada despues de evaluar la el estado de la persona importante del villano.
     */
    private int calculosPersonaImportanteVillano(Villano nVillano, int nProbabilidad){
        if(nVillano.getEstadoPersonaCercana().equals("Fallecer")){
            if (viveMuere()==1){
                nProbabilidad = nProbabilidad - 20;
            }
            else{
                nProbabilidad = nProbabilidad + 20;
            }
        }else if(nVillano.getEstadoPersonaCercana().equals("Cooperar")){
                nProbabilidad -= 10;
        }
        return nProbabilidad;
    }
    
    /** 
    * Funcion la cual retorna la probabilidad de gane de un enfretamiento
    * @param nProbabilidad representa la probabilidad del enfrentamiento
    * @param factorDefinicion representa el valor que se genero para definir cual personaje gana
    * @return win si el jugador de la izquierda gana, loose si pierde y draw si empata
    */
    private int retornarProbabilidad(int nProbabilidad ,int factorDefinicion){
        if(nProbabilidad > factorDefinicion){
            return win;
        }else if(nProbabilidad == factorDefinicion){
            return draw;
        }
        else{
            return loose;
        }
    }   
    
    /**
     * Funcion la cual genera un numero aleatorio entre uno y cien y lo retorna.
     * @return probabilidad variable la cual representa el numero que se designo del random.
     */
    private int generarRandom(){
        int probabilidad = nRandom.nextInt(100);
        return probabilidad;
    }
    
    /**
    * Funcion la cual genera un numero entero aletorio entre uno y dos y lo retorna.
    * @return probabilidad variable la cual representa el numero que se designo del random (1 o 2).
    */    
    private int viveMuere(){
        int probabilidad = nRandom.nextInt(2);
        return probabilidad;
    }

    public static void main(String[]arg){
        AntiHeroe nHeroe = new AntiHeroe();
        Villano nVillano = new Villano();
        Batalla nControl = new Batalla();
        nControl.setPrimerPersonaje(nHeroe);
        nControl.setSegundoPersonaje(nVillano);
        nControl.validacionBatalla();
    }    
    /**
     * Funcion la cual cambia valor del gene con respecto al villano
     * @param nVariable variable la cual sinvoliza el valor resultante del aleatori de la pelea
     * @return nVariable retorna la variable modificada con respecto al villano
     */
    private int convertirGaneVillano(int nVariable){
        if(nVariable == win){
            return loose;
        }
        else if(nVariable == loose){
            return win;
        }
        return nVariable;
        
    }
    /**
     * Funcion la cual retorna el arreglo de viactorias o derrotas 
     * @return  arregloVictoriasDerrotas Retorna una arreglo con la cantidad e victorias y derrotas del personaje izquierdo del lado izquierdo
     */
    public ArrayList retornarArrayAInterfaz(){
        Batalla objetoBatalla;
        
        objetoBatalla = new Batalla();
        
        ArrayList<Integer> arregloVictoriasDerrotas = new ArrayList<>();
        
        int defaultCase = objetoBatalla.validacionBatalla();
        
        int nCase;
        
        arregloVictoriasDerrotas.add(defaultCase);

        for(int i = 0; i < tipoDePealea-1; i++){
            nCase = objetoBatalla.validacionBatalla();
                    
            arregloVictoriasDerrotas.add(nCase);
        }
        
        return arregloVictoriasDerrotas;
    }
}
