package ui;

import java.util.Scanner;

public class Guacamaya {

    public static Scanner reader;
    public static double[] precios;
    public static int[] unidades;

    public static void main(String[] args) {

        inicializarGlobales();
        menu();
    }

    /**
     * Descripcion: Este metodo se encarga de iniciar las variables globales
     * pre: El Scanner reader debe estar declarado
     * pos: l Scanner reader queda inicializado
    */
    public static void inicializarGlobales() {

        reader = new Scanner(System.in);

    }

    /**
     * Descripcion: Este metodo se encarga de desplegar el menu al usuario y mostrar los mensajes de resultado para cada funcionalidad
     * pre: El Scanner reader debe estar inicializado
     * pre: El arreglo precios debe estar inicializado
    */
    public static void menu() {

        System.out.println("Bienvenido a Guacamaya!");

        establecerCantidadVendida();

        boolean salir = false;

        do {

            System.out.println("\nMenu Principal:");
            System.out.println("1. Solicitar precios ($) y cantidades de cada referencia de producto vendida en el dia");
            System.out.println("2. Calcular la cantidad total de unidades vendidas en el dia");
            System.out.println("3. Calcular el precio promedio de las referencias de producto vendidas en el dia");
            System.out.println("4. Calcular las ventas totales (dinero recaudado) durante el dia");
            System.out.println("5. Consultar el numero de referencias de productos que en el dia han superado un limite minimo de ventas");
            System.out.println("6. Salir");
            System.out.println("\nDigite la opcion a ejecutar");
            int opcion = reader.nextInt();

            switch (opcion) {
                case 1:
                    solicitarDatos();
                    break;
                case 2:
                    calcularTotalUnidadesVendidas();
                    System.out.println("\nLa cantidad total de unidades vendidas en el dia fue de: "+calcularTotalUnidadesVendidas());
                    break;
                case 3:
                    calcularPrecioPromedio();
                    System.out.println("\nEl precio promedio de las referencias de producto vendidas en el dia fue de: "+calcularPrecioPromedio());
                    break;
                case 4:
                    calcularVentasTotales();
                    System.out.println("\nLas ventas totales (dinero recaudado) durante el dia fueron: "+calcularVentasTotales());
                    break;
                case 5:
                    System.out.println("\nDigite el limite minimo de ventas a analizar");
                    double limite = reader.nextDouble();
                    consultarReferenciasSobreLimite(limite);
                    System.out.println("\nDe las "+precios.length+" referencias vendidas en el dia, "+consultarReferenciasSobreLimite(limite)+" superaron el limite minimo de ventas de "+limite);
                    break;
                case 6:
                    System.out.println("\nGracias por usar nuestros servicios!");
                    salir = true;
                    reader.close();
                    break;

                default:
                    break;
            }

        } while (!salir);

    }

    /**
     * Descripcion: Este metodo se encarga de preguntar al usuario el numero de referencias de producto diferentes 
     * vendidas en el dia e inicializa con ese valor los arreglos encargados de almacenar precios y cantidades
     * pre: El Scanner reader debe estar inicializado
     * pre: Los arreglos precios y unidades deben estar declarados
     * pos: Los arreglos precios y unidades quedan inicializados
     */
    public static void establecerCantidadVendida() {

        System.out.println("\nDigite el numero de referencias de producto diferentes vendidas en el dia ");
        int referencias = reader.nextInt();

        precios = new double[referencias];
        unidades = new int[referencias];

    }
    /**
     * Descripcion: Este metodo se encarga de solicitar al cliente el precio de los prodcutos y la cantidad de ellos
     * pre: El arreglo debe estar inicializado
     * pos:el arreglo queda modificado
     */

    public static void solicitarDatos(){
        for (int i=0;i<unidades.length;i++){
        System.out.println("Digite el precio de el producto "+ (i+1));
            double PrecioProducto = reader.nextDouble();
        System.out.println("Digita la cantidad  vendida  "+ (i+1));
            int UnidadesProducto = reader.nextInt();
            if (precios[i]==0) {precios[i]=PrecioProducto;}
            if (unidades[i]==0) {unidades[i]=UnidadesProducto;}
        
    }

/**
     * Descripcion: Este metodo calcula el total de unidades vendidas sumando el arreglo que los contiene hasta llegar al tamaño del arreglo y devuelve el calculo en una variable
     * pre:El arreglo debe estar inicializado
     */
        
    }

    public static int calcularTotalUnidadesVendidas(){
       int totalu=0;
        for (int i=0;i<unidades.length;i++){
            totalu+=unidades[i];
        
        }

        

        return totalu;

    }
    /**
     * Descripcion: Este metodo se encarga de calcular el promedio multiplicando los arreglos y dividiendolos entre ellos 
     * pre:El arreglo debe estar inicializado
     */

    public static double calcularPrecioPromedio(){
        double promPrecio=0;
        int temp=0;
        for (int i=0;i<precios.length;i++){
            temp+=precios[i];
        
        }
        promPrecio=(temp/precios.length);

        return promPrecio;

    }

    public static double calcularVentasTotales(){
        double calculovendido=0;
        for (int i=0;i<unidades.length;i++){
            calculovendido+=(unidades[i]*precios[i]);
        
        }


        return calculovendido;

    }

    public static int consultarReferenciasSobreLimite(double limite){
            double temporal=0;
            int cantidadref=0;
        for (int i = 0 ; i < unidades.length;i++){
            temporal= (unidades[i]*precios[i]);
            if (temporal>limite) {

                cantidadref++;
            }

        }

        return cantidadref;

    }

}
