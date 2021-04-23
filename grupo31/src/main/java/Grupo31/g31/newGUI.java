package Grupo31.g31;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
 
public final class newGUI extends Application {
 
    private Desktop desktop = Desktop.getDesktop();
 
    @Override
    public void start(final Stage stage) {
        stage.setTitle("Code Smells");
 
        final FileChooser fileChooser = new FileChooser();
 
        final Button openButton = new Button("Detect CodeSmells");
        final Button openButton2 = new Button("Select Excel File");
 
        openButton.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    File file = fileChooser.showOpenDialog(stage);
                    if (file != null) {
        				if (!file.getName().endsWith("java")) {
        					JOptionPane.showMessageDialog(null, "Please select only Java file.", "Error", JOptionPane.ERROR_MESSAGE);
        				} else {
        					Create_Method.fillmethod(file);
        				}
                    }
                }
            });
 
        openButton2.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    List<File> list =
                        fileChooser.showOpenMultipleDialog(stage);
                    if (list != null) {
                        for (File file : list) {
                            openFile(file);
                        }
                    }
                }
            });
 
 
        final GridPane inputGridPane = new GridPane();
        
        
        //tamanho de cada lado
        int t= 300;
        
        GridPane.setConstraints(openButton, 0, 0);
        GridPane.setConstraints(openButton2, 1, 0);
        inputGridPane.setHgap(8);
        inputGridPane.setVgap(8);
        inputGridPane.getChildren().addAll(openButton, openButton2);
        
        openButton.setTranslateX(-t + 20);
        openButton.setTranslateY(-t + 20);
        
        openButton2.setTranslateX(-t + 30);
        openButton2.setTranslateY(-t + 20);
        
 
        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(t, t, t, t));
 
        stage.setScene(new Scene(rootGroup));
        stage.show();
    }
 
    public static void main(String[] args) {
        Application.launch(args);
    }
 
    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                newGUI.class.getName()).log(
                    Level.SEVERE, null, ex
                );
        }
    }
}