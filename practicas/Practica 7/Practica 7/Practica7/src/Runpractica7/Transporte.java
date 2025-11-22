/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Runpractica7;

/**
 *
 * @author garza
 */
public abstract class Transporte {
    private String id;
    private int capacidad;

    public Transporte(String id, int capacidad) {
        setId(id);
        setCapacidad(capacidad);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor a 0");
        }
        if (capacidad > 500) {
            throw new IllegalArgumentException("La capacidad no puede superar 500");
        }
        this.capacidad = capacidad;
    }

    public abstract String tipo();
    public abstract void mover();

    public void transportar(int pasajeros) throws CapacidadExcedidaException {
        if (pasajeros > capacidad) {
            throw new CapacidadExcedidaException("Pasajeros (" + pasajeros + 
                ") exceden capacidad (" + capacidad + ") en " + tipo());
        }
        System.out.println("Transportando " + pasajeros + " pasajeros en " + tipo() + " [" + id + "]");
    }
}
