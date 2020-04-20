package app.ui;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import app.data.HotelItem;
import app.data.Location;
import app.data.Review;
import app.data.Tag;
import app.utils.Catalog;
import app.utils.IManage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class HotelSearch implements Initializable {

    @FXML
    private CheckBox vestur;
    @FXML
    private CheckBox nordur;
    @FXML
    private CheckBox sudur;
    @FXML
    private CheckBox austur;
    @FXML
    private DatePicker checkindate;
    @FXML
    private DatePicker checkoutdate;
    @FXML
    private Button doSearch;
    @FXML
    private TextField searchString;
    @FXML
    private ListView<String> resultList;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }

    @FXML
    private void SearchHandler(ActionEvent event) throws IOException {
        resultList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        resultList.getItems().clear();
        searchHotels(getSearchString());
    }

    private String searchHotels(String s) {
        Catalog catalog = new Catalog();
        String res = "";

        List<HotelItem> hotels = catalog.find(s);
        for (HotelItem hotel : hotels) {
            res += "Nafn: " + hotel.getName() + "\nLýsing: " + hotel.getDescription() + "\nUrl: " + hotel.getUrl();

            res += "\nLocation: ";
            for (Location location : hotel.getLocation()) {
                res += location.getName() + " ";
            }

            res += "\nTags: ";
            for (Tag tag : hotel.getTags()) {
                res += tag.getName() + " ";
            }

            res += "\nReviews: ";
            for (Review review : hotel.getReviews()) {
                res += review.getText() + " ";
            }

            res += "\n----------------------------\n";
        }

        resultList.getItems().add(res);
        return res;
    }
    
    private LocalDate getDatein() {
        return checkindate.getValue() ;
    }
    
     private LocalDate getDateout(){
        return checkoutdate.getValue();
    }
     
     private Boolean isAustur() {
         if (austur.isSelected()) return true;
         return false;     
     }
     
     private Boolean isSudur() {
        if (sudur.isSelected()) return true;
        return false;     
     }
 
     private Boolean isVestur() {
        if (vestur.isSelected()) return true;
        return false;     
     }
 
     private Boolean isNordur() {
        if (nordur.isSelected()) return true;
        return false;     
     }

     private String getSearchString() {
         String res = "";
         if (isAustur() == true) res += "Austurland ";
         if (isNordur() == true) res += "Norðurland ";
         if (isSudur() == true) res += "Suðurland ";
         if (isVestur() == true) res += "Vesturland";
         if (searchString != null) res += searchString.getText();

         return res;
     }
}