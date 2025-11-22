/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Runpractica8;

/**
 *
 * @author garza
 */
public class recurso implements AutoCloseable {
 private String nombreRecurso;

 public recurso(String nombreRecurso) {
 this.nombreRecurso = nombreRecurso;
 System.out.println("Recurso " + nombreRecurso + " inicializado.");
 }

 public void usar() {
 System.out.println("Usando recurso: " + nombreRecurso);
 }

 @Override
 public void close() {
 System.out.println("Cerrando recurso: " + nombreRecurso + " - Limpieza completada.");
 }
}
