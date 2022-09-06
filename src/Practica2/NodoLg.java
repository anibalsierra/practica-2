/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica2;

/**
 *
 * @author beto_
 */
public class NodoLg  {
    
    private Object dato;
    private NodoSimple liga;
    private int sw;

    public NodoLg(Object dato) {
        this.dato = dato;
        this.liga = null;
        this.sw = 0;
    }
    public Object retornaDato() {
        return dato;
    }
    public NodoSimple retornaLiga() {
        return liga;
    }
    public int retornaSw(){
        return sw;
    }
    public void asignaSw(int sw){
        this.sw = sw;
    }
    public void asignaDato(Object dato) {
        this.dato = dato;
    }
    public void asignaLiga(NodoSimple liga) {
        this.liga = liga;
    }
    
}
