package org.example.newq;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Teacher {

    @FXML
    private ImageView cseButton;

    @FXML
    private ImageView eceButton;

    @FXML
    private ImageView eeeButton;

    @FXML
    void cseOnAction(MouseEvent event) {
        try {
            File pdfFile = new File("D:\\JAVA CODE\\FX\\HSTU HELPER\\src\\main\\resources\\cseTeacher.pdf"); // Change this to the path of your PDF file
            if (pdfFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.out.println("Desktop is not supported");
                }
            } else {
                System.out.println("File does not exist");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void eceOnAction(MouseEvent event) {
        try {
            File pdfFile = new File("D:\\JAVA CODE\\FX\\HSTU HELPER\\src\\main\\resources\\eceTeacher.pdf"); // Change this to the path of your PDF file
            if (pdfFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.out.println("Desktop is not supported");
                }
            } else {
                System.out.println("File does not exist");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void eeeOnAction(MouseEvent event) {
        try {
            File pdfFile = new File("D:\\JAVA CODE\\FX\\HSTU HELPER\\src\\main\\resources\\eeeTeacher.pdf"); // Change this to the path of your PDF file
            if (pdfFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    System.out.println("Desktop is not supported");
                }
            } else {
                System.out.println("File does not exist");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
