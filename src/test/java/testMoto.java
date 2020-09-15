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

public class testMoto {
    public void testMoto() throws ParseException {
        costoMoto instance = new costoMoto();

        double ResultadoOP = 1300;
        Vehiculo newVehiculo = new Vehiculo("JLM13", EnumVehiculo.valueOf("MOTO"), LocalDateTime.parse("2017-12-05T11:30:30"));
        
        double resultado = instance.CalcularCosto(newVehiculo, LocalDateTime.parse("2017-12-05T11:00:00"), LocalDateTime.parse("2017-12-05T12:31:00"));
        assertEquals(ResultadoOP,resultado); 
        
        resultado = instance.CalcularCosto(newVehiculo, LocalDateTime.parse("2017-12-05T11:00:00"), LocalDateTime.parse("2017-12-05T11:30:00"));
        ResultadoOP = 1000;
        assertEquals(ResultadoOP,resultado); 
        
        resultado = instance.CalcularCosto(newVehiculo, LocalDateTime.parse("2017-12-05T11:00:00"), LocalDateTime.parse("2017-12-05T13:00:00"));
        ResultadoOP = 1500;
        assertEquals(ResultadoOP,resultado); 
        
        resultado = instance.CalcularCosto(newVehiculo, LocalDateTime.parse("2017-12-05T09:10:00"), LocalDateTime.parse("2017-12-05T06:50:00"));
        ResultadoOP = 10000;
        assertNotEquals(ResultadoOP,resultado); 
        
        resultado = instance.CalcularCosto(newVehiculo, LocalDateTime.parse("2017-12-05T09:39:00"), LocalDateTime.parse("2017-12-05T11:10:00"));
        ResultadoOP = 1300;
        assertEquals(ResultadoOP,resultado); 

    }
}
