
package ProgramaPrincipal;

import Practica2.*;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author beto & wil
 */
public class ProgramaPrincipal {
    
    private static Scanner lector = new Scanner(System.in);
    private static ArbolEneario arbol = new ArbolEneario();
    private static NodoLg Lg;
    private static String hilera;
    
    public static void practica() {
        loop:
        while (true) {
            mostrarMenu();
            System.out.print("escoga la opcion que desea utilizar -> ");
            try {
                String num = lector.nextLine();
                switch (num) {
                    case "1":
                        System.out.println("la hilera debe estar bien construida" + "\nun ejemplo de hilera puede ser (a,(b,c,d))"
                                + "\npase la hilera que quiera utilizar");
                        hilera = lector.nextLine();
                        arbol = new ArbolEneario(hilera);
                        break;
                    case "2":
                        Lg = (NodoLg) arbol.primerNodo();
                        int band = 0;
                        arbol.CreacionHileraEnBaseDeNodoLg(Lg, band);
                        break;
                    case "3":
                        Lg = (NodoLg) arbol.primerNodo();
                        System.out.println("la altura del arbol es: " + arbol.altura(Lg));
                        break;
                    case "4":
                        System.out.println("el grado del arbol es: " + arbol.gradoArbol());
                        break;
                    case "5":                        
                        System.out.println("las hojas del arbol son: " + arbol.hojasArbol());
                        break;
                    case "6":
                        System.out.print("digite el dato: ");
                        hilera = lector.nextLine();
                        System.out.println("el grado del dato ingresado es: " + arbol.gradoDeUnDato(hilera));
                        break;
                    case "7":
                        System.out.println("digite el dato: ");
                        hilera = lector.nextLine();
                        arbol.muestraNivelDeRegistro(hilera);
                        break;
                    case "8":
                        System.out.println("digite el dato");
                        hilera = lector.nextLine();
                        arbol.ancestrosDeUnDato(hilera);
                        break;
                    case "9":
                        System.out.println("acaba de cerrar el menu");
                        break loop;                        
                    default: {
                        break;
                    }
                }
            } catch (InputMismatchException e) {
            }
        }
    }   
    public static void mostrarMenu(){
        
        System.out.println("""
                           \nMenu:
                           1. Construir lista generalizada con un String
                           2. Mostrar el String correspondiente a una lista generalizada
                           3. Determinar e imprimir altura del \u00e1rbol
                           4. Determinar e imprimir el grado del \u00e1rbol
                           5. Determinar e imprimir el n\u00famero de hojas del \u00e1rbol
                           6. Determinar e imprimir el grado de un registro.
                           7. Determinar e imprimir el nivel de un registro.
                           8. Determinar e imprimir los ancestros de un dato.
                           9. salir del menu.
                           """);
    }
    public static void main(String[] args){    
        practica();
    }
}
