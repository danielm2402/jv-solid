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

/**
 * implementacion de la interface
 * @param veh tipo moto
 * @param entrada
 * @param salida
 * @return el valor a pagar del vehiculo
 */
    @Override
    public double CalcularCosto(Vehiculo veh, LocalDateTime entrada, LocalDateTime salida) {
        
        
        int varEntradaH=entrada.getHour();  //Int del tiempo en horas de la entrada
        int varEntradaM=entrada.getMinute();//int del tiempo en minutos de la entrada
        int varSalidaH=salida.getHour(); //Int del tiempo en horas de la salida
        int varSalidaM=salida.getMinute(); //Int del tiempo en minutos de la salida
        int result,aux;
        double cobroPorMinuto= 16.67;//tiempo estipulado por minuto de cobro 1000/60
        if( varSalidaH > varEntradaH  )//que la hora de entrada sea menor a la de salida
        {
            if (varSalidaM >= varEntradaM){                //comprobacion de minutos
                result = (varSalidaH-varEntradaH)*60+(varSalidaM-varEntradaM);//calcular coste de minutos adicionales
                if (result<=60){
                    return 2000; //si esta por debajo de la tarifa estandar
                }else{
                    int recargo =(int) ((result-60)*cobroPorMinuto); 
                    double decimal = (double)recargo/100;//redondear el numero a 100
                    if(decimal-recargo/100>0.50)
                        return ((recargo/100)*100)+100+2000; //pasar los numero a enteros y aumentar ceros
                    else
                        aux = (int) decimal;
                        return (aux*100)+2000;     //si no hay que redondear            
                }
            }else{
                varSalidaH=varSalidaH-1;  // si los minutos de salida son menos que lo de entrada
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
