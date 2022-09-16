/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica2;

/**
 *
 * @author beto_
 */
public class ArbolEneario {
    
    public int altura(nodoLg L) {
        nodoLg p;
        int g, h;
        h = 1;
        if (L == null) {
            return 0;
        }
        if (L.retornliga() == null) {
            return 1;
        }
        p = L;
        while (p != null) {
            if (p.retornSw() == 1) {
                g = altura((nodoLg) p.retornaDato());
                if (g > h) {
                    h = g;
                }
            }
            p = p.retornLiga();
        }
        return h + 1;
    }

    public void ancestrosDeUnDato(String d) {
        int n = o;
        char c;
        nodoLg p, q;
        Stack pila = new Stack();
        p = primerNodo();
        if ((char) p.retornaDato() == d.charAt(0)) {
            System.out.println("el dato es la raiz, por tanto no tiene ancestros");
            return;
        }
        pila.apilar(p.retornaDato());
        p = p.retornaLiga();
        while (p != null) {
            if (p.retornSw() == 0) {
                if ((char) p.retornDato() == d.charAt(0)) {
                    System.out.println("Los ancestros de " + d + " son");
                    while (!pila.esVacia()) {
                        c = (char) pila.desapilar();
                        System.out.println(c + "");
                        if (!pila.esVacia()) {
                            p = (nodoLg) pila.desapilar();
                        }
                    }
                    return;
                }
                p = p.retornLiga();
                else
                q = (nodoLg)p.retornaDato();
                if ((char) q.retornaDato() == d.charAt(0)) {
                    System.out.println("Los ancestros de " + d + " son");
                    while (!pila.esVacia()) {
                        c = (char) pila.desapilar();
                        System.out.println(c + "");
                        if (!pila.esVacia()) {
                            p = (nodoLg) pila.desapilar();
                        }
                    }
                    return;
                    else 
                    pila.apilar(p.retornaLiga());
                    pila.apilar(q.retornaDato());
                    p = q.retornaLiga();

                }
            }
            while (p == null && !pila.esVacia()) {
                c = (char) pila.desapilar();
                p = (nodoLg) pila.desapilar();
            }
        }
        System.out.println("Dato no está en el árbol");

    }

    public void muestraPorNivel() {
        colas cola;
        nodoLg p, q;
        cola = new colas();
        p = primerNodo();
        if (p == null) {
            return;
        }
        while (p != null) {
            if (p.retornSw() == 0) {
                System.out.println((char) p.retornaDato() + " , ");
                else
                    q = (nodoLg)p.retornaDato();
                System.out.println((char) q.retornaDato() + " , ");
                cola.encolar(q.retornaLiga());
            }
            p = p.retornaLiga();
            while (p == null && !cola.esVacia()) {
                p = (nodoLg) cola.desencolar();
            }
        }

    }

    public int gradoDeUnDato(String d) {
        int n = 0;
        nodoLg p, q;
        stack pila = new stack();
        p = primerNodo();
        if ((char) p.retornDato() == d.charAt(0)) {
            p = p.retornaLiga();
            while (p != null) {
                n = n + 1;
                p = p.retornLiga();
            }
            return n;
        }
        p = p.retornLiga();
        while (p != null) {
            if (p.retornaSw() == 0) {
                if ((char) p.retornaDato() == d.charAt(0)) {
                    return 0;
                }
                p = p.retornLiga();
                else
                q = (nodoLg)p.retornDato();
                if ((char) q.retornDato() == d.charAt(0)) {
                    p = q.retornLiga();
                    while (p != null) {
                        n = n + 1;
                        p = p.retornliga();

                    }
                    return n;
                    else 
                        pila.apilar(p.retornLiga());
                    p = q.retornLiga();

                }

            }
            while (p == null && !pila.esVacia()) {
                p = (nodoLg) pila.desapilar();
            }
        }
        System.out.println("dato no esta en el arbol");
        return 0;

    }

    
}
