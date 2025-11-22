/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Runpractica8;

/**
 *
 * @author garza
 */
public class moto extends vehiculo implements combustion {
 private String tipoCombustible;
 private double nivelCombustible;

 public moto(String marca, String modelo, double velocidad) {
 super(marca, modelo, velocidad);
 this.tipoCombustible = "Gasolina";
 this.nivelCombustible = 40.0; // Tanque al 40%
 }

 @Override
 public String tipo() {
 return "Moto";
 }

 @Override
 public void repostar() {
 nivelCombustible = 100.0;
 System.out.println("Moto repostada. Nivel de combustible: " + nivelCombustible + "%");
 }

 @Override
 public String tipoCombustible() {
 return tipoCombustible;
 }

 @Override
 public String describir() {
 return super.describir() + " - Tipo: " + tipo() + " - Combustible: " + tipoCombustible;
 }
}