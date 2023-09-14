package com.mycompany.proyecto1;

import java.math.*;
import java.util.*;

public class Proyecto1
{
    /*
    -En el siguien ejercicio se va a tener encuenta la informacion de unas fabricas de confecio
    las cuales son muy comunes en el municipio de Donmatias en el cual vivo logrando aprenciar con datos ficticios
    las ganancias que tiene con una produccion la empresa que mas produce entre otros analisis basados en
    la siguiente informacion.
    Nombrefabrica,N*Operarios, HorasTrabajadas, TipoTela, N°Maquinas, TiempoCreacionTotalU, TipoPrenda, N°unidade,TotalaResivir.
    Es importante destacar que la informacion aqui proporsionada es completamente inventada y no representa una medida precisa de lo 
    realizado en estas fabricas de confeccion
    
    */
public static void main(String[] args)
{

    record InformacionFabricas(String NombreFabrica, int NOperarios, int HorasTrabajadas, String TipoTela,int NMaquinas, int TiempoCreacionTotalU, String TipoPrenda, 
        int Nunidades, int ValorUnidad)
        {
            double ValorPago()
            {
                return Nunidades*ValorUnidad;
            }
            
            double diasproduccion()
            {
                return (TiempoCreacionTotalU*Nunidades)/HorasTrabajadas;
            }
        };

    InformacionFabricas[] data = new InformacionFabricas[20];
    data[0] = new InformacionFabricas("KevinJeans",15,12,"indigo",10,1,"pantalones",500,12000);
    data[1] = new InformacionFabricas("Y&K",80,14,"crudo",80,2,"pantalones",5000,30000);
    data[2] = new InformacionFabricas("Montero",85,8,"liviana",50,2,"camisas",1200,50000);
    data[3] = new InformacionFabricas("Scuare",50,12,"indigo",60,3,"chaquetas",1500,10000);
    data[4] = new InformacionFabricas("ConfeccionesS.A",20,8,"indigo",15,2,"chores",1200,20000);
    data[5] = new InformacionFabricas("L&N",78,10,"indigo",60,2,"pantalones",12000,8000);
    data[6] = new InformacionFabricas("confesiones cochabamba",35,11,"indigo",2,8,"pantalones",5000,10000);
    data[7] = new InformacionFabricas("Gamin",60,10,"indigo",60,3,"pantalones",5000,50000);
    data[8] = new InformacionFabricas("Cosmos",45,12,"indigo",30,4,"pantalones",6000,15000);    
    data[9] = new InformacionFabricas("El gato",65,12,"crudo",70,3,"pantalones",11000,20000);
    data[10] = new InformacionFabricas("Chevignon",30,12,"indigo",32,4,"chaquetas",8000,50000);
    data[11] = new InformacionFabricas("Lexus",8,7,"algodon",5,3,"camisas",500,25000);
    data[12] = new InformacionFabricas("Creaciones",28,14,"indigo",12,4,"pantalones",400,8000);
    data[13] = new InformacionFabricas("Muñetones",22,13,"indigo",18,2,"pantalones",10000,12000);
    data[14] = new InformacionFabricas("Confeciones",45,15,"indigo",40,3,"pantalones",1600,28000);
    data[15] = new InformacionFabricas("JeansB",34,15,"indigo",30,3,"pantalones",500,28000);
    data[16] = new InformacionFabricas("CDF",36,15,"indigo",36,3,"pantalones",1000,28000);
    data[17] = new InformacionFabricas("Prointex",24,15,"indigo",24,3,"pantalones",1300,28000);
    data[18] = new InformacionFabricas("Osmy Jeans",20,15,"indigo",20,3,"pantalones",1500,28000);
    data[19] = new InformacionFabricas("Confeccionees Berlin",15,15,"indigo",12,3,"pantalones",1100,28000);
    
    //Declaracion de variables globales
    int cantidadpersona=0, mayorempleados=0,acumuladorunidades=0,unidades=0;
    String Nombre="";
    double promdinero, promunidades,acumuladordinero=0,mayorg=0,dias=Double.MAX_VALUE;
 
    
    //Calcular la cantidad de personas que trabajan en una fabrica de confeccion
    for(InformacionFabricas inf:data)
    {
        cantidadpersona += inf.NOperarios();
    }
    System.out.println("La cantidad de personas que trabajan en estas fabricas de confección: "+cantidadpersona);
    System.out.println("-------------------------------------------------------------------------------------");
    
    //Empresa con mas operarios
    System.out.println("-------------------------------------------------------------------------------------");
    for(InformacionFabricas informacion:data)
    {
        if(informacion.NOperarios()>mayorempleados)
        {
            mayorempleados=informacion.NOperarios();
            Nombre=informacion.NombreFabrica();
        }
    }
    System.out.println("La fabrica: "+ Nombre +" tiene el numero mayor de empleados : "+mayorempleados);
    System.out.println("-------------------------------------------------------------------------------------");
    //Calcular el promedio de dinero entre todas las fabricas mas el promedio de unidades por entregar 
    System.out.println("-------------------------------------------------------------------------------------");
    for(InformacionFabricas informacion:data)
    {
        acumuladorunidades += informacion.Nunidades();
        acumuladordinero += informacion.ValorPago();
        
        if(informacion.ValorPago()>mayorg)
        {
            mayorg=informacion.ValorPago();
            Nombre=informacion.NombreFabrica();
        }
    }
    promdinero = acumuladordinero/data.length;
    promunidades = acumuladorunidades/data.length;
    
    //BigInteger bi = BigDecimal.valueOf(Math.PI).toBigIntegerExact();
    
    
    BigInteger promd = BigDecimal.valueOf(promdinero).toBigInteger();
    BigInteger mg = BigDecimal.valueOf(mayorg).toBigInteger();
    System.out.println("La media del dinero entre todas las empresas " +promd+" $");
    System.out.println("La empresa que mas gano dinero fue: "+Nombre+" con un total de: "+mg+" $ ");
    System.out.println("-------------------------------------------------------------------------------------");
    
    //Calcular el tiempo que se demoran en cada fabrica en sacar una produccion y la fabrica que menos se demora en sacar esto
    System.out.println("-------------------------------------------------------------------------------------");
    for(InformacionFabricas informacion:data)
    {
   
        
        if(informacion.diasproduccion()<dias)
            {
                dias=informacion.diasproduccion();
                Nombre=informacion.NombreFabrica();
                unidades=informacion.Nunidades();
            }
    }
    System.out.println("La fabrica que menos se demora es: "+Nombre+" con un total de: "+dias+" dias, generando una produccion de: "+unidades+" Unidades");
    System.out.println("-------------------------------------------------------------------------------------");
    
    //La fabrica que mas unidades produce
    System.out.println("-------------------------------------------------------------------------------------");
    InformacionFabricas fabricaMaxUnidades = data[0]; // Inicializa con la primera fábrica
    for (InformacionFabricas fabrica : data) {
    if (fabrica.Nunidades > fabricaMaxUnidades.Nunidades) {
        fabricaMaxUnidades = fabrica;
     }
    }
     System.out.println("La fábrica que produce más unidades es " + fabricaMaxUnidades.NombreFabrica);
    System.out.println("-------------------------------------------------------------------------------------");
     
     
    //Mostrar la Mediana de operarios
       System.out.println("-------------------------------------------------------------------------------------");
    int[] numOperarios = new int[data.length];
    for (int i = 0; i < data.length; i++) {
        numOperarios[i] = data[i].NOperarios;
        }

    // Ordenar el arreglo en orden ascendente
    Arrays.sort(numOperarios);

    // Calcular la mediana
    int mediana;
    if (numOperarios.length % 2 == 0) {
     // Si hay un número par de elementos, tomar el promedio de los dos valores centrales
        int medio1 = numOperarios[numOperarios.length / 2 - 1];
        int medio2 = numOperarios[numOperarios.length / 2];
        mediana = (medio1 + medio2) / 2;
    } else {
    // Si hay un número impar de elementos, tomar el valor central
    mediana = numOperarios[numOperarios.length / 2];
    }

    System.out.println("La mediana del número de operarios es: " + mediana);
       System.out.println("-------------------------------------------------------------------------------------");
     
    //La fabrica mas eficiente el menor tiempo de produccion de unidades
       System.out.println("-------------------------------------------------------------------------------------");
        double minTiempoPorUnidad = Double.MAX_VALUE;
        String fabricaMinTiempo = "";

        for (InformacionFabricas fabrica : data) {
            double tiempoPorUnidad = (double) fabrica.diasproduccion() / fabrica.Nunidades;
            if (tiempoPorUnidad < minTiempoPorUnidad) {
                minTiempoPorUnidad = tiempoPorUnidad;
                fabricaMinTiempo = fabrica.NombreFabrica;
            }
        }

        System.out.println("La fábrica con la producción más eficiente es: " + fabricaMinTiempo);
        System.out.println("El tiempo promedio por unidad es: " + minTiempoPorUnidad + " días/unidad");

   System.out.println("-------------------------------------------------------------------------------------");
   System.out.println("-------------------------------------------------------------------------------------");
    
}

}    




    
  
    
