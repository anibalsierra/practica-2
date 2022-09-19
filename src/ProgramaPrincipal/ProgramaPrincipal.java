
package ProgramaPrincipal;

import Practica2.*;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author beto & wil
 */
public class ProgramaPrincipal {
    
    //static Scanner scan = new Scanner(System.in);
    public static void mostrarMenu(){
        
        System.out.println("""
                           Menu:
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
        //se debe construir un arbol para poder trabajar en el
        Scanner lector = new Scanner(System.in);
        ArbolEneario arbol = new ArbolEneario();
        NodoLg Lg;
        String hilera;
        //System.out.println("profavor ingrese el arbol deseado");
        
        
        loop: while(true){
                mostrarMenu(); 
                System.out.print("escoga la opcion que desea utilizar -> ");
                
            try{
                String num = lector.nextLine();
                
                
                
                //String hilera = "(a(b,c,d))";
                switch (num){
                    case "1":
                        System.out.println("pase la hilera que quiera utilizar; debe estar bien construida la hilera"
                                + "\nun ejemplo de hilera puede ser (a,(b,c,d))");
                        hilera = lector.nextLine();
                        arbol = new ArbolEneario(hilera);
                        break;
                    case "2":
                        Lg = (NodoLg)arbol.primerNodo();
                        int band = 0;
                        arbol.CreacionHileraEnBaseDeNodoLg(Lg, band);
                        break;
                    case "3":
                        Lg = (NodoLg)arbol.primerNodo();
                        System.out.println(arbol.altura(Lg));
                        break;
                    case "4":
                        arbol.gradoArbol();
                        break;
                    case "5":
                        arbol.hojasArbol();
                        break;
                    case "6":
                        System.out.println("digite el dato");
                        hilera = lector.nextLine();
                        System.out.println(arbol.gradoDeUnDato(hilera));
                        break;
                    case "7":
                        Lg = (NodoLg)arbol.primerNodo();
                        arbol.muestraPorNivel(Lg);
                        break;
                    case "8": 
                        System.out.println("digite el dato");
                        hilera = lector.nextLine();
                        arbol.ancestrosDeUnDato(hilera);
                        break;
                    case "9":
                        break loop;
                        
                    default:{
                        break;
                            }
                        
                   
                    
                }
            }catch(InputMismatchException e){
                
            }    
                
        }
    
        
        
    }

    

   
    
}
