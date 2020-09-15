/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.domain;

/**
 *
 * @author jafes
 */
public enum EnumVehiculo {
    MOTO("MOTO"),
    CARRO("CARRO"),
    CAMION("CAMION");
    
    private final String value;
    EnumVehiculo(String value) {
        this.value = value;
    }

   

  
}
