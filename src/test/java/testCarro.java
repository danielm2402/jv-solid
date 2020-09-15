
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
import co.unicauca.parqueadero.domain.costoCarro;
import service.Service;
import java.time.LocalDateTime;

public class testCarro {
    public void testMoto() throws ParseException {

    costoCarro instance = new costoCarro();

    double ResultadoOP = 3000;
    Vehiculo newVehiculo = new Vehiculo("JLK13", EnumVehiculo.valueOf("CARRO"), LocalDateTime.parse("2017-12-05T11:30:30"));

    double resultado = instance.CalcularCosto(newVehiculo, LocalDateTime.parse("2017-12-05T11:00:00"), LocalDateTime.parse("2017-12-05T13:00:00"));
    assertEquals(ResultadoOP,resultado); 
    
    ResultadoOP=2000;
    resultado = instance.CalcularCosto(newVehiculo, LocalDateTime.parse("2017-12-05T11:00:00"), LocalDateTime.parse("2017-12-05T11:30:00"));
    assertEquals(ResultadoOP,resultado); 
    
    ResultadoOP=14000;
    resultado = instance.CalcularCosto(newVehiculo, LocalDateTime.parse("2017-12-05T01:00:00"), LocalDateTime.parse("2017-12-05T14:00:00"));
    assertEquals(ResultadoOP,resultado); 
    
    ResultadoOP=2000;
    resultado = instance.CalcularCosto(newVehiculo, LocalDateTime.parse("2017-12-05T09:50:00"), LocalDateTime.parse("2017-12-05T10:20:00"));
    assertEquals(ResultadoOP,resultado); 
    
    ResultadoOP=4500;
    resultado = instance.CalcularCosto(newVehiculo, LocalDateTime.parse("2017-12-05T09:50:00"), LocalDateTime.parse("2017-12-05T13:20:00"));
    assertEquals(ResultadoOP,resultado); 
    

    }
}
