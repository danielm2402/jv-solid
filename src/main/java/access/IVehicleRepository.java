/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.util.List;
import co.unicauca.parqueadero.domain.Vehiculo;

/**
 *
 * @author daniel2402
 */
/**
 *
 * Inteface Del vehiculo repositorio que define los metodos save vehiculo,
 * obtener vehiculo, y lista de vehiculos
 */
public interface IVehicleRepository {

    boolean save(Vehiculo newVehiculo);

    Vehiculo getVehiculo(String placa);

    List<Vehiculo> list();
}
