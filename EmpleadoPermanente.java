package com.example.demo;

import java.text.DecimalFormat;

public class EmpleadoPermanente extends Empleado {
    private final double sueldoBase;
    private final String afiliacion;

    public EmpleadoPermanente(String dni, String apellidos, String nombres, double sueldoBase, String afiliacion) {
        super(dni, apellidos, nombres);
        this.sueldoBase = sueldoBase;
        this.afiliacion = afiliacion;
    }

    public double ingresos() {
        return sueldoBase;
    }

    public double descuentos() {
        if ("AFP".equals(afiliacion)) {
            return sueldoBase * 0.15;
        }
        return sueldoBase * 0.11;
    }

    public double sueldo() {
        return ingresos() - descuentos();
    }

    @Override
    public String mostrarInfo() {
        DecimalFormat df = new DecimalFormat("###0.00");
        return "EMPLEADO PERMANENTE\n"
                + super.mostrarInfo()
                + "Afiliacion\t: " + afiliacion + "\n"
                + "Ingresos\t: " + df.format(ingresos()) + "\n"
                + "Descuentos\t: " + df.format(descuentos()) + "\n"
                + "Sueldo Neto\t: " + df.format(sueldo()) + "\n";
    }
}
