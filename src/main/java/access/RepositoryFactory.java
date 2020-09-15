/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import access.IVehicleRepository;
import access.VehicleRepository;

/**
 *
 * @author daniel2402
 */
public class RepositoryFactory {

    private static RepositoryFactory instance;

    private RepositoryFactory() {

    }

    /**
     * Clase singleton
     *
     * @return la clase singleton
     */
    public static RepositoryFactory getInstance() {

        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;

    }

    /**
     * Método que crea una instancia concreta de la jerarquia IVehicleRepository
     *
     * @param type cadena que indica qué tipo de clase hija debe instanciar
     * @return clase hija de la abstracción IVehicleRepository
     */
    public IVehicleRepository getRepository(String type) {

        IVehicleRepository result = null;

        switch (type) {
            case "default":
                result = new VehicleRepository();
                break;
        }

        return result;

    }
}
