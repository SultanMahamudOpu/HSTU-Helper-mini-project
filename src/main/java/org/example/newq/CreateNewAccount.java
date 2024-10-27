package org.example.newq;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class CreateNewAccount implements Initializable {

    @FXML
    private Button createButton;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField phoneNumber;

    @FXML
    private TextField username;

    @FXML
    private Label wrongLogIn;

    @FXML
    private PasswordField reEnterPassword;

    @FXML
    private Label passwordNotSame;

    @FXML
    private DatePicker dateOfbirth;

    @FXML
    private ChoiceBox<String> gender;

    @FXML
    void createbuttonOnAction(ActionEvent event) {
        if(username.getText().isEmpty()||password.getText().isEmpty()||reEnterPassword.getText().isEmpty()||phoneNumber.getText().isEmpty()){
            Notifications.create()
                    .text("Fill all")
                    .title("Fill up Correctly")
                    .darkStyle()
                    .hideAfter(Duration.seconds(2))
                    .showError();
        }else {
            LocalDate localDate=dateOfbirth.getValue();
            String pattern="MMMM dd,yyyy";
            String date=localDate.format(DateTimeFormatter.ofPattern(pattern));
            String gend=gender.getValue();
//            System.out.println(gend);
//            System.out.println(date);
            String user=username.getText();
            String pass=password.getText();
            String phoneNum=phoneNumber.getText();

            String rePass=reEnterPassword.getText();
//        fileHandling.createdFile();
            if(pass.equals(rePass)){
                fileHandling.appenedFile("Login.txt",user,pass,phoneNum,gend,date);

                try{
                    FXMLLoader root = new FXMLLoader(Main.class.getResource("login.fxml"));
                    Scene scene = new Scene(root.load());
                    Stage stage=(Stage) username.getScene().getWindow();
                    stage.setTitle("Create New Account");
                    stage.setScene(scene);
                    stage.show();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else {
                passwordNotSame.setText("Password not Same");
            }
        }


    }

    @FXML
    void OnActionReEnterPassword(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gender.getItems().addAll("Male","Female");
    }
}
