/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Runpractica9;

import java.io.*;
import java.util.*;
/**
 *
 * @author garza
 */
public class GestorArchivos {

    public static void main(String[] args) {
        File carpeta = new File("datos");
        if (!carpeta.exists()) {
            carpeta.mkdir();
            System.out.println("Carpeta 'datos' creada.");
        } else {
            System.out.println("Carpeta 'datos' ya existe.");
        }

        File archivo = new File(carpeta, "productos.txt");
        Scanner sc = new Scanner(System.in);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            System.out.println("\n=== Registro de productos ===");
            System.out.print("¿Cuántos productos quieres agregar?: ");
            int n = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            for (int i = 1; i <= n; i++) {
                System.out.println("\nProducto #" + i);
                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine(); // Limpiar buffer

                String nombre;
                do {
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine().trim();
                    if (nombre.isEmpty()) {
                        System.out.println("El nombre no puede estar vacío.");
                    }
                } while (nombre.isEmpty());

                String categoria;
                do {
                    System.out.print("Categoría: ");
                    categoria = sc.nextLine().trim();
                    if (categoria.isEmpty()) {
                        System.out.println("La categoría no puede estar vacía.");
                    }
                } while (categoria.isEmpty());

                bw.write(id + "," + nombre + "," + categoria);
                bw.newLine();
            }
            System.out.println("\n✅ Productos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
        }

        // Lectura del archivo completo
        System.out.println("\n=== Lectura del archivo ===");
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }

        // Mostrar archivos en carpeta
        System.out.println("\n=== Archivos en la carpeta 'datos' ===");
        String[] listaArchivos = carpeta.list();
        if (listaArchivos != null) {
            for (String nombre : listaArchivos) {
                System.out.println(nombre);
            }
        }

        // Retos opcionales
        System.out.println("\n=== Retos opcionales ===");
        System.out.println("1) Buscar producto por nombre");
        System.out.println("2) Crear archivo de categorías únicas");
        System.out.println("3) Borrar archivo productos.txt");
        System.out.println("4) Salir");
        System.out.print("Selecciona una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1 -> {
                System.out.print("Introduce el nombre del producto a buscar: ");
                String nombreBuscado = sc.nextLine();
                buscarProductoPorNombre(archivo, nombreBuscado);
            }
            case 2 -> crearArchivoCategorias(archivo, new File(carpeta, "categorias.txt"));
            case 3 -> borrarArchivo(archivo);
            default -> System.out.println("Saliendo...");
        }

        sc.close();
    }

    // Buscar producto por nombre
    public static void buscarProductoPorNombre(File archivo, String nombre) {
        System.out.println("\n=== Resultado de búsqueda ===");
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            boolean encontrado = false;
            while ((linea = br.readLine()) != null) {
                if (linea.toLowerCase().contains(nombre.toLowerCase())) {
                    System.out.println(linea);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("No se encontraron productos con ese nombre.");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }

    // Crear archivo categorias.txt con categorías únicas
    public static void crearArchivoCategorias(File origen, File destino) {
        System.out.println("\n=== Creando archivo de categorías únicas ===");
        Set<String> categorias = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader(origen))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    categorias.add(partes[2]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de productos.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(destino))) {
            for (String cat : categorias) {
                bw.write(cat);
                bw.newLine();
            }
            System.out.println("Archivo categorias.txt creado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en categorias.txt.");
        }
    }

    // Borrar el archivo productos.txt con confirmación
    public static void borrarArchivo(File archivo) {
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Seguro que deseas eliminar productos.txt? (s/n): ");
        String respuesta = sc.nextLine();
        if (respuesta.equalsIgnoreCase("s")) {
            if (archivo.delete()) {
                System.out.println("🗑️ Archivo eliminado correctamente.");
            } else {
                System.out.println("No se pudo eliminar el archivo.");
            }
        } else {
            System.out.println("Operación cancelada.");
        }
    }
}



