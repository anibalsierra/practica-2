/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica2;

import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Queue;

/**
 *
 * @author beto_
 */
public class ArbolEneario extends ListaG {
   
    private NodoLg raiz;
    //revisado
    public ArbolEneario(String hilera) {
        int n, i;
        NodoLg primero, ultimo, x;
        Stack pila;
        pila = new Stack();
        primero = new NodoLg(null);
        ultimo = primero;
        primero.asignaDato(hilera.charAt(2 - 1));
        n = hilera.length() - 1;
        // proceso cuando el árbol solo tiene un registro
        if ((n + 1) == 3) {
            this.raiz = primero;
            return;
        }
        // determinar la posición del primero hijo de la raiz si lo tiene
        i = 4 - 1;
        while (i <= n - 2) {
            x = new NodoLg(null);
            ultimo.asignaLiga(x);
            ultimo = x;
            //determinar si el registro procesado siguiente tiene hijos.
            if ((hilera.charAt(i + 1) == '(')) {
                ultimo.asignaSw(1);
                pila.push(ultimo);
                x = new NodoLg(hilera.charAt(i));
                ultimo.asignaDato(x);
                ultimo = x;
                i = i + 2;
            } else {
                ultimo.asignaDato(hilera.charAt(i));
                //determinar si el registro procesado tiene hermanos, hijos o ninguno de los anteriores
                if ((hilera.charAt(i + 1) == ')')) {
                    i = i + 1;
                    //en el while se determina si se acabó de procesar una sublista o la lista al completo
                    while (i < n && (hilera.charAt(i) == (')')) && !pila.empty()) {
                        ultimo = (NodoLg) pila.pop();
                        i = i + 1;
                    }
                    if (hilera.charAt(i) == (',')) {
                        i = i + 1;
                    }
                } else {
                    i = i + 2;
                }
            }
        }
        this.raiz = primero;
    }    
    public ArbolEneario() {
        this.raiz = null;
    }
    {/*public NodoLg retornaRaiz() {
        return this.raiz;
    }*/}
    @Override
    public boolean esVacia() {
        return this.raiz == null;
    }
    @Override
    public NodoGod primerNodo() {
        return raiz;
    }
    //revisado
    public int altura(NodoLg Lg) {
        NodoLg p;
        int g, h;
        h = 1;  
        if (Lg == null) {
            return 0;
        }
        if (Lg.retornaLiga() == null) {
            return 1;
        }
        p = Lg;
        while (p != null) {
            if (p.retornaSw() == 1) {
                g = altura((NodoLg)p.retornaDato()); 
                if (g > h) {
                    h = g;
                }
            }
            p = (NodoLg)p.retornaLiga();
        }
        return h + 1;
    }
    //revisado 
    public void ancestrosDeUnDato(String d) {
        int n = 0;
        char c;
        NodoLg p, q;
        Stack pila = new Stack();
        p = (NodoLg) primerNodo();
        if ((char) p.retornaDato() == d.charAt(0)) {
            System.out.println("el dato es la raiz, por tanto no tiene ancestros");
            return;
        }
        pila.push(p.retornaDato());
        p = (NodoLg) p.retornaLiga();
        while (p != null) {
            if (p.retornaSw() == 0) {
                if ((char) p.retornaDato() == d.charAt(0)) {
                    System.out.println("Los ancestros de \""+d+"\" son:");
                    while (!pila.empty()) {
                        c = (char) pila.pop();
                        System.out.print(c + ", ");
                        if (!pila.empty()) {
                            p = (NodoLg) pila.pop();
                        }
                    }
                    return;
                }
                p = (NodoLg) p.retornaLiga();
            } else {
                q = (NodoLg) p.retornaDato();
                if ((char) q.retornaDato() == d.charAt(0)) {
                    System.out.println("Los ancestros de \""+d+"\" son:");
                    while (!pila.empty()) {
                        c = (char) pila.pop();
                        System.out.print(c + ", ");
                        if (!pila.empty()) {
                            p = (NodoLg) pila.pop();
                        }
                    }
                    return;
                } else {
                    pila.push(p.retornaLiga());
                    pila.push(q.retornaDato());
                    p = (NodoLg) q.retornaLiga();
                }
            }
            while (p == null && !pila.empty()) {
                c = (char) pila.pop();
                p = (NodoLg) pila.pop();
            }
            System.out.println("Dato no está en el árbol");
        }
    }
    //hay que modificar el algoritmo
    public void muestraPorNivel(NodoLg L) {
        Queue cola;
        NodoLg p, q;
        cola = new ConcurrentLinkedQueue();
        p = (NodoLg) primerNodo();
        if (p == null) {
            return;
        }
        while (p != null) {
            if (p.retornaSw() == 0) {
                System.out.println((char) p.retornaDato() + " , ");
            } else {
                q = (NodoLg) p.retornaDato();
                System.out.println((char) q.retornaDato() + " , ");
                cola.add(q.retornaLiga());
            }
            p = (NodoLg) p.retornaLiga();
            while (p == null && !cola.isEmpty()) {
                p = (NodoLg) cola.poll();
            }
        }
    }
    //revisado
    public int gradoDeUnDato(String d) {
        int n = 0;
        NodoLg p, q;
        Stack pila = new Stack();
        p = (NodoLg) primerNodo();
        if ((char) p.retornaDato() == d.charAt(0)) {
            p = (NodoLg)p.retornaLiga();
            while (p != null) {
                n++;
                p = (NodoLg) p.retornaLiga();
            }
            return n;
        }
        p = (NodoLg) p.retornaLiga();
        while (p != null) {
            if (p.retornaSw() == 0) {
                if ((char) p.retornaDato() == d.charAt(0)) {
                    return 0;
                }
                p = (NodoLg) p.retornaLiga();
            } else {
                q = (NodoLg) p.retornaDato();
                if ((char) q.retornaDato() == d.charAt(0)) {
                    p = (NodoLg) q.retornaLiga();
                    while (p != null) {
                        n = n + 1;
                        p = (NodoLg) p.retornaLiga();

                    }
                    return n;
                } else {
                    pila.push(p.retornaLiga());
                    p = (NodoLg) q.retornaLiga();
                }
            }
            while (p == null && !pila.empty()) {
                p = (NodoLg) pila.pop();
            }
        }
        System.out.println("dato no esta en el arbol");
        return 0;
    }
    //algoritmo no funciona, toca rehacer
    public void hojasArbol() {
        Stack pila;
        NodoLg iterador;
        NodoLg primer = null;
        pila = new Stack();
        Stack pilarecorre;
        pilarecorre = new Stack();
        //hay que revisar porque sale null point
        iterador = (NodoLg) primer.retornaLiga();
        while (iterador != null) {
            if (iterador.retornaSw() == 0) {
                if (iterador.retornaLiga() == null && !pilarecorre.empty()) {
                    iterador = (NodoLg) pilarecorre.pop();
                }
            } else if (iterador.retornaSw() == 1) {
                pila.push(iterador);
                pilarecorre.push(iterador);
                iterador = (NodoLg) iterador.retornaDato();
            }

            iterador = (NodoLg) iterador.retornaLiga();
        }
        int hojas = 0;
        while (!pila.empty()) {
            iterador = (NodoLg) pila.pop();
            iterador = (NodoLg) iterador.retornaDato();
            iterador = (NodoLg) iterador.retornaLiga();
            while (iterador != null) {
                if (iterador.retornaSw() == 0) {
                    hojas = hojas + 1;
                    iterador = (NodoLg) iterador.retornaLiga();

                } else if (iterador.retornaSw() == 1) {
                    iterador = (NodoLg) iterador.retornaLiga();
                }
            }
        }
        iterador = (NodoLg) primer.retornaLiga();
        while (iterador != null) {
            if (iterador.retornaSw() == 0) {
                hojas = hojas + 1;
                iterador = (NodoLg) iterador.retornaLiga();

            } else if (iterador.retornaSw() == 1) {
                iterador = (NodoLg) iterador.retornaLiga();
            }
        }
    }
    //algoritmo no funciona, toca rehacer
    public int gradoArbol() {
        NodoLg primer = null;
        Stack pila;
        Stack pilarecorre;
        pila = new Stack();
        pilarecorre = new Stack();
        NodoLg iterador;
        iterador = primer;
        int mayorGrado = 0;
        while (iterador != null) {
            iterador = (NodoLg) iterador.retornaLiga();
            if (iterador.retornaSw() == 0) {
                if (iterador.retornaLiga() == null && !pilarecorre.empty()) {
                    iterador = (NodoLg) pilarecorre.pop();
                } else if (iterador.retornaSw() == 1) {
                    pila.push(iterador);
                    pilarecorre.push(iterador);
                    iterador = (NodoLg) iterador.retornaDato();
                }
            }

        }
        while (!pila.empty()) {
            //revisar el porque nose usa mas la pila 
            iterador = (NodoLg) pila.pop();
            iterador = (NodoLg) pilarecorre.pop();
            iterador = (NodoLg) iterador.retornaLiga();
            int grado = 0;
            while (iterador != null) {
                iterador = (NodoLg) iterador.retornaLiga();
                grado = grado + 1;
            }
            if (grado > mayorGrado) {
                mayorGrado = grado;
            }
        }
        return mayorGrado;

    }
    // esto lo tengo para tener una idea se debe modificar para que funcione con listaLigada
    public void CreacionHileraEnBaseDeNodoLg(NodoLg L, int band) {
        NodoLg p, primero, q;
        Stack pila = new Stack();
        if (L == null) {
            System.out.println("LISTA VACIA");
            return;

        }
        primero = null;
        if (band == 0) {
            System.out.println("(" + L.retornaLiga());
            if (L.retornaLiga() == null) {
                System.out.println(")");
                return;
            }
            System.out.println("(");
            primero = L;
        }
        p = (NodoLg) L.retornaLiga();
        while (p != null) {
            if (p.retornaSw() == 0) {
                System.out.println(p.retornaDato());
            } else {
                q = (NodoLg) p.retornaDato();
                System.out.println(q.retornaDato() + "(");
                CreacionHileraEnBaseDeNodoLg((NodoLg) p.retornaDato(), 1);
            }
            if (p.retornaLiga() != null) {
                System.out.println(",");
            }
            p = (NodoLg) p.retornaLiga();
        }
        System.out.println(")");
        if (primero == L) {
            System.out.println(")");
        }

    }
    {/*
    public void ConstruyeArbol(String hilo){
        int n,i;
        NodoLg primero,ultimo,x;
        Stack pila = new Stack();
        primero = new NodoLg(null);
        ultimo = primero;
        primero.asignaDato(hilo.charAt(2));
        n = hilo.length();
        if(n == 3){
            return;
        }
        i = 4;
        while(i <= n - 2){
            x = new NodoLg(null);
            ultimo.asignaLiga(x);
            ultimo = x;
            if ((hilo.charAt(i + 1) + "").equals("(")){
                ultimo.asignaSw(1);
                pila.push(ultimo);
                x = new NodoLg(hilo.charAt(i));
                ultimo.asignaDato(x);
                ultimo = x;
                i = i + 2;   
            }else{
                ultimo.asignaDato(hilo.charAt(i));
                if((hilo.charAt(i + 1) + "").equals(")")){
                    i = i + 1;
                    while(1<n && (hilo.charAt(i) + "").equals(")") && !pila.empty()){
                        ultimo = (NodoLg)pila.pop();
                        i = i + 1;
                    }
                    if((hilo.charAt(i) + "").equals(",")){
                        i = i + 1;
                    }else{
                        i = i + 2;
                    }
                    
                }
                
            }
        }
        
    }
         */
    }
}