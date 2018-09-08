/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.reg.controller;
import javafx.scene.layout.AnchorPane;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.reg.business.BOFactory;
import lk.ijse.reg.business.custom.CourseBO;
import lk.ijse.reg.dto.CourseDTO;
import lk.ijse.reg.main.StartUp;
import lk.ijse.reg.view.util.tblmodel.CourseTM;

/**
 * FXML Controller class
 *
 * @author A C E R
 */
public class ManageCourseFormController implements Initializable {

    @FXML
    private TableView<CourseTM> tblCourse;
    @FXML
    private JFXTextField txtCID;
    @FXML
    private JFXTextField txtCName;
    @FXML
    private JFXTextField txtCDuration;
    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private AnchorPane root;
    
    private CourseBO courseBO;
    
    
    
    
    public ManageCourseFormController() {
        this. courseBO = (CourseBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.COURSE);
    }
   
    
   

    /**
     * Initializes the controller class.
     */
    private void loadAllCourses(){
        ArrayList<CourseDTO> allCourses;
        try {
            allCourses = courseBO.getAllCourses();
            ObservableList<CourseTM> olCourses = tblCourse.getItems();
            olCourses.removeAll(olCourses);
            
            for (CourseDTO course : allCourses) {
                CourseTM courseTM = new CourseTM(course.getCid(), course.getName(), course.getDuration());
                olCourses.add(courseTM);
            }
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(ManageCourseFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
           
    
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblCourse.getColumns().get(0).setStyle("-fx-alignment:center");
        tblCourse.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("cid"));
        tblCourse.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCourse.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("duration"));
        loadAllCourses();
    }    

    @FXML
    private void btnSaveOnAction(ActionEvent event) {
        String cid = txtCID.getText();
        String name =txtCName.getText();
        String duration= txtCDuration.getText();
        CourseDTO courseDTO = new CourseDTO(cid, name, duration);
         if(!cid.matches("^c\\d+")){
            new Alert(Alert.AlertType.ERROR,"Invalid Student ID!",ButtonType.OK).show();
            txtCID.requestFocus();  
            return;
         }
         if (!name.matches("[A-Za-z. ]+")){
            new Alert(Alert.AlertType.ERROR,"Invalid Name!",ButtonType.OK).show();
            txtCName.requestFocus();  
            return;
           }
         if (!duration.matches("^\\d{2}\\s[M|m][o|O][n|N][t|T][h|H][s|S]\\b")){
            new Alert(Alert.AlertType.ERROR,"Invalid Duration!",ButtonType.OK).show();
            txtCName.requestFocus();  
            return;
           }
        
        
        try {
            boolean result= courseBO.saveCourse(courseDTO);
            
            if(result){
                new Alert(Alert.AlertType.CONFIRMATION,"Course added successfully",ButtonType.OK).show();
                txtCID.setText("");
                txtCName.setText("");
                txtCDuration.setText("");
                loadAllCourses();
            
            }else{
                new Alert(Alert.AlertType.ERROR,"course added failed",ButtonType.OK).show();
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageCourseFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @FXML
    private void btnDeleteOnAction(ActionEvent event) {
        String courseId= tblCourse.getSelectionModel().getSelectedItem().getCid();
        try {
            boolean result=courseBO.deleteCourse(courseId);
            if(result){
                new Alert(Alert.AlertType.CONFIRMATION,"Course delete success",ButtonType.OK).show();
                loadAllCourses();
            }else{
                new Alert(Alert.AlertType.ERROR,"course delete fail",ButtonType.OK).show();
            }
        } catch (Exception ex) {
            Logger.getLogger(ManageCourseFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void navigateToHome(MouseEvent event) {
        StartUp.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }
    
}
