/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.reg.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.reg.business.BOFactory;
import lk.ijse.reg.business.custom.StudentBO;
import lk.ijse.reg.dto.StudentDTO;
import lk.ijse.reg.main.StartUp;
import lk.ijse.reg.view.util.tblmodel.StudentTM;

/**
 * FXML Controller class
 *
 * @author A C E R
 */
public class ManageStudentFormController implements Initializable {

    @FXML
    private TableView<StudentTM> tblStudent;
    @FXML
    private JFXTextField txtSID;
    @FXML
    private JFXTextField txtSName;
    @FXML
    private JFXTextField txtSAddress;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private AnchorPane root;
    
    private StudentBO studentBO;

    public ManageStudentFormController() {
        this.studentBO=(StudentBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.STUDENT);
    }
    
    
    
            
private void loadAllStudents(){
        ArrayList<StudentDTO> allStudents;
        
        try {
            allStudents = studentBO.getAllStudents();
        
            ObservableList<StudentTM> olStudents = tblStudent.getItems();
            olStudents.removeAll(olStudents);
            
            for (StudentDTO course : allStudents) {
                StudentTM studentTM = new StudentTM(course.getSid(), course.getName(), course.getAddress());
                olStudents.add(studentTM);
            }
            } catch (Exception ex) {
            Logger.getLogger(ManageStudentFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblStudent.getColumns().get(0).setStyle("-fx-alignment:center");
        tblStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("sid"));
        tblStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        loadAllStudents();
    }    

    @FXML
    private void btnSaveOnAction(ActionEvent event) {
       String sid = txtSID.getText();
       String name = txtSName.getText();
       String address = txtSAddress.getText();
       StudentDTO studentDTO = new StudentDTO(sid, name, address);
       
       if (!sid.matches("^s\\d+")){
            new Alert(Alert.AlertType.ERROR,"Invalid Student ID !",ButtonType.OK).show();
            txtSID.requestFocus();  
            return;
           }
       
       if (!name.matches("[A-Za-z. ]+")){
            new Alert(Alert.AlertType.ERROR,"Invalid Student Name!",ButtonType.OK).show();
            txtSID.requestFocus();  
            return;
           }
       
          if (!address.matches("[A-Za-z. ]+")){
            new Alert(Alert.AlertType.ERROR,"Invalid Student Address!",ButtonType.OK).show();
            txtSAddress.requestFocus();  
            return;
           }
       
        try {
            boolean result = studentBO.saveStudent(studentDTO);
            if(result){
                new Alert(Alert.AlertType.CONFIRMATION,"Student added Success",ButtonType.OK).show();
                txtSID.setText("");
                txtSName.setText("");
                txtSAddress.setText("");
                loadAllStudents();
            
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ManageStudentFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnDeleteOnAction(ActionEvent event) {
        String studentId= tblStudent.getSelectionModel().getSelectedItem().getSid();
        try {
            boolean result=studentBO.deleteCourse(studentId);
            if(result){
                new Alert(Alert.AlertType.CONFIRMATION,"Student Deleted Success",ButtonType.OK ).show();
                loadAllStudents();
            }else{
                new Alert(Alert.AlertType.ERROR,"Student deleted fail",ButtonType.OK).show();
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageStudentFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void navigateToHome(MouseEvent event) {
         StartUp.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }
    
}
