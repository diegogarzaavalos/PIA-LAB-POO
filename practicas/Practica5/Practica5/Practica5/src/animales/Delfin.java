/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animales;

/**
 *
 * @author garza
 */
public class Delfin extends Animal implements IAcuatico{

    public Delfin(String nombre) {
        super(nombre);
    }
    
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " hace sonido");
    }

    @Override
    public void nadar() {
        System.out.println("Delfin nadando");
    }

    
}
