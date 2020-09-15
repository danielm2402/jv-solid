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
import java.time.LocalTime;
import service.Service;

/**
 *
 * @author daniel2402
 */
public class ClientMain {
    public static void main(String[] args) {
   IVehicleRepository repository = RepositoryFactory.getInstance().getRepository("default");
        Service service = new Service(repository);
        Vehiculo newVehiculo = new Vehiculo("ASF", EnumVehiculo.valueOf("MOTO"),LocalTime.parse("02:24:27"));
        service.saveVehicle(newVehiculo);
     System.out.println("LA LISTA DE VEHICULOS ES:");

        for (Vehiculo p : service.listVehiculos()) {
            System.out.println(p.getPlaca());
        }
    
    }
}
