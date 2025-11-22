/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animales;

/**
 *
 * @author garza
 */
public class Perro extends Animal{
    
    public Perro(String nombre) {
        super(nombre);
    }
    
    public void hacerSonido(){
        System.out.println("El perro ladra");
    }
    
    public String comer(){
        return "El perro come croquetas";
    }
    
    public void correr(){
        System.out.println("El perro ladra");
    }
    
}
