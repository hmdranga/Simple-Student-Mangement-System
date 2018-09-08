/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.reg.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author A C E R
 */
public class MainFormController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private ImageView imgStudent;
    @FXML
    private ImageView imgCourse;
    @FXML
    private ImageView imgRegister;
    @FXML
    private Label lblDescription;
    @FXML
    private Label lblMenu;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void playMouseExitAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play(); 
            
            icon.setEffect(null);
            lblMenu.setText("Welcome");
            lblDescription.setText("Please select one of above main operations to proceed");
        }
    }

    @FXML
    private void playMouseEnterAnimation(MouseEvent event) {
             if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            
            switch(icon.getId()){
                case "imgStudent":
                    lblMenu.setText("Manage Student");
                    lblDescription.setText("Click to add, delete or view student");
                    break;
                case "imgCourse":
                    lblMenu.setText("Manage Course");
                    lblDescription.setText("Click to add, delete or view course");
                    break;
                case "imgRegister":
                    lblMenu.setText("Make Registration");
                    lblDescription.setText("Click to make Registration..!");
                    break;
                
            }
            
            ScaleTransition scaleT =new ScaleTransition(Duration.millis(400), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play(); 
            
            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);            
        }
    }

    @FXML
    private void navigate(MouseEvent event)throws IOException {
        if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            
            Parent root = null;     
            
            switch(icon.getId()){
                case "imgStudent":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/reg/view/ManageStudentForm.fxml"));
                    break;
                case "imgCourse":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/reg/view/ManageCourseForm.fxml"));
                    break;
                case "imgRegister":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/reg/view/RegisterForm.fxml"));
                    break;
                
            }
            
            if (root != null){
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();
                
                TranslateTransition tt = new TranslateTransition(Duration.millis(400), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();
                
            }
        }
        
        
        
        
    }
    
}
