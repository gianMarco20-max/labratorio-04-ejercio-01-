package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LaboratorioController {
    @FXML
    private TextField txtDniVendedor;
    @FXML
    private TextField txtNombresVendedor;
    @FXML
    private TextField txtApellidosVendedor;
    @FXML
    private TextField txtMontoVendido;
    @FXML
    private TextField txtTasaComision;
    @FXML
    private TextArea txaSalidaVendedor;

    @FXML
    private TextField txtDniPermanente;
    @FXML
    private TextField txtNombresPermanente;
    @FXML
    private TextField txtApellidosPermanente;
    @FXML
    private TextField txtSueldoBase;
    @FXML
    private ComboBox<String> cbxAfiliacion;
    @FXML
    private TextArea txaSalidaPermanente;

    @FXML
    private void initialize() {
        cbxAfiliacion.getItems().addAll("AFP", "SNP");
        cbxAfiliacion.setValue("AFP");
    }

    @FXML
    private void crearEmpleadoVendedor() {
        if (!validarTexto(txtDniVendedor, txtNombresVendedor, txtApellidosVendedor)
                || !validarDecimal(txtMontoVendido)
                || !validarDecimal(txtTasaComision)) {
            return;
        }

        EmpleadoVendedor empleado = new EmpleadoVendedor(
                txtDniVendedor.getText().trim(),
                txtApellidosVendedor.getText().trim(),
                txtNombresVendedor.getText().trim(),
                Double.parseDouble(txtMontoVendido.getText().trim()),
                Double.parseDouble(txtTasaComision.getText().trim())
        );
        txaSalidaVendedor.appendText(empleado.mostrarInfo() + "\n");
    }

    @FXML
    private void borrarVendedor() {
        limpiar(txtDniVendedor, txtNombresVendedor, txtApellidosVendedor, txtMontoVendido, txtTasaComision);
        txaSalidaVendedor.clear();
        txtDniVendedor.requestFocus();
    }

    @FXML
    private void crearEmpleadoPermanente() {
        if (!validarTexto(txtDniPermanente, txtNombresPermanente, txtApellidosPermanente)
                || !validarDecimal(txtSueldoBase)) {
            return;
        }

        EmpleadoPermanente empleado = new EmpleadoPermanente(
                txtDniPermanente.getText().trim(),
                txtApellidosPermanente.getText().trim(),
                txtNombresPermanente.getText().trim(),
                Double.parseDouble(txtSueldoBase.getText().trim()),
                cbxAfiliacion.getValue()
        );
        txaSalidaPermanente.appendText(empleado.mostrarInfo() + "\n");
    }

    @FXML
    private void borrarPermanente() {
        limpiar(txtDniPermanente, txtNombresPermanente, txtApellidosPermanente, txtSueldoBase);
        cbxAfiliacion.setValue("AFP");
        txaSalidaPermanente.clear();
        txtDniPermanente.requestFocus();
    }

    @FXML
    private void salir() {
        System.exit(0);
    }

    private boolean validarTexto(TextField... campos) {
        for (TextField campo : campos) {
            if (campo.getText().trim().isEmpty()) {
                mostrarError("Complete todos los datos de texto.");
                return false;
            }
        }
        return true;
    }

    private boolean validarDecimal(TextField campo) {
        try {
            double valor = Double.parseDouble(campo.getText().trim());
            if (valor < 0) {
                mostrarError("Ingrese numeros positivos.");
                return false;
            }
            return true;
        } catch (NumberFormatException ex) {
            mostrarError("Ingrese valores numericos validos.");
            return false;
        }
    }

    private void limpiar(TextField... campos) {
        for (TextField campo : campos) {
            campo.clear();
        }
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Datos invalidos");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
