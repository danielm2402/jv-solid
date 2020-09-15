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
      public static RepositoryFactory getInstance() {

        if (instance == null) {
            instance = new RepositoryFactory();
        }
        return instance;

    }

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
