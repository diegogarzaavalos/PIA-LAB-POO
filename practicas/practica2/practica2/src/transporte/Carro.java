/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transporte;

/**
 *
 * @author garza
 */


public class Carro {

    private String marca;
    private String modelo;
    private String anno;
    private String tipo;
    
    
    
    public Carro(String marca, String modelo, String anno, String tipo) {
        this.marca = marca;
        this.modelo = modelo;
        this.anno = anno;
        this.tipo = tipo;

    }

    public void displayInfo() {
        System.out.println("Marca:" + marca + ", Marca:" + modelo + ", Anno: " + anno + ", Tipo:" + tipo);
    }

    public void arrancarMotor() {
        System.out.println("Motor encendido");
    }
    
    public void avanzar(){
        System.out.println("Avanzando...");
    }
    
    public void detener(){
        System.out.println("Deteniendo...");
    }
    
    public void apagarMotor(){
        System.out.println("Motor apagado");
    }
    
    
}







