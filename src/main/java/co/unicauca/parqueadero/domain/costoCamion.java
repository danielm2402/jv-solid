/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.parqueadero.domain;

import java.time.LocalDateTime;

/**
 *
 * @author jafes
 */
public class costoCamion implements ICostParking {

    @Override
    public double CalcularCosto(Vehiculo veh, LocalDateTime entrada, LocalDateTime salida) {
        int varEntradaH = entrada.getHour();
        int varEntradaM = entrada.getMinute();
        int varSalidaH = salida.getHour();
        int varSalidaM = salida.getMinute();
        int result;
        double cobroPorMinuto = 16.67;
        if (varSalidaH > varEntradaH) {
            if (varSalidaM >= varEntradaM) {
                result = (varSalidaH - varEntradaH) * 60 + (varSalidaM - varEntradaM);
                if (result <= 60) {
                    return 2000;
                } else {
                    int recargo = (int) ((result - 60) * 8.32);
                    int aux = (int) (recargo / 100);
                    if (aux - recargo / 100 > 50) {
                        return recargo + 100 + 2000;
                    } else {
                        return aux * 100 + 2000;
                    }
                }
            } else {
                varSalidaH = varSalidaH - 1;
                varSalidaM = varSalidaM + 60;
                result = (varSalidaH - varEntradaH) * 60 + (varSalidaM - varEntradaM);
                if (result <= 60) {
                    return 2000;
                } else {
                    int recargo = (int) ((result - 60) * 8.32);
                    int aux = (int) (recargo / 100);
                    if (aux - recargo / 100 > 50) {
                        return recargo + 100 + 1000;
                    } else {
                        return aux * 100 + 2000;
                    }
                }
            }

        } else {
            if (varSalidaH == varEntradaH) {
                if (varSalidaM > varEntradaM) {
                    return 2000;
                }
            }
        }

        return 0;
    }
    
}
