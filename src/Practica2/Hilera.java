/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica2;


/**
 *
 * @author beto_
 */
public class Hilera extends LSL {
    
    //En proceso.
    public int longitud(){
        return 0; //trababo en proceso
    }
    public Hilera subHilera(int i, int j){
        int k, n;
        Hilera s;
        NodoGod p;
        n = longitud();
        if(i<1||i>n){
            System.out.println("parámetro no válido");
            return null;
        }
        if(j<1||j>n-i+1){
            System.out.println("parámetro no válido");
            return null;
        }
        p = primerNodo();
        k=1;
        s = new Hilera();
        while(k<i){
            p = p.retornaLiga();
            k++;
        }
        k=1;
        while(k<=j){
            s.insertar(p.retornaDato(), s.ultimoNodo());
            p=p.retornaLiga();
            k++;
        }
        return s;        
    }
    private Hilera copiaHilera(){
        Hilera s;
        NodoGod p;
        p = primerNodo();
        s = new Hilera();
        while(!finDeRecorrido(p)){
            s.insertar(p.retornaDato(),s.ultimoNodo());
            p = p.retornaLiga();            
        }
        return s;     
    }
    public Hilera concat(Hilera s){
        Hilera t;
        NodoGod p;
        t = copiaHilera();
        p = t.primerNodo();
        while(!finDeRecorrido(p)){
            s.insertar(p.retornaDato(), s.ultimoNodo());
            p=p.retornaLiga();
        }
        return s;
    }
    public void inserta(Hilera s, int j){
    }
    public void borra(int i, int j){
    }
    public void replace(int i, int j, Hilera s){
    }
    public NodoGod retornaNodoEnPosicion(Hilera s){
        NodoGod p, pp, q;
	p = primerNodo();
	pp = p;
	q = s.primerNodo();
	while(!finDeRecorrido(p) && !s.finDeRecorrido(q)){
		if(p.retornaDato()==q.retornaDato()){
			p = p.retornaLiga();
			q = q.retornaLiga();
			if(s.finDeRecorrido(q)){
				return pp;
			}
		} else {
				pp = pp.retornaLiga();
				p = pp;
				q = s.primerNodo();
		}
	}
	return null;
    }
    public int posicion(Hilera s){
        return 0; //trabajo en proceso.
    }
}
