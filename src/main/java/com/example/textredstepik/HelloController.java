package com.example.textredstepik;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.skin.TextInputControlSkin;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.Scanner;


public class HelloController {
    @FXML
    private Label name;

    @FXML
    private Button open;

    @FXML
    private Button save;

    @FXML
    private Button saveAs;

    @FXML
    private TextArea textArea;
    FileWriter fw;
    FileReader fr;
    File selectedFile;

    public void initialize(){

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(
                "C:\\Users\\iakon\\IdeaProjects\\TextRedStepik\\textfiles"));

        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(new File(
                "C:\\Users\\iakon\\IdeaProjects\\TextRedStepik\\textfiles"));


        open.setOnAction(event -> {
            selectedFile = fileChooser.showOpenDialog(HelloApplication.ssstage);
            if(selectedFile != null){
                name.setText(String.valueOf(selectedFile).substring(
                        String.valueOf(selectedFile).lastIndexOf('\\') + 1
                ));

                try {
                    fr = new FileReader(selectedFile);
                    Scanner scan = new Scanner(fr);

                    textArea.setText("");
                    while (scan.hasNextLine()){
                        textArea.appendText(scan.nextLine());
                        if(scan.hasNextLine()) textArea.appendText("\n");
                    }

                    fr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        save.setOnAction(event -> {
            if (selectedFile != null){
                try {
                    fw = new FileWriter(selectedFile);
                    fw.write(textArea.getText());
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        saveAs.setOnAction(event -> {
            File file = fileChooser.showSaveDialog(HelloApplication.ssstage);
            if(file != null){
                try {
                    fw = new FileWriter(file);
                    fw.write(textArea.getText());
                    fw.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

}