/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica2;

/**
 *
 * @author beto_
 */
public class ListaG extends LSL {
    private NodoLg primero;
    private NodoLg ultimo;
    
    //Constructor
    @Override
    public boolean esVacia() {
        return primero == null;
    }
    @Override
    public NodoGod primerNodo() {
        return primero;
    }
    @Override
    public NodoGod ultimoNodo() {
        return ultimo;
    }
     @Override
    public void insertar(Object d, NodoGod y) {
        NodoGod x;
        x = new NodoLg(d);
        conectar(x, y);
    }
    @Override
    public void conectar(NodoGod x, NodoGod y) {
        if (y != null) {
            x.asignaLiga(y.retornaLiga());
            y.asignaLiga(x);
            if (y.equals((NodoGod)ultimo)) {
                ultimo = (NodoLg)x;

            } else {
                x.asignaLiga(primero);
                if (primero == null) {
                    ultimo = (NodoLg)x;
                }
                primero = (NodoLg)x;
            }

        }
    }
    @Override
    public void desconectar(NodoGod x, NodoGod y) {
        if (!x.equals((NodoGod)primero)) {
            y.asignaLiga(x.retornaLiga());
            if (x.equals((NodoGod)ultimo)) {
                ultimo = (NodoLg)y;
            } else {
                primero = (NodoLg)primero.retornaLiga();
                if (primero == null) {
                    ultimo = null;
                }
            }
        }
    }
}
