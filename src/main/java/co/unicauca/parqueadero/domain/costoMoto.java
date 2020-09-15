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
public class costoMoto implements ICostParking {


    @Override
    public double CalcularCosto(Vehiculo veh, LocalDateTime entrada, LocalDateTime salida) {
        int varEntradaH=entrada.getHour();  
        int varEntradaM=entrada.getMinute();
        int varSalidaH=salida.getHour();
        int varSalidaM=salida.getMinute();
        int result;
        double cobroPorMinuto= 8.32;
        if( varSalidaH > varEntradaH  )
        {
            if (varSalidaM >= varEntradaM){                
                result = (varSalidaH-varEntradaH)*60+(varSalidaM-varEntradaM);
                if (result<=60){
                    return 1000;
                }else{
                    int recargo =(int) ((result-60)*8.32);
                    double aux = (double)recargo/100;
                    if(aux-recargo/100>0.50)
                        return ((recargo/100)*100)+100+1000;
                    else
                        return aux*100+1000;                 
                }
            }else{
                varSalidaH=varSalidaH-1;
                varSalidaM=varSalidaM+60;
                result = (varSalidaH-varEntradaH)*60+(varSalidaM-varEntradaM); 
                if (result<=60){
                    return 1000;
                }else{
                    int recargo =(int) ((result-60)*8.32);
                    double aux = (double)recargo/100;
                    if(aux-recargo/100>0.50)
                        return ((recargo/100)*100)+100+1000;
                    else
                        return aux*100+1000;                
                }
            }
            
        }else{
            if(varSalidaH == varEntradaH ){
                if(varSalidaM > varEntradaM){
                    return 1000;
                }
            }
        }
        
        return 0;
    }
    
}
