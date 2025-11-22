/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Runpractica7;

/**
 *
 * @author garza
 */
import java.util.ArrayList;

public class Practica7 {
    public static void main(String[] args) {
        ArrayList<Transporte> lista = new ArrayList<>();
        lista.add(new TransporteMaritimo("BAR-01", 80));
        lista.add(new TransporteTerrestre("BUS-33", 50));
        lista.add(new TransporteAereo("AV-777", 120));
        lista.add(new TransporteFerroviario("TRN-21", 200)); // Nuevo tipo

        int pasajeros = 60;

        for (Transporte t : lista) {
            t.mover();
            try {
                t.transportar(pasajeros);
            } catch (CapacidadExcedidaException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
            if (t instanceof Operable) {
                ((Operable) t).realizarMantenimiento();
            }
            System.out.println("---");
        }
    }
}
