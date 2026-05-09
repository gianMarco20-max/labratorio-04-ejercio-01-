package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LaboratorioApplication {
    public static void main(String[] args) {
        Application.launch(JavaFxApp.class, args);
    }

    public static class JavaFxApp extends Application {
        @Override
        public void start(Stage stage) throws IOException {
            FXMLLoader loader = new FXMLLoader(LaboratorioApplication.class.getResource("laboratorio-view.fxml"));
            Scene scene = new Scene(loader.load(), 760, 520);
            stage.setTitle("LABORAT-04 - Empleados");
            stage.setScene(scene);
            stage.show();
        }
    }
}
