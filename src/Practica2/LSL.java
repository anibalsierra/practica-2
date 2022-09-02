package Practica2;

/**
 *
 * @author wil
 */
public class LSL implements ListaGod {

    private NodoSimple primero; 
    private NodoSimple ultimo;

    public LSL() {
        primero = ultimo = null;
    }

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
    public NodoGod anterior(NodoGod x) {
        NodoGod p,y;
        p = primerNodo();
        y = null;
        while(!p.equals(x)){
            y = p;
            p = p.retornaLiga();
        }
        return y;           
    }
    @Override
    public boolean finDeRecorrido(NodoGod x) {
        return x == null;
    }
    @Override
    public void recorre() {
        NodoGod p;
        p = primerNodo();
        while (!finDeRecorrido(p)) {
            //aqui va la logica, el print es probable que se cambien 
            {
                System.out.println(p.retornaDato());
            }
            p = p.retornaLiga();
        }

    }
    @Override
    public NodoGod buscaDondeInsertar(Object d) {
        NodoGod p, y;
        p = primerNodo();
        y = anterior(p);
        // la comparacion de objetos se debe efectuar de otra manera
        String datoP = (String)p.retornaDato();
        String datoD = (String)d;
        while (!finDeRecorrido(p) && (datoP.compareToIgnoreCase(datoD) < 0)) {
            y = p;
            p = p.retornaLiga();
        }
        return y;
    }
    //Object
    @Override
    public void insertar(Object d, NodoGod y) {
        NodoGod x;
        x = new NodoSimple(d);
        conectar(x, y);
    }
    @Override
    public void conectar(NodoGod x, NodoGod y) {
        if (y != null) {
            x.asignaLiga(y.retornaLiga());
            y.asignaLiga(x);
            if (y.equals((NodoGod)ultimo)) {
                ultimo = (NodoSimple)x;

            } else {
                x.asignaLiga(primero);
                if (primero == null) {
                    ultimo = (NodoSimple)x;
                }
                primero = (NodoSimple)x;
            }

        }
    }
    @Override
    public NodoGod buscarDato(Object d, NodoGod y) {
        NodoGod x;
        x = primerNodo();
        y = anterior(x);
        while (!finDeRecorrido(x) && !(x.retornaDato().equals(d))) {
            y = x;
            x = x.retornaLiga();
        }
        return x;
    }
    @Override
    public void borrar(NodoGod x, NodoGod y) {
        if (x == null) {
            //sout no va se debe cambiar
            System.out.println("dato no existe");
            return;
        }
        desconectar(x, y);
    }
    @Override
    public void desconectar(NodoGod x, NodoGod y) {
        if (!x.equals((NodoGod)primero)) {
            y.asignaLiga(x.retornaLiga());
            if (x.equals((NodoGod)ultimo)) {
                ultimo = (NodoSimple)y;
            } else {
                primero = primero.retornaLiga();
                if (primero == null) {
                    ultimo = null;
                }
            }
        }
    }
    @Override
    public void ordenarAscendentemente() {
        NodoGod p, ap, menor, amenor, q, aq;
        p = primerNodo();
        ap = anterior(p);
        while (!p.equals(ultimoNodo())) {
            menor = p;
            amenor = ap;
            q = p.retornaLiga();
            aq = p;
            while (!finDeRecorrido(q)) {
                // la comparacion no es correcta corregir
                String datoQ = (String)q.retornaDato();
                String datoMenor = (String)menor.retornaDato();
                if (datoQ.compareToIgnoreCase(datoMenor) < 0) {
                    menor = q;
                    amenor = aq;
                }
                aq = q;
                q = q.retornaLiga();
            }
            if (menor.equals(p)) {
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
