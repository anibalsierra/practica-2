
package Practica2;

import java.util.Stack;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Queue;


/**
 *
 * @author beto & wil
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
        }
        System.out.println("Dato no está en el árbol");
    }
    //revisado
    public void muestraNivelDeRegistro(String d) {
        Queue cola;
        NodoLg p, q;
        cola = new ConcurrentLinkedQueue();
        p = (NodoLg) primerNodo();
        int numEncoladas = 0;
        int numVecesEncoladasPorNivel=0;
        boolean cambioNivel = true;
        if (p == null) {
            System.out.println("El árbol está vacio, por tanto el dato no existe");
            return;
        }
        int nivel = 1;
        if((char)p.retornaDato()== d.charAt(0)){            
            System.out.println("El dato \""+d+"\", es la raiz del árlbol por tanto está"
                    + " en el nivel: "+nivel);
        }        
        p = (NodoLg)p.retornaLiga();
        if (p == null) {
            System.out.println("El dato buscado no está en el árbol");
            return;
        }
        nivel++;
        while (p != null) {
            if (p.retornaSw() == 0) {
                if((char)p.retornaDato()== d.charAt(0)){            
                    System.out.println("El dato \""+d+"\", está en el nivel: "+nivel);
                    return;
                }                
            } else {
                q = (NodoLg) p.retornaDato();
                if((char)q.retornaDato()== d.charAt(0)){            
                    System.out.println("El dato \""+d+"\", está en el nivel: "+nivel);
                    return;
                }
                cola.add(q.retornaLiga());
                numEncoladas++;
            }
            p = (NodoLg) p.retornaLiga();
            if(p == null && !cola.isEmpty()&& cambioNivel == true){
                numVecesEncoladasPorNivel = numEncoladas;                
            }
            while (p == null && !cola.isEmpty()) {                
                if(cambioNivel){
                    nivel++;
                    cambioNivel = false;
                }                
                p = (NodoLg) cola.poll();
                numVecesEncoladasPorNivel--;
                numEncoladas--;
                if(numVecesEncoladasPorNivel==0){
                    cambioNivel = true;
                }
            }
        }
        System.out.println("El dato buscado no está en el árbol");
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
    //revisado
    public int hojasArbol() {
        Queue cola;
        NodoLg p, q;
        cola = new ConcurrentLinkedQueue();
        p = (NodoLg) primerNodo();
        int hojas = 0;        
        if (p == null) {
            System.out.println("El árbol está vacio");
            return hojas;
        }                
        p = (NodoLg)p.retornaLiga();
        if (p == null) {
            hojas++;
            return hojas;
        }        
        while (p != null) {
            if (p.retornaSw() == 0) {
                hojas++;                               
            } else {
                q = (NodoLg) p.retornaDato();                
                cola.add(q.retornaLiga());                
            }
            p = (NodoLg) p.retornaLiga();            
            while (p == null && !cola.isEmpty()) {                              
                p = (NodoLg) cola.poll();                
            }
        }
        return hojas;
    }
    //revisado
    public int gradoArbol() {
        Queue cola;
        NodoLg p, q;
        cola = new ConcurrentLinkedQueue();
        p = (NodoLg) primerNodo();
        int mayorGrado = 0;
        int grado = 0;
        if (p == null||p.retornaLiga()==null) {
            return mayorGrado;
        }       
        p = (NodoLg)p.retornaLiga();
        while (p != null) {
            if (p.retornaSw() == 0) {
                grado++;                               
            } else {
                q = (NodoLg) p.retornaDato();
                grado++;                
                cola.add(q.retornaLiga());                
            }
            p = (NodoLg) p.retornaLiga();            
            if(p == null){
                if(mayorGrado<grado){
                   mayorGrado = grado; 
                }
            }
            while (p == null && !cola.isEmpty()) {
                grado = 0;                                
                p = (NodoLg) cola.poll();                
            }
        }
        return mayorGrado;
    }
    //revisado
    public void CreacionHileraEnBaseDeNodoLg(NodoLg L, int band) {
        NodoLg p, primero, q;
        Stack pila = new Stack();
        if (L == null) {
            System.out.print("LISTA VACIA");
            return;

        }
        primero = null;
        if (band == 0) {
            // se modifica dentro del print L.retornaLiga por L.retornDato
            System.out.print("(" + L.retornaDato());
            if (L.retornaLiga() == null) {
                System.out.print(")");
                return;
            }
            System.out.print("(");
            primero = L;
        }
        p = (NodoLg) L.retornaLiga();
        while (p != null) {
            if (p.retornaSw() == 0) {
                System.out.print(p.retornaDato());
            } else {
                q = (NodoLg) p.retornaDato();
                System.out.print(q.retornaDato() + "(");
                CreacionHileraEnBaseDeNodoLg((NodoLg) p.retornaDato(), 1);
            }
            if (p.retornaLiga() != null) {
                System.out.print(",");
            }
            p = (NodoLg) p.retornaLiga();
        }
        System.out.print(")");
        if (primero == L) {
            System.out.print(")");
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
