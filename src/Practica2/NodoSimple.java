
package Practica2;

/**
 *
 * @author beto_
 */
public class NodoSimple implements NodoGod {

    private Object dato;
    private NodoSimple liga;

    public NodoSimple(Object dato) {
        this.dato = dato;
        this.liga = null;
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
        this.liga = (NodoSimple)liga;
    }
}
