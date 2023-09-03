/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package portafolio02java;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriela
 * @date: 03/09/2023
 *
 */
public class Portafolio02Java {

    /**
     * @param args the command line arguments
     */
    private static ArrayList<ArrayList<Integer>> matriz = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) {
        // TODO code application logic here

        //Variables
        int opcionSeleccionada;
//        operaciones(opcion());
        while (true) {
            opcionSeleccionada = opcion();
            if (opcionSeleccionada == 5) {
                JOptionPane.showMessageDialog(null, "SALIR");
                System.exit(0);
            }
            operaciones(opcionSeleccionada);
        }

    }//Fin Main

    //Metodo que muestra un menu y retorna la opcion seleccionada
    public static int opcion() {
        String opciones = "***MENU PRINCIPAL***\n1- Numero factorial\n2-Los 10 primeros numeros primos\n3-Crear una matriz de numeros al azar\n4-Obtener el numero mayor de la matriz\n5-Salir";
        int opcion = 0;
        boolean salir = false;

        while (!salir) {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(opciones));

                if (opcion >= 1 && opcion <= 5) {
                    salir = true;
                } else {
                    JOptionPane.showInputDialog(opciones);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Entrada invalida");
            }

        }

        return opcion;
    }//Fin metodo opcion

    //Método que ejecuta la opcion seleccionada
    public static void operaciones(int opcion) {
//        ArrayList<ArrayList<Integer>> matriz = new ArrayList<ArrayList<Integer>>();
        switch (opcion) {
            case 1:
                JOptionPane.showMessageDialog(null, "Numero Factorial");
                factorial();
                break;

            case 2:
                JOptionPane.showMessageDialog(null, "Numeros primos");
                numerosPrimos();
                break;

            case 3:
                JOptionPane.showMessageDialog(null, "Matriz generada aleatoriamente");
                matriz = matrizAzar();
                mostrarMatriz(matriz);
                break;

            case 4:
                JOptionPane.showMessageDialog(null, "El mayor de la matriz");
                System.out.println("El valor mayor es: " + mayorMatriz(matriz));
                break;

            case 5:
                JOptionPane.showMessageDialog(null, "SALIR");
                System.exit(0);
                break;

            default:
                throw new AssertionError();
        }

    }//Fin operaciones

    //Método que calcula el factorial de un numeo solcitado al usuario
    public static void factorial() {
        int numero = 1;
        int factorial = 1;
        Scanner entrada = new Scanner(System.in);
        try {
            numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un numero"));
            if (numero < 0) {
                JOptionPane.showMessageDialog(null, "El factorial de un número negativo no está definido.");
                return;
            }
            
            for (int i = 1; i <= numero; i++) {
                factorial *= i ;

            }
          
            JOptionPane.showMessageDialog(null, factorial);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Entrada invalida");
        }

    }//Fin Factorial

    //Llena un vector de tamano 10 con numeros primos
    public static void numerosPrimos() {
        ArrayList<Integer> primos = new ArrayList<>();
        Random aleatorio = new Random();

        while (primos.size() < 10) {
            int numero;
            int contador = 0;
            numero = aleatorio.nextInt(100) + 2;
            for (int i = 1; i <= numero; i++) {
                if ((numero % i == 0)) {
                    contador++;
                }
            }

            if (contador == 2 && !primos.contains(numero)) {
                primos.add(numero);
            }

        }//Fin while

        for (Integer primo : primos) {
            System.out.printf("%5d", primo);
        }

    }//Fin numeroPrimo

    //Llena una matriz con numeros aleatorios y cada una de sus filas es 
    // ordenada de menor a mayor
    public static ArrayList<ArrayList<Integer>> matrizAzar() {
        Random aleatorio = new Random();
        ArrayList<ArrayList<Integer>> matriz = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ArrayList<Integer> fila = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                fila.add(aleatorio.nextInt(199) + 1);
                //Ordena la fila de menor a mayor
                Collections.sort(fila);
            }
            matriz.add(fila);
        }

        return matriz;
//Muestra la matriz
    }//Fin matrizAzar

    //Recorre la matriz y muestra su contenido
    public static String mostrarMatriz(ArrayList<ArrayList<Integer>> matriz) {
        StringBuilder resultado = new StringBuilder();
        for (ArrayList<Integer> fila : matriz) {
            for (Integer valor : fila) {
//                resultado.append(String.format("%10d", valor));
                System.out.print(valor + "\t");
            }
//            resultado.append("\n");
            System.out.println("");
        }

        return resultado.toString();
    }//Fin mostrarMatriz

    //Muestra el mayor de los numeros contenido en la matriz
    public static int mayorMatriz(ArrayList<ArrayList<Integer>> matriz) {
        if (matriz.isEmpty()) {//Evalúa si la matriz está vacía
            throw new IllegalArgumentException("La matriz esta vacia");
        }
        int mayor = matriz.get(0).get(0);//Se inicializa el mayor con el primer valor de la matriz

        for (ArrayList<Integer> fila : matriz) {
            for (int valor : fila) {
                if (valor > mayor) {
                    mayor = valor;//En este punto se actualiza el mayor encontrado
                }
            }
        }
        return mayor;
    }//FinmayorMatriz 

}//Fin Portafolio02Java

