/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica2;

/**
 *
 * @author beto_
 */
public class Vector {
    
    private Object v[];
    private int n;
    
    public Vector(int m){
        this.n = m + 1;
        this.v = new Object[n];
        this.v[0]=0; 
    }
    public int retornaCapacidad(){
        return n;
    }
    public int retornaNumeroElementos(){
        return (int)v[0];
    }
    public void asignaNumeroElementos(int n){
        v[0] = n;
    }
    public Object retornaDatoEn(int i){
        return v[i];
    }
    public void asignaDato(Object d, int i){
        v[i]= d;
    }
    public void muestraDatos(){
        for(int i = 1; i<=(int)v[0];i++){
            System.out.println(i+": "+v[i]);
        }
    }
    public boolean esVacio(){
        return (int)v[0]==0;
    }
    public boolean esLleno(){
        return (int)v[0]==this.n;
    }
    public int retornaPosicionDato(Object d){
        int i = 1;
        while(i<=(int)v[0]&&!(v[i].equals(d))){
            i++;
        }
        return i;
    }
    public void ordenaAscendente(){
        int i,j,k;
        String s1, s2;
        for(i =1; i<=((int)v[0]-1);i++){
            k = i;
            for(j=i+1; j<=(int)v[0];j++){
                s1 = (String)v[j];
                s2 = (String)v[k];
                if(s1.compareToIgnoreCase(s2)<0){
                    k = j;
                }
            }
            intercambia(k,i);
        }
    }
    public void ordenaDescendente(){
        int i,j,k;
        String s1, s2;
        for(i=1; i<=(int)v[0]-1;i++){
            k=i;
            for(j=i+1; j<=(int)v[0];j++){
                s1 = (String)v[j];
                s2 = (String)v[k];
                if(s1.compareToIgnoreCase(s2)>0){
                    k = j;
                }
                intercambia(k,i);
            }
        }
    }
    public void agregar(Object d){
        if(esLleno()){
            System.out.println("vector lleno, no se pueden agregar datos");
            return;
        }
        v[0]= (int)v[0]+1;
        v[(int)v[0]]=d;
    }
    public int buscaDondeInsertar(Object d){
        int i=1;
        String s1=(String)v[i], s2=(String)d;
        while(i<=(int)v[0]&&s1.compareToIgnoreCase(s2)<0){            
            i++;
            s1=(String)v[i];
        }
        return i;
    }
    public void inserta(Object d, int i){
        int j;
        if(esLleno()){
            System.out.println("vector lleno, no se puede insertar");
            return;
        }
        for(j=(int)v[0]; j>=i; j--){
            v[j+1]=v[j];
        }
        v[j]=d;
        v[0]=(int)v[0]+1;
    }
    public void inserta(Object d){
        int i;
        i = buscaDondeInsertar(d);
        inserta(d,i);
    }
    public void borraDatoEn(int i){
        int j;
        if(i>=(int)v[0]+1||i<1){
            System.out.println("no existen datos en la posición indicada ó no la posición dada no es válida");
            return;
        }
        for(j=i+1;j<(int)v[0];j++){
            v[j-1]=v[j];
        }
        v[0]=(int)v[0]-1;
    }
    private void intercambia(int i, int k){
        Object aux;
        aux = v[i];
        v[i]=v[k];
        v[k]=aux;
    }    
}
