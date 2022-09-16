
package Practica2;

import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Queue;

/**
 *
 * @author beto_
 */
public class ArbolEneario extends ListaG {

    public int altura(NodoLg L) {
        NodoLg p;
        int g, h;
        h = 1;
        if (L == null) {
            return 0;
        }
        if (L.retornaLiga() == null) {
            return 1;
        }
        p = L;
        while (p != null) {
            if (p.retornaSw() == 1) {
                g = altura((NodoLg) p.retornaDato());
                if (g > h) {
                    h = g;
                }
            }
            p = (NodoLg) p.retornaLiga();
        }
        return h + 1;
    }

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
                    System.out.println("Los ancestros de " + d + " son:");
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
                    System.out.println("Los ancestros de " + d + " son");
                    while (!pila.empty()) {
                        c = (char) pila.pop();
                        System.out.println(c + "");
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

    public void muestraPorNivel() {
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

    public int gradoDeUnDato(String d) {
        int n = 0;
        NodoLg p, q;
        Stack pila = new Stack();
        p = (NodoLg) primerNodo();
        if ((char) p.retornaDato() == d.charAt(0)) {
            p = (NodoLg) p.retornaLiga();
            while (p != null) {
                n = n + 1;
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
}
