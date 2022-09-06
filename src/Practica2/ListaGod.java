/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Practica2;

/**
 *
 * @author beto_
 */
public interface ListaGod {
    public boolean esVacia();
    public NodoGod primerNodo();
    public NodoGod ultimoNodo();
    public NodoGod anterior(NodoGod x);
    public boolean finDeRecorrido(NodoGod x);
    public void recorre();
    public NodoGod buscaDondeInsertar(Object d);
    public void insertar(Object d, NodoGod y);
    public void conectar(NodoGod x, NodoGod y);
    public NodoGod buscarDato(Object d, NodoGod y);
    public void borrar(NodoGod x, NodoGod y);
    public void desconectar(NodoGod x, NodoGod y);
    public void ordenarAscendentemente();
}
