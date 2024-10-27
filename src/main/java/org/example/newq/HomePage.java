package org.example.newq;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class HomePage {

    @FXML
    private Button CourseButton;

    @FXML
    private Button HSTUButton;

    @FXML
    private Button MapButton;

    @FXML
    private Button MyInfoButton;

    @FXML
    private Button TeacherButton;

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    void CourseAction(ActionEvent event) {
        FxmlLoaderTeacher obj=new FxmlLoaderTeacher();
        Pane view=obj.getPage("course");
        mainBorderPane.setCenter(view);
    }

    @FXML
    void HSTUOnAction(ActionEvent event) {
        FxmlLoaderTeacher obj=new FxmlLoaderTeacher();
        Pane view=obj.getPage("hstu");
        mainBorderPane.setCenter(view);
    }

    @FXML
    void MapAction(ActionEvent event) {
        FxmlLoaderTeacher obj=new FxmlLoaderTeacher();
        Pane view=obj.getPage("findSrcDst");
        mainBorderPane.setCenter(view);
    }

    @FXML
    void MyInfoAction(ActionEvent event) {
        FxmlLoaderTeacher obj=new FxmlLoaderTeacher();
        Pane view=obj.getPage("myInfo");
        mainBorderPane.setCenter(view);
    }

    @FXML
    void TeacherAction(ActionEvent event) {
        FxmlLoaderTeacher obj=new FxmlLoaderTeacher();
        Pane view=obj.getPage("teacher");
        mainBorderPane.setCenter(view);
    }

}
