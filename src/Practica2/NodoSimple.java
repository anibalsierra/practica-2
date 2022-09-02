package Practica2;

/**
 *
 * @author wil
 */
public class NodoSimple {

    private Object dato;
    private NodoSimple liga;

    public NodoSimple(Object dato) {
        this.dato = dato;
        this.liga = null;
    }

    public Object retornaDato() {
        return dato;
    }

    public NodoSimple retornaLiga() {
        return liga;
    }

    public void asignaDato(Object dato) {
        this.dato = dato;
    }

    public void asignaLiga(NodoSimple liga) {
        this.liga = liga;
    }

}
