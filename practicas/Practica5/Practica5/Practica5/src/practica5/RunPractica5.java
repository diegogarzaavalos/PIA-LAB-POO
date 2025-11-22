/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica5;

import animales.Aguila;
import animales.Delfin;
import animales.Perro;

/**
 *
 * @author garza
 */
public class RunPractica5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Delfin d = new Delfin("Pablo");
        d.respirar();
        d.despertar();
        d.hacerSonido();
        d.comer();
        d.nadar();
        
        Aguila a = new Aguila("Marco");
        a.respirar();
        a.despertar();
        a.hacerSonido();
        a.comer();
        a.volar();
        
        Perro p = new Perro("Tomas");
        p.respirar();
        p.respirar();
        p.despertar();
        p.hacerSonido();
        p.comer();
        p.perseguirCola();
        p.correr();
    }
    
}
