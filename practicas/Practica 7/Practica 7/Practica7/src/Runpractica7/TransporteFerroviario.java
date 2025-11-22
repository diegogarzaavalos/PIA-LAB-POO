/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Runpractica7;

/**
 *
 * @author garza
 */
public class TransporteFerroviario extends Transporte implements Operable {

    public TransporteFerroviario(String id, int capacidad) {
        super(id, capacidad);
    }

    @Override
    public String tipo() {
        return "Ferroviario";
    }

    @Override
    public void mover() {
        System.out.println("Circulando por vías férreas... 🚂");
    }

    @Override
    public void realizarMantenimiento() {
        System.out.println("Mantenimiento ferroviario: revisión de rieles y vagones.");
    }
}