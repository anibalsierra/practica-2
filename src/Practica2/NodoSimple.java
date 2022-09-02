package Practica2;

/**
 *
 * @author beto_
 */
public class NodoSimple {

    private Object dato;
    private NodoSimple liga;

    public NodoSimple(Object dato) {
        this.dato = dato;
        this.liga = null;
    }

    public Object asignaDato() {
        return dato;
    }

    public NodoSimple asignaLiga() {
        return liga;
    }

    public void retornaDato(Object dato) {
        this.dato = dato;
    }

    public void retornaLiga(NodoSimple liga) {
        this.liga = liga;
    }

}
