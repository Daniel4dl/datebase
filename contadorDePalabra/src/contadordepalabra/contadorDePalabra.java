/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contadordepalabra;

import java.io.*;
import java.util.StringTokenizer;

/**
 *
 * @author csipro
 */
public class contadorDePalabra {

    public static void leerArchivo(String archivo) throws FileNotFoundException, IOException {
        long TInicio, TFin, tiempo;
        TInicio = System.currentTimeMillis();
        String cadena;
        int numPalabra = 0;
        int c = 0;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            c++;
            String[] a = cadena.trim().split("[^a-zA-Z']");
            for (String aa : a) {
                if (aa.matches("[a-zA-Z']{4,}")) {
                    numPalabra++;
                          
                }

            }
        }

            b.close();
            System.out.println("El numero de lineas son " + c + " la cantidad de palabras son: " + numPalabra);
            TFin = System.currentTimeMillis();
            tiempo = TFin - TInicio;
            System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
        }
    

    public static void main(String[] args) throws IOException {
        leerArchivo(args[0]);

    }

}
