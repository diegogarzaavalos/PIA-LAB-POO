/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica4;
import animales.*;
/**
 *
 * @author garza
 */
public class RunPractica4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Animal a = new Animal("Electrico") {};
        Gato g = new Gato("pinut");
        Pajaro p = new Pajaro("Loco");
        Perro d = new Perro("Bluey");
        
        System.out.println(" Animal ");
        a.mostrarNombre();
        a.hacerSonido();
        System.out.println(a.comer());
        
        System.out.println(" Gato ");
        g.mostrarNombre();
        System.out.println(g.comer());
        g.hacerSonido();
        
        System.out.println(" Pajaro ");
        p.mostrarNombre();
        System.out.println(p.comer());
        p.hacerSonido();
        p.volar();
        
        System.out.println(" Perro ");
        d.mostrarNombre();
        System.out.println(d.comer());
        d.hacerSonido();
        d.correr();
    }
    
}
