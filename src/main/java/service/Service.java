/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import access.IVehicleRepository;
import co.unicauca.parqueadero.domain.ICostParking;
import co.unicauca.parqueadero.domain.Vehiculo;
import co.unicauca.parqueadero.domain.fabricaVehiculo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author daniel2402
 */
public class Service {

    private IVehicleRepository repository;

    public Service(IVehicleRepository repository) {
        this.repository = repository;
    }

    /**
     * Método que envuelve como servicio el cálculo del pago por el servicio de
     * parking
     *
     * @param vehiculo vehiculo al cual calcular el total
     * @param input hora de entrada
     * @param output hora de salida
     * @return
     */
    public double facturarPago(Vehiculo vehiculo, LocalDateTime input, LocalDateTime output) {

        //Validate product.
        if (vehiculo == null) {
            return -1;
        }
        ICostParking delivery = fabricaVehiculo.getInstance().getCostParking(vehiculo.getTipoVehiculo());
        double total = delivery.CalcularCosto(vehiculo, input, output);
        return total;
        //TODO
    }

    /**
     * Servicio que envuelve el método save vehiculo de la interfaz repositorio
     *
     * @param newVehicle vehiculo a guardar
     * @return true si se guardó correctamente, false sino
     */
    public boolean saveVehicle(Vehiculo newVehicle) {

        //Validate product
        if (newVehicle == null || newVehicle.getPlaca().isBlank()) {
            return false;
        }

        repository.save(newVehicle);
        return true;

    }

    /**
     * Método que envuelve el método getVehiculo de la interfaz repository
     *
     * @param placa placa a buscar
     * @return devuelve el vehiculo que corresponde a esa placa
     */
    public Vehiculo getVehiculo(String placa) {
        Vehiculo objVehiculo = new Vehiculo();
        objVehiculo = repository.getVehiculo(placa);
        return objVehiculo;
    }

    /**
     * Método que envuelve el método listar vehiculos de la interfaz repository
     *
     * @return devuelve la lista de vehiculos actuales
     */
    public List<Vehiculo> listVehiculos() {
        List<Vehiculo> vehicles = new ArrayList<>();
        vehicles = repository.list();;

        return vehicles;
    }
}
