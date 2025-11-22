/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animales;

/**
 *
 * @author garza
 */
public class Perro extends Animal implements ITerrestre{
    
    public Perro(String nombre) {
        super(nombre);
    }
    
    @Override
    public void hacerSonido() {
        System.out.println("Perro hace sonido");
    }

    public String perseguirCola(){
        return "Perro persiguiendo su cola";
    }

    @Override
    public void correr() {
        System.out.println("Perro corriendo");
    }

}
