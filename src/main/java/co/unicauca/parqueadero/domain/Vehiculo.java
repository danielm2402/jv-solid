/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.domain;
import java.time.LocalTime;

/**
 *
 * @author jafes
 */
public class Vehiculo {
    
    private String placa;
    private EnumVehiculo tipoVehiculo;
    private LocalTime Entrada;  

    public void setEntrada(LocalTime Entrada) {
        this.Entrada = Entrada;
    }

    public LocalTime getEntrada() {
        return Entrada;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public EnumVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(EnumVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
    
    
}
