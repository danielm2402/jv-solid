/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import access.IVehicleRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import access.RepositoryFactory;
import co.unicauca.parqueadero.domain.EnumVehiculo;
import co.unicauca.parqueadero.domain.Vehiculo;
import java.time.LocalTime;
import service.Service;
import java.time.LocalTime;
import java.util.List;
/**
 *
 * @author daniel2402
 */
public class testServices {
    
    public testServices() {
    }

    @Test
    public void testSave() throws ParseException {
    
        IVehicleRepository repository = RepositoryFactory.getInstance().getRepository("default");
        Service service = new Service(repository);

        Vehiculo newVehiculo = new Vehiculo("JLM12", EnumVehiculo.valueOf("MOTO"), LocalTime.parse("02:24:27"));
        boolean save= service.saveVehicle(newVehiculo);
       
        assertEquals(true,save );
       
    }
    public void testGetVehiculo() throws ParseException {
    
        IVehicleRepository repository = RepositoryFactory.getInstance().getRepository("default");
        Service service = new Service(repository);

        Vehiculo newVehiculo = new Vehiculo("JLM12", EnumVehiculo.valueOf("MOTO"), LocalTime.parse("02:24:27"));
        Vehiculo vh= service.getVehiculo("JLM12");
      
        assertEquals(vh.getPlaca(),newVehiculo.getPlaca() );
       
    }
    public void testListVehiculos() throws ParseException {
    
        IVehicleRepository repository = RepositoryFactory.getInstance().getRepository("default");
        Service service = new Service(repository);
       List<Vehiculo> Lv= service.listProducts();
       
        assertEquals(1,Lv.size() );
       
    }
    


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
