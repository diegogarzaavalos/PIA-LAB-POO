/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica10;
import java.io.*;
import java.util.*;

/**
 *
 * @author garza
 */
public class LectorArchivo extends Thread {
    private File archivo;

    public LectorArchivo(File archivo, String nombreHilo) {
        super(nombreHilo); // asigna el nombre del hilo (ej. "Hilo-1")
        this.archivo = archivo;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(getName() + " leyendo: " + linea);
                try {
                    // Pausa para simular trabajo y permitir intercalado entre hilos
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // Si el hilo es interrumpido, lo manejamos aquí
                    Thread.currentThread().interrupt();
                    System.out.println(getName() + " interrumpido.");
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(getName() + " - Archivo no encontrado: " + archivo.getName());
        } catch (IOException e) {
            System.out.println(getName() + " - Error leyendo el archivo: " + archivo.getName());
        }
    }
}