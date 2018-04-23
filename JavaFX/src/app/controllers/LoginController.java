package app.controllers;

import app.database.DBConnect;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private TextField tf_login;
    @FXML
    private PasswordField pf_passwd;
    @FXML
    private TextField tf_passwd;
    @FXML
    private CheckBox cb_showPasswd;
    @FXML
    private Button btn_log;
    DBConnect db;
    Connection conn;
    int licznikLogowan = 3;
    private void externalLoginAction() {
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT * FROM logowanie WHERE login = ? and (haslo = ? or haslo = ?)");
            ps.setString(1,tf_login.getText());
            ps.setString(2,tf_passwd.getText());
            ps.setString(3, pf_passwd.getText());
            ResultSet wynikLogowania =ps.executeQuery();
            if(wynikLogowania.next()){
                licznikLogowan = 3;
                if (wynikLogowania.getString("uprawnienia").equals("admin")) {
                    System.out.println("Zalogowano jako admin");
                    try {
                        Stage adminStage = new Stage();
                        Parent root = FXMLLoader.load(getClass().getResource("/app/view/AdminView.fxml"));
                        adminStage.setTitle("Panel administracyjne");
                        adminStage.setScene(new Scene(root));
                        adminStage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("Błędne dane logowania!");
                licznikLogowan --;
                if(licznikLogowan < 0){
                    System.exit(0);
                }
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setTitle("Błędne dane logowania!");
                a.setHeaderText("Niepoprawny login lub hasło");
                a.setContentText("Pozostało: " + licznikLogowan + " prób logowania");
                a.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("błędne zapytanie");
        }
        tf_login.clear();
        pf_passwd.clear();
        tf_passwd.clear();
    }





    @FXML
    void keyLoginAction(KeyEvent event) {
        if(event.getCode().equals(KeyCode.ENTER)) {
            externalLoginAction();
            ((Node)(event.getSource())).getScene().getWindow().hide();
        }
    }

    @FXML
    void loginAction(MouseEvent event) {
        externalLoginAction();
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void showPasswd(MouseEvent event) {
        if(cb_showPasswd.isSelected()){
            tf_passwd.setVisible(true);
            pf_passwd.setVisible(false);
            tf_passwd.setText(pf_passwd.getText());
        } else{
            tf_passwd.setVisible(false);
            pf_passwd.setVisible(true);
            pf_passwd.setText(tf_passwd.getText());
        }
    }
    public void initialize(){
        db = new DBConnect();
        db.driverRegistration();
        conn =db.setConnection();
    }
}
