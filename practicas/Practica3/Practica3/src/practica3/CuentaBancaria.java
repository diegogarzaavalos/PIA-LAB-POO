/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica3;

/**
 *
 * @author garza
 */


public class CuentaBancaria {
    
    private String numeroCuenta;
    private String titular;
    private double saldo;
    
    /**
     * @return the numeroCuenta
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * @param numeroCuenta the numeroCuenta to set
     */
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * @return the titular
     */
    public String getTitular() {
        return titular;
    }

    /**
     * @param titular the titular to set
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        if (saldo >= 0){
            this.saldo = saldo;
        }
        else{
            System.out.println("El saldo no puede ser negativo");
        }
    }
    
    public void depositar(double monto){
        if (monto >= 0 )
            this.saldo += monto;
        else
            System.out.println("El monto no puede ser negativo");
    }
    
    public void retirar(double monto){
        if (monto > 0 && monto <= saldo)
            saldo -= monto;
        else
            System.out.println("Sldo insuficiente o monto invalido");
    }
    
    
    
}
