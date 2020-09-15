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

    /**
     * Interfarce principio O/C
     *
     * @param veh pasa el objeto vehiculo
     * @param entrada la hora con fecha de entrada al parqueadero
     * @param salida la hora con fecha de salida del parqueadero
     * @return
     */
    public double CalcularCosto(Vehiculo veh, LocalDateTime entrada, LocalDateTime salida);

}
