/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica8;
import java.util.*;
/**
 *
 * @author garza
 */
public class LaboratorioColecciones {
    public static void main(String[] args) {
        // ================= A. ArrayList =================
        System.out.println("== ArrayList: Exhibición ==");

        ArrayList<Producto> listaExhibicion = new ArrayList<>();
        listaExhibicion.add(new Producto(1, "Teclado", "Perifericos"));
        listaExhibicion.add(new Producto(2, "Mouse", "Perifericos"));
        listaExhibicion.add(new Producto(3, "Monitor", "Pantallas"));
        listaExhibicion.add(new Producto(4, "Cable HDMI", "Oferta"));

        for (Producto p : listaExhibicion) {
            System.out.println(p);
        }

        // ================= B. LinkedList =================
        System.out.println("\n== LinkedList: Reabastecer ==");

        LinkedList<Producto> colaReabastecer = new LinkedList<>();
        colaReabastecer.addLast(new Producto(5, "Laptop", "Computo"));
        colaReabastecer.addFirst(new Producto(6, "Webcam", "Perifericos"));

        for (Producto p : colaReabastecer) {
            System.out.println(p);
        }

        // ================= C. HashSet =================
        System.out.println("\n== HashSet: Categorías únicas ==");

        HashSet<String> categorias = new HashSet<>();
        for (Producto p : listaExhibicion) {
            categorias.add(p.getCategoria());
        }
        for (Producto p : colaReabastecer) {
            categorias.add(p.getCategoria());
        }

        System.out.println(categorias);

        // ================= D. HashMap =================
        System.out.println("\n== HashMap: Consulta por id ==");

        HashMap<Integer, Producto> mapaPorId = new HashMap<>();
        for (Producto p : listaExhibicion) {
            mapaPorId.put(p.getId(), p);
        }
        for (Producto p : colaReabastecer) {
            mapaPorId.put(p.getId(), p);
        }

        int idConsulta = 3;
        System.out.println("id=" + idConsulta + " -> " + mapaPorId.get(idConsulta));

        System.out.println("\nRecorriendo HashMap (entrySet):");
        for (Map.Entry<Integer, Producto> entry : mapaPorId.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // ================= E. Iterator =================
        System.out.println("\n== Iterator: eliminar categoría 'Oferta' en listaExhibicion ==");

        Iterator<Producto> it = listaExhibicion.iterator();
        while (it.hasNext()) {
            Producto p = it.next();
            if (p.getCategoria().equals("Oferta")) {
                it.remove(); // eliminación segura
            }
        }

        System.out.println("Después de eliminar:");
        for (Producto p : listaExhibicion) {
            System.out.println(p);
        }
    }
}