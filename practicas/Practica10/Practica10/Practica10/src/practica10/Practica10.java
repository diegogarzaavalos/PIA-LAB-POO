/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica10;
import java.io.*;
import java.util.*;
/**
 *
 * @author garza
 */
public class Practica10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File carpeta = new File("sucursales");
        if (!carpeta.exists()) carpeta.mkdir();

        // Crear archivos de ejemplo con nombres (si no existen)
        crearArchivoConNombres(new File(carpeta, "sucursal1.txt"), Arrays.asList("Ana", "Luis", "Sofía"));
        crearArchivoConNombres(new File(carpeta, "sucursal2.txt"), Arrays.asList("Carlos", "Marta", "Pedro"));
        crearArchivoConNombres(new File(carpeta, "sucursal3.txt"), Arrays.asList("Laura", "Jorge", "Diego"));

        // Preparar hilos
        File f1 = new File(carpeta, "sucursal1.txt");
        File f2 = new File(carpeta, "sucursal2.txt");
        File f3 = new File(carpeta, "sucursal3.txt");

        LectorArchivo hilo1 = new LectorArchivo(f1, "Hilo-1");
        LectorArchivo hilo2 = new LectorArchivo(f2, "Hilo-2");
        LectorArchivo hilo3 = new LectorArchivo(f3, "Hilo-3");

        // Iniciar los hilos (se ejecutan en paralelo)
        hilo1.start();
        hilo2.start();
        hilo3.start();

        // (Opcional) esperar a que terminen para luego mostrar total
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\nTodos los hilos han terminado de leer.");
    }

    private static void crearArchivoConNombres(File archivo, List<String> nombres) {
        if (archivo.exists()) return; // no sobrescribir si ya existe
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (String nombre : nombres) {
                bw.write(nombre);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al crear " + archivo.getName());
        }
    }
 }
   
