/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.domain;

import java.util.Map;
import java.util.EnumMap;

/**
 *
 * @author jafes
 */
public class fabricaVehiculo {

    private Map<EnumVehiculo, ICostParking> dictionary;

    private static fabricaVehiculo instance;

    private fabricaVehiculo() {
        dictionary = new EnumMap<>(EnumVehiculo.class);
        dictionary.put(EnumVehiculo.MOTO, new costoMoto());
        dictionary.put(EnumVehiculo.CARRO, new costoCarro());
        dictionary.put(EnumVehiculo.CAMION, new costoCamion());
    }

    public static fabricaVehiculo getInstance() {
        if (instance == null) {
            instance = new fabricaVehiculo();
        }
        return instance;
    }

    public ICostParking getCostParking(EnumVehiculo vehiculo) {

        ICostParking result = null;

        if (dictionary.containsKey(vehiculo)) {
            result = dictionary.get(vehiculo);
        }

        return result;

    }

}
