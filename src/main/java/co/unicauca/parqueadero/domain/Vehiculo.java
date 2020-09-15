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
public class Vehiculo {
    
    private String placa;
    private EnumVehiculo tipoVehiculo;
    private LocalDateTime Entrada;  

    /**
     * Método constructor por defecto de Vehiculo
     *
     * 
     */
    public Vehiculo(){
        
    }
    /**
     * Constructor parametrizado de Vehiculo
     *
     * @param placa
     * @param tipo
     * @param entrada
     */
    public Vehiculo(String placa, EnumVehiculo tipo, LocalDateTime entrada){
        this.placa=placa;
        this.tipoVehiculo=tipo;
        this.Entrada=entrada;
    }
    /**
     * Establece el valor de la entrada de un vehiculo 
     * @param Entrada 
     */
    public void setEntrada(LocalDateTime Entrada) {
        this.Entrada = Entrada;
    }

    /**
     * Obtiene la entrada del objeto vehiculo
     * @return El tiempo en el que entró el vehiculo
     */
    public LocalDateTime getEntrada() {
        return Entrada;
    }

    /**
     * Obtiene el valor de la placa del objeto vehiculo
     * @return el valor de la placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Establece el valor de la placa de un objeto vehiculo
     * @param placa 
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * Obtiene el valor del tipo de vehiculo al que pertenece el objeto vehiculo
     * @return el tipo de vehiculo 
     */
    public EnumVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }
/**
 * Establece el valor del tipo de vehiculo del objeto vehiculo
 * @param tipoVehiculo 
 */
    public void setTipoVehiculo(EnumVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
    
    
}
