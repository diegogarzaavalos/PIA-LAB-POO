/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Runpractica7;

/**
 *
 * @author garza
 */
public class TransporteAereo extends Transporte implements Operable {

    public TransporteAereo(String id, int capacidad) {
        super(id, capacidad);
    }

    @Override
    public String tipo() {
        return "Aéreo";
    }

    @Override
    public void mover() {
        System.out.println("Volando en el aire... ✈️");
    }

    @Override
    public void realizarMantenimiento() {
        System.out.println("Mantenimiento aéreo: inspección de turbinas y sistemas.");
    }
}