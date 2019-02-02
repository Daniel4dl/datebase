/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabladefrecuencia;

import java.io.*;
import java.util.*;

public class TablaDeFrecuencia {
static  ArrayList<String> total=new ArrayList<String>();
static TreeSet palabras=new TreeSet();
    static int busquedad(String palabra) throws IOException {
        int c = 0;

        for (Object i : total) {
            if (i.toString().equals(palabra)) {
                c++;
            } else {
                continue;
            }

        }

        for (int i = 0; i < c; i++) {
            total.remove(palabra);

        }
     

        return c;
    }
 public static HashMap<String,Integer> leerArchivo(String archivo) throws FileNotFoundException, IOException {
 
       HashMap<String,Integer> tabla=new HashMap<String,Integer>();
        String cadena;
        int num = 0;
        int c = 0;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            c++;
            String[] a = cadena.trim().split("[^a-zA-Z']");
            for (String aa : a) {
                if (aa.matches("[a-zA-Z']{4,}")) {
                    palabras.add(aa);
                          total.add(aa);
                }

            }
        }
            b.close();
            for (Object i:palabras) {
               
                tabla.put(i.toString(),busquedad(i.toString()));
                
            }
     return tabla;
        }
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        HashMap<String,Integer>tabla=leerArchivo(args[0]);
        System.out.println("Palabra"+" Cantidad");
        for (Object i: palabras) {
            
            System.out.println(i+" "+tabla.get(i));
        }
    }
    
}
