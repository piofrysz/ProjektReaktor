package app.controllers;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class AdminController {

    @FXML
    private ComboBox<?> cb_users;

    @FXML
    private TextField tf_userName;

    @FXML
    private TextField tf_userLast;

    @FXML
    private TextField tf_userMail;

    @FXML
    private TextField tf_userPasswd;

    @FXML
    private TextField tf_userGitHubAcc;

    @FXML
    private TextField tf_userPhone;

    @FXML
    private Button btn_submitUser;

    @FXML
    private Button btn_userDel;

    @FXML
    private TextArea tf_proj1;

    @FXML
    private Spinner<?> spinner_proj1;

    @FXML
    private Slider slider_proj1;

    @FXML
    private Button btn_Proj1;

    @FXML
    private TextArea tf_proj2;

    @FXML
    private Spinner<?> spinner_proj2;

    @FXML
    private Slider slider_proj2;

    @FXML
    private Button btn_Proj2;

    @FXML
    private TextArea tf_proj3;

    @FXML
    private Spinner<?> sprinner_proj3;

    @FXML
    private Slider slider_proj3;

    @FXML
    private Button btn_proj3;

    @FXML
    private TextArea tf_proj4;

    @FXML
    private Spinner<?> spinner_proj4;

    @FXML
    private Slider slider_proj4;

    @FXML
    private Button btn_proj4;

    @FXML
    void addAdminAction(ActionEvent event) {

    }
    Event e;
    private List<Event> listaEventow = new ArrayList<>();
    @FXML
    void submitUserAction(MouseEvent event) {
        if(tf_userName.getText().equals("") ||
                tf_userLast.getText().equals("") ||
                tf_userMail.getText().equals("") ||
                tf_userPasswd.getText().equals("") ||
                tf_userGitHubAcc.getText().equals("") ||
                tf_userPhone.getText().equals("") ||
                cb_users.getValue() == null){
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Błąd");
            a.setHeaderText("Błędnie wypełniony formularz");
            a.setContentText("Uzupełnij wszystkie pola");
            a.showAndWait();
        } else {
            System.out.println("Wprowadziłeś wszystkie dane");
        }
    }

    @FXML
    void deleteAction(MouseEvent event) {

    }

    @FXML
    void exitAction(ActionEvent event) {

    }

    @FXML
    void howToChangeGradeAction(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Jak zmienić ocenę projektu");
        a.setHeaderText("Aby prawidłowo zmienić ocenę, przejdź przez następujące kroki:");
        a.setContentText("1.Przejdź do zakładki odpowiedniego projektu\n"+
                "2.Następnie wybierz za pomocą Spinnera lub Slidera odpowiednią wartość\n"+
                "3.Aby zatwierdzić naciśnij 'Zmień'\n"+
                "*Jeśli chciałabyś/łbyś dokonać zmiany wszystkich pól - nic nie stoi na przeszkodzie ;)");
        a.showAndWait();
    }

    @FXML
    void howToChangeProjectAction(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Jak zmienić opis projektu");
        a.setHeaderText("Aby prawidłowo zmienić opis, przejdź przez następujące kroki:");
        a.setContentText("1.Przejdź do zakładki odpowiedniego projektu\n"+
                "2.Następnie w polu tekstowym uzupełnij wszelkie informacje nt danego projektu\n"+
                "3.Aby zatwierdzić naciśnij 'Zmień'\n"+
                "*Jeśli chciałabyś/łbyś dokonać zmiany wszystkich pól - nic nie stoi na przeszkodzie ;)");
        a.showAndWait();
    }

    @FXML
    void howToChangeUserAction(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Jak zmienić użytkownika");
        a.setHeaderText("Aby prawidłowo zmienić użytkownika i zaczytać jego dane, przejdź przez następujące kroki:");
        a.setContentText("1.Wybierz z listy rozwijanej odpowiednią osobę i kliknij kursorem na niej\n"+
                "Użytkownik zmieniony ;)");
        a.showAndWait();
    }

    @FXML
    void infoAction(ActionEvent event) {
        //Info o projekcie
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Informacje ogólne");
        a.setContentText("\n");
        a.showAndWait();
    }
}