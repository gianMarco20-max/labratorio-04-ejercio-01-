package com.example.demo;

public class Empleado {
    protected String dni;
    protected String apellidos;
    protected String nombres;

    public Empleado() {
    }

    public Empleado(String dni, String apellidos, String nombres) {
        this.dni = dni;
        this.apellidos = apellidos;
        this.nombres = nombres;
    }

    public String mostrarInfo() {
        return "Nombres\t\t: " + nombres + "\n"
                + "Apellidos\t: " + apellidos + "\n"
                + "D.N.I.\t\t: " + dni + "\n";
    }
}
