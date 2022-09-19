
package Practica2;

/**
 *
 * @author beto_
 */
public class NodoLg implements NodoGod  {
    
    private Object dato;
    private NodoLg liga;
    private int sw;

    public NodoLg(Object dato) {
        this.dato = dato;
        this.liga = null;
        if(dato == null){
            this.sw = 0;
        } else {
            this.sw = determinarSW(dato);
        }
    }
    private int determinarSW(Object dato){
        int sw;        
        NodoLg nLgAux = new NodoLg(null);        
        //Se verifica si el dato es un átomo o un apuntador hacia una sublista
        if(dato.getClass().equals(nLgAux.getClass())){
            sw = 1;
        } else {
            sw = 0;
        }
        return sw;
    }       
    public int retornaSw(){
        return sw;
    }
    public void asignaSw(int sw){
        this.sw = sw;
    }
     @Override
    public Object retornaDato() {
        return dato;
    }
    @Override
    public NodoGod retornaLiga() {
        return liga;
    }
    @Override
    public void asignaDato(Object dato) {
        this.dato = dato;
    }    
   @Override
    public void asignaLiga(NodoGod liga) {
        this.liga = (NodoLg)liga;
    }
}
