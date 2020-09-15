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
import java.time.LocalDate;
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
    public double facturarPago(Vehiculo vehiculo, LocalDate input, LocalDate output) {

        //Validate product.
        if (vehiculo == null) {
            return -1;
        }
        ICostParking delivery = fabricaVehiculo.getInstance().getCostParking(vehiculo.getTipoVehiculo());
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
    public Vehiculo getVehiculo(String placa){
        Vehiculo objVehiculo=new Vehiculo();
        objVehiculo= repository.getVehiculo(placa);
        return objVehiculo;
    }
    public List<Vehiculo> listProducts() {
        List<Vehiculo> vehicles = new ArrayList<>();
        vehicles = repository.list();;

        return vehicles;
    } 
}
