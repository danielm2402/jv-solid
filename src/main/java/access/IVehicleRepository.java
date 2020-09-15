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
public interface IVehicleRepository {
    boolean save(Vehiculo newVehiculo);
    Vehiculo getVehiculo(String placa);
    List<Vehiculo> list();
}
