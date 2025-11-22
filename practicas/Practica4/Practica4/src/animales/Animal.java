/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animales;

/**
 *
 * @author garza
 */
public class Animal {
    
    String nombre;
    
    public Animal(String nombre){
        this.nombre = nombre;
    }
    
    public void mostrarNombre(){
        System.out.println("Me llamo: " + nombre);
    }
    
    public void hacerSonido(){
        System.out.println("El animal hace un sonido");
    }
    
    public String comer(){
        return "Animal comiendo";
    }
    
    
    
}
