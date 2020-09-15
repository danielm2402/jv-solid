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
import java.time.LocalDateTime;
import co.unicauca.parqueadero.domain.EnumVehiculo;

/**
 *
 * @author daniel2402
 */
public class VehicleRepository implements IVehicleRepository {

    //objeto de tipo conexión para la base de datos
    private Connection conn;

    /**
     * Método que consulta en la base de datos un vehiculo por placa
     *
     * @param placa placa a consultar
     * @return el vehiculo al que corresponde la placa dada
     */
    @Override
    public Vehiculo getVehiculo(String placa) {
        Vehiculo objVehiculo = new Vehiculo();
        try {
            String sql = "SELECT * FROM Vehicle where Placa =" + "'" + placa + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                objVehiculo.setPlaca(rs.getString("Placa"));
                objVehiculo.setTipoVehiculo(EnumVehiculo.valueOf(rs.getString("Tipo")));
                objVehiculo.setEntrada(LocalDateTime.parse(rs.getString("Entrada")));

            }

        } catch (SQLException ex) {

            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objVehiculo;
    }

    /**
     * Constructor de la clase VehicleRepository
     */
    public VehicleRepository() {
        initDatabase();
    }

    /**
     * Método que guarda un vehiculo en la base de datos
     *
     * @param newVehiculo objeto de tipo vehiculo que se va a almacenar
     * @return true si se guardó correctamente, false sino
     */
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

    /**
     * Método que consulta a la base de datos todos los vehiculos registrados en
     * la base de datos
     *
     * @return Lista de tipo Vehiculo
     */
    @Override
    public List<Vehiculo> list() {
        List<Vehiculo> vehicles = new ArrayList<>();
        try {

            String sql = "SELECT * FROM Vehicle";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Vehiculo newVehicle = new Vehiculo();

                newVehicle.setPlaca(rs.getString("Placa"));
                newVehicle.setTipoVehiculo(EnumVehiculo.valueOf(rs.getString("Tipo")));
                newVehicle.setEntrada(LocalDateTime.parse(rs.getString("Entrada")));

                vehicles.add(newVehicle);
            }
            //this.disconnect();

        } catch (SQLException ex) {

            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicles;
    }

    /**
     * Método que inicia la base de datos y crea la tabla Vehicle en caso de no
     * existir
     */
    private void initDatabase() {

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Vehicle (\n"
                + "	Placa text PRIMARY KEY,\n"
                + "	Tipo text NOT NULL,\n"
                + "	Entrada text NOT NULL\n"
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

    /**
     * Método que se encarga de realizar la conexión a la base de datos
     */
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

    //Método que se encarga de cerrar la conexión a la base de datos
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
