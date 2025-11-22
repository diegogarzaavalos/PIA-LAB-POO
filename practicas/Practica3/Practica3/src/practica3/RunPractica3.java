/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica3;

/**
 *
 * @author garza
 */
public class RunPractica3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        CuentaBancaria cuentaBanamex = new CuentaBancaria();
        cuentaBanamex.setNumeroCuenta("98765432");
        cuentaBanamex.setTitular("Diego Garza Avalos");
        cuentaBanamex.setSaldo(5000);
        
        System.out.println("Saldo inicial: " + cuentaBanamex.getSaldo());
        
        cuentaBanamex.depositar(500);
        
        System.out.println("Saldo despues de deposito: " + cuentaBanamex.getSaldo());
        
        cuentaBanamex.retirar(400);
        
        System.out.println("Saldo despues de retiro: " + cuentaBanamex.getSaldo());
        
        cuentaBanamex.retirar(6400);
        
    }
    
}
