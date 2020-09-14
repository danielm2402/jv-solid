/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.domain;

import java.time.LocalDate;

/**
 *
 * @author jafes
 */
public class costoCarro implements ICostParking{

    @Override
    public double CalcularCosto(Vehiculo veh, LocalDate entrada, LocalDate salida) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
