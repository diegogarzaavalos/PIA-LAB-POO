/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animales;

/**
 *
 * @author garza
 */
public class Gato extends Animal {
    
    public Gato(String nombre) {
        super(nombre);
    }
    
    public void hacerSonido(){
        System.out.println("El gato maulla");
    }
    
    public String comer(){
        return "El gato comiendo";
    }
    
}
