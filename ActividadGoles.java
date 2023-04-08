/* 5 equipos de la liga inter-barrial identificados con los números 1, 2, 3,
4 y 5 participaron en un campeonato de fútbol en la modalidad todos
contra todos. Los goles anotados en cada encuentro se registraron en el
siguiente cuadro:

      | 1   2   3   4   5
    --|-------------------
    1 | 0   4   2   1   1 
    2 | 5   0   3   2   1
    3 | 0   2   0   1   2
    4 | 1   0   1   0   1
    5 | 2   1   0   0   0

Escribir un algoritmo que:
1. Llene una grilla con los resultados ingresados por teclado del
resultado de cada partido.
2. Muestre para cada equipo la cantidad de triunfos, empates y
derrotas.
3. Muestre para cada equipo la cantidad total de goles marcados y la
cantidad total de goles recibidos. */


package Tecnicatura.Programacion;

import java.util.Scanner;

public class ActividadGoles 
{
    //Funcion donde se imprimira la matriz con los goles
    public static void imprimirResultados(int[][] matriz) {
        System.out.println("\n");
        System.out.println("Grilla de resultados:\n");
        for(int i = 0; i < matriz.length; i++)
        {
            if (i == 0 )   
            {
                System.out.println("  |" + " 1  2  3  4  5");
                System.out.println("- - - - - - - - - ");
            }
            System.out.print((i + 1) + " |" );

            for(int j = 0; j < matriz.length; j++)
            {          
                System.out.print(" " + matriz[i][j] + " ");                
            }
            System.out.println("");
        }
    }
    
    //Funcion donde se validara el ingreso del usuario,donde solo se permitiran valores numericos enteros
    public static int validacionNumeroEntero(Scanner sc, String mensaje) {
        int entero = 0;
        boolean ingresoValido = false;

        while (!ingresoValido) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                entero = sc.nextInt();
                ingresoValido = true;
            } else {
                System.out.print("\n");
                System.out.println("*** ERROR de ingreso, solo se aceptan números enteros. ***");
                sc.next();
            }
        }
        return entero;
    }  



    public static void main(String[] args)
    {

        //Definicion de variables
        Scanner sc = new Scanner(System.in);
        int equipo1;
        int equipo2;
        int opcion;
        int[][] matriz = new int[5][5];
        int[] arrayGolesFavor = new int[5];
        int[] arrayGolesContra = new int[5];
        int[] arrayTriunfos = new int[5];
        int[] arrayEmpates = new int[5];
        int[] arrayPerdidos = new int[5];    


        System.out.print("\n");
        System.out.print("\n");
        for(int i = 0; i < matriz.length; i++)
        {
            for(int j = 0; j < matriz.length; j++)
            {
                //Se carga la matriz con los resultados y los goles a favor y en contra de cada equipo, siempre ingresara cuando i y j sean diferentes, esto se hace para evitar cargar goles de un equipo vs ese mismo equipo.                    
                if(i != j)
                {
                    matriz[i][j] = validacionNumeroEntero(sc, "Ingrese los goles convertidos por el equipo " + (i+1) + " contra " + (j+1) + ": ");                  
                }else{
                    matriz[i][j] = 0;
                }
            }
        }              


        //Se muestra la matriz inicial con los goles convertidos, se llama a la funcion imprimirResultados pasando la matriz como parametro.
        imprimirResultados(matriz);
        

        // Se le da la opcion al usuario de realizar alguna modificacion en la grilla, por eso en la linea anterior se la muestra para que corrobore los ingresado.
        //Se realizaran diferentes verificaciones para que no ingrese tanto la opcion como los valores de los equipos 

        System.out.print("\n");
        opcion = validacionNumeroEntero(sc, "¿Desea realizar alguna modificacion en la grilla? (1-SI, 2-NO): ");
        while (opcion < 1 || opcion > 2) //Se valida que solo se ingrese valor de 1 0 2
        {
            System.out.print("*** ERROR de ingreso, debe ser 1 o 2 ***");   
            opcion = validacionNumeroEntero(sc, "¿Desea realizar alguna modificacion en la grilla? (1-SI, 2-NO): ");
        }        
        if(opcion == 1) 
        {
            while (opcion == 1 ) //Ciclo que se ejecutara mientras la opcion ingresada por el usuario se a1 (modifica la grilla)
            {
                System.out.print("\n");
                equipo1 = validacionNumeroEntero(sc, "Ingrese el numero del equipo que desees modificar: ");
                while (equipo1 < 1 || equipo1 > 5) //Se valida que solo se ingrese valor de 1 a 5
                {
                    System.out.print("*** ERROR de ingreso, debe ser entre 1 y 5 ***");      
                    equipo1 = validacionNumeroEntero(sc, "Ingrese el numero del equipo que desees modificar: ");
                }  
                 
                System.out.print("\n");
                equipo2 = validacionNumeroEntero(sc, "Ingrese el numero del segundo equipo: ");               
                while (equipo2 < 1 || equipo2 > 5) //Se valida que solo se ingrese valor de 1 a 5
                {
                    System.out.print("*** ERROR de ingreso, debe ser entre 1 y 5 ***");       
                    equipo2 = validacionNumeroEntero(sc, "Ingrese el numero del segundo equipo: ");               
                } 
                while (equipo2 == equipo1) //Ciclo que se ejecutara mientras los valores de los dos equipos sean iguales, se realiza para evitar que se modifique el campo, ya que el valor del mismo es 0 y no se puede modificar
                {
                    System.out.print("\n");
                    System.out.println("*** ERROR de ingreso, debe ser distinto al primer equipo ("+ equipo1 + ") ***");                      
                    equipo2 = validacionNumeroEntero(sc, "Ingrese el numero del segundo equipo: ");               
                } 

                System.out.print("\n");
                 //Se modifica en la matriz el valor existente por el nuevo, la posicion se restara 1 porque va de 0 a 4
                matriz[equipo1-1][equipo2-1] = validacionNumeroEntero(sc, "Ingrese los goles convertidos por el equipo " + equipo1 + " al equipo " + equipo2 + ": ");
                              
                System.out.print("\n");
                opcion = validacionNumeroEntero(sc, "¿Desea realizar alguna modificacion en la grilla? (1-SI, 2-NO): ");
                while (opcion < 1 || opcion > 2) //Se valida que solo se ingrese valor de 1 0 2
                {
                    System.out.print("*** ERROR de ingreso, debe ser 1 o 2 ***");   
                    opcion = validacionNumeroEntero(sc, "¿Desea realizar alguna modificacion en la grilla? (1-SI, 2-NO): ");
                } 
            }   
            //Se muestra la matriz inicial con los goles convertidos, se llama a la funcion imprimirResultados pasando la matriz como parametro.
            imprimirResultados(matriz);               
        }
        sc.close();


        for(int i = 0; i < matriz.length; i++)
        {
            for(int j = 0; j < matriz.length; j++)
            {
                //En caso de que se trate de equipos diferentes, se cargara en la variable resultado el valor de la matriz en la posicion [i][j] correspondiente, para luego comparar por el valor inverso de misma y se logra optener el resultado del partido, ademas se cargaran los goles convertidos y recibidos de cada equipo.
                if(i != j)
                {
                    int resultado = matriz[i][j];
                    
                    arrayGolesFavor[i] += matriz[i][j];
                    arrayGolesContra[j] += matriz[i][j];

                    if(resultado > matriz[j][i])
                    {
                        arrayTriunfos[i]++;

                    }else if(resultado < matriz[j][i])
                    {
                        arrayPerdidos[i]++;
                    }else{
                        arrayEmpates[i]++;
                    }
                }
            }
        } 
       
        
        //Se muestran los resultados de cada equipo.

        System.out.print("\n");
        System.out.print("\n");
        System.out.println("* Resultados totales por equipo *\n");
        for(int i = 0; i < matriz.length; i++)
        {                    
            System.out.println("-> Equipo " + (i + 1));
            System.out.println("Triunfos: " + arrayTriunfos[i]);
            System.out.println("Derrotas: " + arrayPerdidos[i]);
            System.out.println("Empates: " + arrayEmpates[i] + "\n");
        }


        //Se muestra el total de goles a favor y en contra de cada equipo.      
        
        System.out.print("\n");
        System.out.println("* Totales de goles por equipo *\n");
        for(int i = 0; i < matriz.length; i++)
        {                    
            System.out.println("-> Equipo " + (i + 1));
            System.out.println("Goles a favor: " + arrayGolesFavor[i]);
            System.out.println("Goles en contra: " + arrayGolesContra[i] + "\n");
        }

    }
}