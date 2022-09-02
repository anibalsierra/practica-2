package Practica2;

/**
 *
 * @author wil
 */
public class LSL {

    private NodoSimple primero, ultimo;

    public LSL() {
        primero = ultimo = null;
    }

    public boolean esVacia() {
        return primero == null;
    }

    public NodoSimple primerNodo() {
        return primero;
    }

    public NodoSimple ultimoNodo() {
        return ultimo;
    }

    public NodoSimple anterior(NodoSimple x) {
        //no creo que sea asi analizar
        return x.retornaLiga();
    }

    public boolean finDeRecorrido(NodoSimple x) {
        return x == null;
    }

    public void recorre() {
        NodoSimple p;
        p = primerNodo();
        while (!finDeRecorrido(p)) {
            //aqui va la logica, el print es probable que se cambien 
            {
                System.out.println(p.retornaDato());
            }
            p = p.retornaLiga();
        }

    }

    public NodoSimple buscaDondeInsertar(Object d) {
        NodoSimple p, y;
        p = primerNodo();
        y = anterior(p);
        // la comparacion de objetos se debe efectuar de otra manera
        while (!finDeRecorrido(p) && p.retornaDato() < d) {
            y = p;
            p = p.retornaLiga();
        }
    }

    //Object
    public void insertar(Object d, NodoSimple y) {
        NodoSimple x;
        x = new NodoSimple(d);
        conectar(x, y);
    }

    public void conectar(NodoSimple x, NodoSimple y) {
        if (y != null) {
            x.asignaLiga(y.retornaLiga());
            y.asignaLiga(x);
            if (y == ultimo) {
                ultimo = x;

            } else {
                x.asignaLiga(primero);
                if (primero == null) {
                    ultimo = x;
                }
                primero = x;
            }

        }
    }

    public NodoSimple buscarDato(Object d, NodoSimple y) {
        NodoSimple x;
        x = primerNodo();
        y = anterior(x);
        while (!finDeRecorrido(x) && x.retornaDato() != d) {
            y = x;
            x = x.retornaLiga();
        }
        return x;
    }

    public void borrar(NodoSimple x, NodoSimple y) {
        if (x == null) {
            //sout no va se debe cambiar
            System.out.println("dato no existe");
            return;
        }
        desconectar(x, y);
    }

    public void desconectar(NodoSimple x, NodoSimple y) {
        if (x != primero) {
            y.asignaLiga(x.retornaLiga());
            if (x == ultimo) {
                ultimo = y;
            } else {
                primero = primero.retornaLiga();
                if (primero == null) {
                    ultimo = null;
                }
            }
        }
    }

    public void ordenarAscendentemente() {
        NodoSimple p, ap, menor, amenor, q, aq;
        p = primerNodo();
        ap = anterior(p);
        while (p != ultimoNodo()) {
            menor = p;
            amenor = ap;
            q = p.retornaLiga();
            aq = p;
            while (!finDeRecorrido(q)) {
                // la comparacion no es correcta corregir
                if (q.retornaDato() < menor.retornaDato()) {
                    menor = q;
                    amenor = aq;
                }
                aq = q;
                q = q.retornaLiga();
            }
            if (menor == p) {
                ap = p;
                p = p.retornaLiga();
            } else {
                desconectar(menor, amenor);
                conectar(menor, ap);
                ap = menor;
            }
        }

    }

}
