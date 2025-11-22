/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animales;

/**
 *
 * @author garza
 */
public class Pajaro extends Animal {
    
    public Pajaro(String nombre){
        super(nombre);
    }
    
    public void volar(){
        System.out.println("Pajaro volando");
    }
    
    public void hacerSonido(){
        System.out.println("El pajaro canta");
    }
    
    
}
