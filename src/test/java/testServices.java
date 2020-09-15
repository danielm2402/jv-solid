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
import co.unicauca.parqueadero.domain.costoCamion;
import co.unicauca.parqueadero.domain.costoMoto;
import co.unicauca.parqueadero.domain.fabricaVehiculo;
import service.Service;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author daniel2402
 */
public class testServices {

    public testServices() {
    }

    @Test
    public void testMoto() throws ParseException {
        costoMoto instance = new costoMoto();

        double ResultadoOP = 1300;
        Vehiculo newVehiculo = new Vehiculo("JLM13", EnumVehiculo.valueOf("MOTO"), LocalDateTime.parse("2017-12-05T11:30:30"));
        double resultado = instance.CalcularCosto(newVehiculo, LocalDateTime.parse("2017-12-05T11:00:00"), LocalDateTime.parse("2017-12-05T12:31:00"));
        assertEquals(ResultadoOP,resultado); 
        resultado = instance.CalcularCosto(newVehiculo, LocalDateTime.parse("2017-12-05T11:00:00"), LocalDateTime.parse("2017-12-05T12:00:00"));
        ResultadoOP = 1000;
        assertEquals(ResultadoOP,resultado); 
        resultado = instance.CalcularCosto(newVehiculo, LocalDateTime.parse("2017-12-05T11:00:00"), LocalDateTime.parse("2017-12-05T13:00:00"));
        ResultadoOP = 1500;
        assertEquals(ResultadoOP,resultado); 
        resultado = instance.CalcularCosto(newVehiculo, LocalDateTime.parse("2017-12-05T09:10:00"), LocalDateTime.parse("2017-12-05T06:50:00"));
        ResultadoOP = 10000;
        assertNotEquals(ResultadoOP,resultado); 
        resultado = instance.CalcularCosto(newVehiculo, LocalDateTime.parse("2017-12-05T09:39:00"), LocalDateTime.parse("2017-12-05T11:10:00"));
        ResultadoOP = 1400;
        assertEquals(ResultadoOP,resultado); 

    }

    public void testSave() throws ParseException {

        IVehicleRepository repository = RepositoryFactory.getInstance().getRepository("default");
        Service service = new Service(repository);

        Vehiculo newVehiculo = new Vehiculo("JLM12", EnumVehiculo.valueOf("MOTO"), LocalDateTime.parse("2017-12-05T11:30:30"));
        boolean save= service.saveVehicle(newVehiculo);
       
        assertEquals(true,save );
       
    }
    @Test
    public void testGetVehiculo() throws ParseException {

        IVehicleRepository repository = RepositoryFactory.getInstance().getRepository("default");
        Service service = new Service(repository);

        Vehiculo newVehiculo = new Vehiculo("ASF", EnumVehiculo.valueOf("MOTO"),LocalDateTime.parse("2017-12-05T11:30:30"));
        service.saveVehicle(newVehiculo);
        Vehiculo vh= service.getVehiculo("ASF");
      
        assertEquals(vh.getPlaca(),"ASF" );
       
    }
    @Test
    public void testListVehiculos() throws ParseException {

        IVehicleRepository repository = RepositoryFactory.getInstance().getRepository("default");
        Service service = new Service(repository);
         Vehiculo newVehiculo = new Vehiculo("TYA", EnumVehiculo.valueOf("MOTO"),LocalDateTime.parse("2017-12-05T11:30:30"));
        service.saveVehicle(newVehiculo);
         Vehiculo newVehiculo1 = new Vehiculo("AFF", EnumVehiculo.valueOf("MOTO"),LocalDateTime.parse("2017-12-05T11:30:30"));
        service.saveVehicle(newVehiculo1);
       List<Vehiculo> Lv= service.listVehiculos();
        assertEquals(2,Lv.size() );
       
    }
    @Test
 public void testFactura() throws ParseException {
    
        IVehicleRepository repository = RepositoryFactory.getInstance().getRepository("default");
        Service service = new Service(repository);
         Vehiculo newVehiculo = new Vehiculo("TYA", EnumVehiculo.valueOf("MOTO"),LocalDateTime.parse("2017-12-05T09:39:00"));
        service.saveVehicle(newVehiculo);
         
        //OBTENEMOS LA HORA DE ENTRADA de la base de datos
      LocalDateTime input= service.getVehiculo("TYA").getEntrada();
      //OBTENEMOS EL TOTAL A PAGAR
     double total= service.facturarPago(newVehiculo, input, LocalDateTime.parse("2017-12-05T11:10:00"));
     assertEquals(1300,total );
       
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
