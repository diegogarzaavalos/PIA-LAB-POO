/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Runpractica8;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author garza
 */
public class Practica8 {

 public static void main(String[] args) {

hibrido b = new hibrido("Toyota", "Prius", 45.50);
System.out.println("Tipo de b: " + b.tipo());
b.acelerar();

vehiculo g = new hibrido("Ford", "Fusion Hybrid", 40.00);

auto auto = new auto("Nissan", "Sentra", 0.0);
moto moto = new moto("Yamaha", "MT-07", 0.0);
electrico electrico = new electrico("Chevrolet", "Bolt EV", 0.0);

List<vehiculo> flota = Arrays.asList(b, g, auto, moto, electrico);

for (vehiculo v : flota) {
    System.out.println("\n--- " + v.getClass().getSimpleName() + " ---");
    System.out.println("Descripción: " + v.describir());
    System.out.println("Tipo: " + v.tipo());

    // Acelerar usando sobrecarga de métodos
    v.acelerar();      // Sin parámetros
    v.acelerar(25.0);  // Con parámetros
    v.frenar(10.0);
    
    // Demostrar casting y verificación de interfaces
    if (v instanceof combustion) {
        System.out.println("Es de combustión - Tipo: " + ((combustion) v).tipoCombustible());
        ((combustion) v).repostar();
    }

    if (v instanceof electricidad) {
        System.out.println("Es eléctrico - Batería: " + ((electricidad) v).nivelBateria() + "%");
        ((electricidad) v).cargar();
    }
}

System.out.println("\n=== DEMOSTRANDO AutoCloseable (RecursoLog) ===");

try (recurso recurso = new recurso("Sistema de Entretenimiento")) {
    recurso.usar();
    System.out.println("Operaciones finalizadas.");
}
}
}
