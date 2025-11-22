/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Runpractica7;

/**
 *
 * @author garza
 */
public class TransporteMaritimo extends Transporte implements Operable {

    public TransporteMaritimo(String id, int capacidad) {
        super(id, capacidad);
    }

    @Override
    public String tipo() {
        return "Marítimo";
    }

    @Override
    public void mover() {
        System.out.println("Navegando por mar... 🛳️");
    }

    @Override
    public void realizarMantenimiento() {
        System.out.println("Mantenimiento marino: revisión de casco y motores.");
    }
}