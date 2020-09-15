/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import access.IVehicleRepository;
import access.RepositoryFactory;
import co.unicauca.parqueadero.domain.EnumVehiculo;
import co.unicauca.parqueadero.domain.Vehiculo;
import java.time.LocalDateTime;
import service.Service;

/**
 *
 * @author daniel2402
 */
public class ClientMain {
    public static void main(String[] args) {
   IVehicleRepository repository = RepositoryFactory.getInstance().getRepository("default");
        Service service = new Service(repository);
        Vehiculo newVehiculo = new Vehiculo("ASF", EnumVehiculo.valueOf("MOTO"),LocalDateTime.parse("2017-12-05T11:30:30"));
        service.saveVehicle(newVehiculo);
         Vehiculo newVehiculo1 = new Vehiculo("XLM", EnumVehiculo.valueOf("CARRO"),LocalDateTime.parse("2017-12-05T11:40:30"));
        service.saveVehicle(newVehiculo1);
         Vehiculo newVehiculo2 = new Vehiculo("LOI", EnumVehiculo.valueOf("CAMION"),LocalDateTime.parse("2017-12-05T11:50:30"));
        service.saveVehicle(newVehiculo2);
     System.out.println("LA LISTA DE PLACAS DE VEHICULOS ES:");

        for (Vehiculo p : service.listVehiculos()) {
            System.out.println(p.getPlaca());
        }
    
    }
}
