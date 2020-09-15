/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;
import co.unicauca.parqueadero.domain.Vehiculo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.Service;
import java.time.LocalTime;
import co.unicauca.parqueadero.domain.EnumVehiculo;
/**
 *
 * @author daniel2402
 */
public class VehicleRepository implements IVehicleRepository {

     private Connection conn;

    @Override
    public Vehiculo getVehiculo(String placa) {
        Vehiculo objVehiculo = new Vehiculo();
        try{
        String sql = "SELECT Placa, Tipo, Entrada FROM Vehicle where Placa="+placa;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
                objVehiculo.setPlaca(rs.getString("Placa"));
                objVehiculo.setTipoVehiculo(EnumVehiculo.valueOf(rs.getString("Tipo")));
                objVehiculo.setEntrada(LocalTime.parse(rs.getString("Entrada")));

            }
        }
        catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objVehiculo;
    }

    public VehicleRepository() {
        initDatabase();
    }
    @Override
    public boolean save(Vehiculo newVehiculo) {
        try {
            //Validate product
            if (newVehiculo == null || newVehiculo.getPlaca().isBlank()) {
                return false;
            }
            //this.connect();

            String sql = "INSERT INTO Vehicle ( Placa, Tipo, Entrada ) "
                    + "VALUES ( ?, ?, ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newVehiculo.getPlaca());
            pstmt.setString(2, newVehiculo.getTipoVehiculo().name());
            pstmt.setString(3, newVehiculo.getEntrada().toString());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Vehiculo> list() {
        List<Vehiculo> vehicles = new ArrayList<>();
        try {

            String sql = "SELECT Placa, Tipo, Entrada FROM Vehicle";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vehiculo newVehicle = new Vehiculo();
        
                newVehicle.setPlaca(rs.getString("Placa"));
                newVehicle.setTipoVehiculo(EnumVehiculo.valueOf(rs.getString("Tipo")));
                newVehicle.setEntrada(LocalTime.parse(rs.getString("Entrada")));

                vehicles.add(newVehicle);
            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicles;
    }
     private void initDatabase() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Vehicle (\n"
                + "	Placa varchar(6) PRIMARY KEY,\n"
                + "	Tipo varchar(10) NOT NULL,\n"
                + "	Entrada varchar(50) NOT NULL\n"
                + ");";

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite:./mydatabase.db";
        String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
