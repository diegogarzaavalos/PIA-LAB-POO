/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package animales;

/**
 *
 * @author garza
 */
public interface ITerrestre {
    
    void correr();
    
    default int distanciaMax(){
        return 200;
    }
}
