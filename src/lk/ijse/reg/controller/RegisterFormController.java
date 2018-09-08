/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.reg.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
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
import lk.ijse.reg.business.custom.RegisterBO;
import lk.ijse.reg.business.custom.StudentBO;
import lk.ijse.reg.dto.RegisterDTO;
import lk.ijse.reg.dto.StudentDTO;
import lk.ijse.reg.main.StartUp;
import lk.ijse.reg.view.util.tblmodel.RegisterTM;

/**
 * FXML Controller class
 *
 * @author A C E R
 */
public class RegisterFormController implements Initializable {

    @FXML
    private JFXComboBox<String> cmbCID;
    @FXML
    private JFXTextField txtSID;
    @FXML
    private JFXTextField txtFee;
    @FXML
    private TableView<RegisterTM> tblRegistration;
    @FXML
    private JFXButton btnRegister;
    @FXML
    private AnchorPane root;
    @FXML
    private JFXButton btnDelete;
    
    private RegisterBO registerBO;
    
    private StudentBO studentBO;

    public RegisterFormController() {
        this.registerBO = (RegisterBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.REGISTER);
        this.studentBO = (StudentBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.STUDENT);
    }
    
//    private void getAllStudents(){
//        ArrayList<StudentDTO> allStudents;
//        
//        allStudents = studentBO.getAllStudents();
//        
//        ObservableList<>
//    }
//    
    private void loadAllRegisters() {
        ArrayList<RegisterDTO> allregisters;

        try {
            allregisters = registerBO.getAllRegisters();

            ObservableList<RegisterTM> olRegisters = tblRegistration.getItems();
            olRegisters.removeAll(olRegisters);

            for (RegisterDTO register : allregisters) {
                RegisterTM registerTM = new RegisterTM(register.getSid(), register.getCid(), register.getDate(), register.getFee());
                olRegisters.add(registerTM);
            }
        } catch (Exception ex) {
            Logger.getLogger(RegisterFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    private void setCourseCmb() {
        ArrayList<String> allCourses = new ArrayList<>();
        try {
            allCourses = registerBO.getValRegisters();
            cmbCID.setItems(FXCollections.observableArrayList(allCourses));
              
        } catch (Exception ex) {
            Logger.getLogger(RegisterFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblRegistration.getColumns().get(0).setStyle("-fx-alignment:center");
        tblRegistration.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("sid"));
        tblRegistration.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("cid"));
        tblRegistration.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("date"));
        tblRegistration.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("fee"));
        loadAllRegisters();
        setCourseCmb();
    }

    @FXML
    private void btnregisterOnAction(ActionEvent event) {
        String cid=cmbCID.getValue();
        String sid=txtSID.getText();
        BigDecimal fee =new BigDecimal(txtFee.getText());
        String feeValidation = txtFee.getText();
        RegisterDTO registerDTO = new RegisterDTO(cid, sid, fee);
        
        if(!sid.matches("^s\\d+")){
            new Alert(Alert.AlertType.ERROR,"Invalid Student ID!",ButtonType.OK).show();
            txtSID.requestFocus();  
            return;
         }
         if(!feeValidation.matches("^[0-9]+(\\.[1-3])?$")){
            new Alert(Alert.AlertType.ERROR,"Invalid Fee value!",ButtonType.OK).show();
            txtFee.requestFocus();  
            return;
         }
        
            boolean result;
        try {
            result = registerBO.saveRegister(registerDTO);
             if(result){
                new Alert(Alert.AlertType.CONFIRMATION,"Registration added Success",ButtonType.OK).show();
                txtSID.setText("");
                txtFee.setText("");
                cmbCID.setValue("");
                loadAllRegisters();
            }
            
        } catch (Exception ex) {
            Logger.getLogger(RegisterFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }

    @FXML
    private void navigateToHome(MouseEvent event) {
         StartUp.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }

    @FXML
    private void btnDeleteOnAction(ActionEvent event) {
        String cid =tblRegistration.getSelectionModel().getSelectedItem().getCid();
        String sid= tblRegistration.getSelectionModel().getSelectedItem().getSid();
        RegisterDTO dto=new RegisterDTO(cid, sid);
        try {            
            boolean result = registerBO.deleteRegister(dto);
            if(result){
                loadAllRegisters();
                new Alert(Alert.AlertType.CONFIRMATION,"Registration delete",ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.ERROR, "Registration delete failed",ButtonType.OK).show();
            }
        } catch (Exception ex) {
            Logger.getLogger(RegisterFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
               ;
    }

}
