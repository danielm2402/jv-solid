/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import access.IVehicleRepository;
import co.unicauca.parqueadero.domain.Vehiculo;
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
    public double facturarPago(Vehiculo vehiculo) {

        //Validate product.
        if (vehiculo == null) {
            return 0;
        }
        return 0;
       //TODO
    }

    public boolean saveVehicle(Vehiculo newVehicle) {

        //Validate product
        if (newVehicle == null || newVehicle.getPlaca().isBlank()) {
            return false;
        }

        repository.save(newVehicle);
        return true;

    }

    public List<Vehiculo> listProducts() {
        List<Vehiculo> vehicles = new ArrayList<>();
        vehicles = repository.list();;

        return vehicles;
    } 
}
