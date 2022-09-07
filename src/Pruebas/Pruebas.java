/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pruebas;

/**
 *
 * @author beto_
 */
import Practica2.*;
import java.util.Stack;


public class Pruebas {    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n1, n2;
        char c1, c2;
        String s1, s2;
        
        /*if(!false){
            //si verdadero
        } else {
            //de lo contrario.
        } */
        NodoSimple nS1, nS2;
        NodoLg nLG1;
        Object dato;
        nS1 = new NodoSimple("d");
        nS2 = new NodoSimple("a");
        nLG1 = new NodoLg("1993");
        s1="a";
        s2="1992";
        dato = nS2;
        int sw;        
        if((nS1.getClass().equals(dato.getClass()))){
            sw = 0;
        } else {
            sw = 1;
        }
        System.out.println(sw);
        System.out.println(nS1.retornaDato());
        System.out.println(nLG1.retornaDato());
        
        //función comparar un dato con otro
        //a negative integer, zero, or a positive integer as the specified 
        //String is greater than, equal to, or less than this String, ignoring case considerations.
        //datoP.compareToIgnoreCase(datoD) < 0
        //función comparar clases, .getClass() y usar luego la función .equals(Object o)
        
        String exp = "9" ;
        
        switch(exp){
            case "1":
                ;
            case"2":
                ;
            default:
                ;                    
        }
    }
    
}
