/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.domain;

import java.time.LocalDateTime;

/**
 *
 * @author jafes
 */
public interface ICostParking {
    
    public double CalcularCosto (Vehiculo veh, LocalDateTime entrada, LocalDateTime salida);
    
}
