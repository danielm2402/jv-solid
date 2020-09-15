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
public class costoCarro implements ICostParking{


    @Override
    public double CalcularCosto(Vehiculo veh, LocalDateTime entrada, LocalDateTime salida) {
        
        
        int varEntradaH=entrada.getHour();  
        int varEntradaM=entrada.getMinute();
        int varSalidaH=salida.getHour();
        int varSalidaM=salida.getMinute();
        int result,aux;
        double cobroPorMinuto= 16.67;
        if( varSalidaH > varEntradaH  )
        {
            if (varSalidaM >= varEntradaM){                
                result = (varSalidaH-varEntradaH)*60+(varSalidaM-varEntradaM);
                if (result<=60){
                    return 2000;
                }else{
                    int recargo =(int) ((result-60)*cobroPorMinuto);
                    double decimal = (double)recargo/100;
                    if(decimal-recargo/100>0.50)
                        return ((recargo/100)*100)+100+2000;
                    else
                        aux = (int) decimal;
                        return (aux*100)+2000;                 
                }
            }else{
                varSalidaH=varSalidaH-1;
                varSalidaM=varSalidaM+60;
                result = (varSalidaH-varEntradaH)*60+(varSalidaM-varEntradaM); 
                if (result<=60){
                    return 2000;
                }else{
                    int recargo =(int) ((result-60)*cobroPorMinuto);
                    double decimal = (double)recargo/100;
                    if(decimal-recargo/100>0.50)
                        return ((recargo/100)*100)+100+2000;
                    else
                        aux = (int) decimal;
                        return (aux*100)+2000;                  
                }
            }
            
        }else{
            if(varSalidaH == varEntradaH ){
                if(varSalidaM > varEntradaM){
                    return 2000;
                }
            }
        }
        
        return 0;
    }
    
    
}
