/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2.run;

import transporte.*;

/**
 *
 * @author garza
 */
public class runpractica2 {

    public static void main(String[] args) {
        // TODO code application logic here
        
        Automovil auto = new Automovil();
        auto.setMarca("ford");
        System.out.println(auto.getMarca());
        auto.arrancarMotor();
        auto.getModelo();
        
        
        
        Carro toyota = new Carro("Toyota", "Corrola", "2022", "Sedan");
        toyota.displayInfo();
        toyota.arrancarMotor();
        toyota.avanzar();
        toyota.detener();
        toyota.apagarMotor();
        
        
        Carro ford = new Carro("Ford", "Mustang", "2021", "Deportivo");
        ford.displayInfo();
        ford.arrancarMotor();
        ford.avanzar();
        ford.detener();
        ford.apagarMotor();
        
        Carro tesla = new Carro("Tesla", "Model X", "2023", "SUV");
        tesla.displayInfo();
        tesla.arrancarMotor();
        tesla.avanzar();
        tesla.detener();
        tesla.apagarMotor();
    }
    
    
    
}
