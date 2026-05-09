package com.example.demo;

import java.text.DecimalFormat;

public class EmpleadoVendedor extends Empleado {
    private final double montoVendido;
    private final double tasaComision;

    public EmpleadoVendedor(String dni, String apellidos, String nombres, double montoVendido, double tasaComision) {
        super(dni, apellidos, nombres);
        this.montoVendido = montoVendido;
        this.tasaComision = tasaComision;
    }

    public double ingresos() {
        return montoVendido * tasaComision;
    }

    public double bonificaciones() {
        if (montoVendido < 1000) {
            return 0;
        }
        if (montoVendido <= 5000) {
            return ingresos() * 0.05;
        }
        return ingresos() * 0.10;
    }

    public double descuentos() {
        if (ingresos() < 1000) {
            return ingresos() * 0.11;
        }
        return ingresos() * 0.15;
    }

    public double sueldo() {
        return ingresos() + bonificaciones() - descuentos();
    }

    @Override
    public String mostrarInfo() {
        DecimalFormat df = new DecimalFormat("###0.00");
        return "EMPLEADO VENDEDOR\n"
                + super.mostrarInfo()
                + "Monto Vendido\t: " + df.format(montoVendido) + "\n"
                + "Tasa Comision\t: " + df.format(tasaComision) + "\n"
                + "Ingresos\t: " + df.format(ingresos()) + "\n"
                + "Bonificaciones\t: " + df.format(bonificaciones()) + "\n"
                + "Descuentos\t: " + df.format(descuentos()) + "\n"
                + "Sueldo Neto\t: " + df.format(sueldo()) + "\n";
    }
}
