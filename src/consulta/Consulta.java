/*
Ejercicio: Como ahora los servicios sanitarios estan desbordados a causa del Covid-19, 
nos piden diseñar un programa para administrar la cola de un consultorio.

Los datos que nos interesarán guardar serán:

orden(int):  un número  para saber nuestro orden en la cola. Será un valor que se 
autoincrementará para cada nuevo paciente en la cola (utiliza una variable de tipo 
static para poder hacer los incrementos)
nombre (string) del paciente
doctor(string) que lo atenderá
Tareas:

- Crea la clase Paciente. Utiliza las propiedades de encapsulación y crea los setters 
i getters de estos atributos.
- Crea los constructores vacio y full (sobrecargado con todos los atributos) para 
poder instanciar elementos
- Haz un programa que nos permita añadir y quitar personas de la cola (en un vector). 
La capacidad máxima permitida de la cola del consultorio será de 10 elementos devido al Covid-19.
 */
package consulta;

import java.util.Scanner;

/**
 *
 * @author marcomorando
 */
public class Consulta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Paciente[] listaCOVID = new Paciente[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            listaCOVID[i] = new Paciente("marco " + i, "polo " + i);
        }
        int opcion;
        do {
            System.out.println("---------------- LISTA DE ESPERA PACIENTES COVID -------------------");
            System.out.println("");
            System.out.println("1. Añadir paciente");
            System.out.println("2. Quitar paciente");
            System.out.println("3. Mostrar lista");
            System.out.println("4. Salir");
            System.out.println("====================================================================");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("---------------- AÑADIR PACIENTE ---------------");
                    Paciente.AñadirPaciente(listaCOVID);
                    System.out.println("Paciente añadido");
                    System.out.println("================================================");
                    break;
                case 2:
                    System.out.println("---------------- QUITAR PACIENTE ---------------");
                    Paciente.QuitarPaciente(listaCOVID);
                    System.out.println("Paciente eliminado de la lista");
                    System.out.println("================================================");
                    break;
                case 3:
                    System.out.println("---------------- LISTA ACTUAL ------------------");
                    Paciente.MostrarLista(listaCOVID);
                    System.out.println("================================================");
                    break;
                case 4:
                    System.out.println("Has salido del programa");
                    break;
                default:
                    System.out.println("Elige una de las opciones del menu");
                    break;
            }
        } while (opcion != 4);
    }
}