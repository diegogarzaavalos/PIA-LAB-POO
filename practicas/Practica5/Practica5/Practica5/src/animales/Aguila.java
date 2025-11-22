/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animales;

/**
 *
 * @author garza
 */
public class Aguila extends Animal implements IVolar{
    
     public Aguila(String nombre) {
        super(nombre);
    }
    
    @Override
    public void hacerSonido() {
        System.out.println("Aguila hace sonido");
    }

    @Override
    public void volar() {
        System.out.println("Aguila nadando");
    }

    public String ponerHuevo(){
        return "Aguila poniendo huevo";
    }
}
