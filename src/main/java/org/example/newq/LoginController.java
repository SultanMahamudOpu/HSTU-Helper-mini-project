package org.example.newq;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    @FXML
    private Label wrongLogIn;

    @FXML
    private Label wrong;

    @FXML
    void creatANewAccount(MouseEvent event) {
        try {
            FXMLLoader root = new FXMLLoader(Main.class.getResource("createNewAccount.fxml"));
            Scene scene = new Scene(root.load());
            Stage stage=(Stage) username.getScene().getWindow();
            stage.setTitle("Create New Account");
            stage.setScene(scene);
            stage.show();
//            stage.setFullScreen(true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void loginbuttonOnAction(ActionEvent event) {
        String user=username.getText();
        String pass=password.getText();

        if(user.isEmpty()||pass.isEmpty()){
            Notifications.create()
                    .text("Fill all")
                    .title("Fill up Correctly")
                    .darkStyle()
                    .hideAfter(Duration.seconds(2))
                    .showError();
        }else {
            if(fileHandling.readFile(user,pass)){
                try {
                    FXMLLoader root = new FXMLLoader(Main.class.getResource("HomePage.fxml"));
                    Scene scene = new Scene(root.load());
                    Stage stage=(Stage) username.getScene().getWindow();
                    stage.setTitle("Home Page");
                    stage.setScene(scene);
                    stage.show();
                }catch (Exception e){
                    e.printStackTrace();
                }

                Notifications.create()
                        .text("Login Successfully")
                        .title("Accept")
                        .darkStyle()
                        .hideAfter(Duration.seconds(2))
                        .showConfirm();
            }else {
                wrong.setText("User Name or Password wrong");
            }
        }

    }

}