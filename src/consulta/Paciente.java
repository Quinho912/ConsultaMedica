/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consulta;

import java.util.Scanner;

/**
 *
 * @author marcomorando
 */
public class Paciente {

    static Scanner sc = new Scanner(System.in);
    private static int orden = 1;
    private int ordenp;// orden paciente autogenerado
    private String nombre;
    private String doctor;

    //Constructores
    public Paciente() {}
    
    public Paciente(String nombre, String doctor) {
        this.ordenp = this.orden;
        this.orden++;
        this.nombre = nombre;
        this.doctor = doctor;
    }
    
    //Funiones y procedimientos
    public static void AñadirPaciente(Paciente[] lista) {
        String nombre, doctor;
        System.out.print("Ingresa el nombre del paciente: ");
        nombre = sc.nextLine();
        System.out.print("Ingresa el nombre del Doctor que lo atenderá: ");
        doctor = sc.nextLine();
        Paciente p = new Paciente(nombre, doctor);
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == null) {
                lista[i] = p;
                break;
            }
        }
    }

    public static void QuitarPaciente(Paciente[] lista) {
        MostrarLista(lista);
        System.out.print("Dime el numero del paciente a eliminar: ");
        int np = sc.nextInt();
        sc.nextLine();
        //Elimina por orden de paciente
        for (int i = 0; i < lista.length; i++) {
            if (lista[i].getOrdenp() == np) {
                System.out.println(lista[i].toString() + " eliminado");
                lista[i] = null;
                break;
            }
        }
        //Ordena el numero de los pacientes
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == null && i < lista.length - 1 && lista[i + 1] != null) {
                lista[i + 1].setOrdenp(i + 1);
                lista[i + 1].setOrden(lista[i + 1].getOrdenp() + 1);
                lista[i] = lista[i + 1];
                lista[i + 1] = null;
            }
        }
    }

    public static void MostrarLista(Paciente[] lista) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                System.out.println(lista[i].toString());
            }
        }
    }

    //Setters y Getters
    public void setOrden(int orden) {
        this.orden = orden;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrdenp(int orden) {
        this.ordenp = orden;
    }

    public int getOrdenp() {
        return ordenp;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getDoctor() {
        return doctor;
    }

    @Override
    public String toString() {
        return "Paciente: " + this.getOrdenp() + ", " + this.getNombre() + ", Dr. " + this.getDoctor();
    }

}
