package com.example.currencyconverter;
//Author: Ramandeep Kaur_200535804
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    //Linking UI components from the FXML file
    @FXML
    private TextField InitialInput;
    @FXML
    private TextField FinalOutput;
    @FXML
    private ComboBox<String> InitialCurrency;
    @FXML
    private ComboBox<String> FinalCurrency;
    @FXML
    private Button Convert;

    //To run the currencyOptions as soon as the application launches
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    currencyOptions();
    }
    public void currencyOptions(){
        String[] currencies = {"INR", "CAD", "USD", "EUR", "PKR"};
        //Add currencies as an option to be selected in comboBox
        InitialCurrency.getItems().addAll(currencies);
        FinalCurrency.getItems().addAll(currencies);
    }
    public void ConvertOnAction(ActionEvent e){
        try {
            //Store user input
            String input = InitialInput.getText();
            String fromCurrency = InitialCurrency.getValue();
            String toCurrency = FinalCurrency.getValue();
            double exRate = 0.0;

            //alter output as per user input using switch-case
            switch (fromCurrency) {
                case "USD":
                    switch (toCurrency) {
                        case "USD":
                            exRate = 1.0;
                            break;
                        case "CAD":
                            exRate = 1.35053;
                            break;
                        case "INR":
                            exRate = 82.2593;
                            break;
                        case "PKR":
                            exRate = 286.882;
                            break;
                        case "EUR":
                            exRate = 0.9199;
                            break;
                    }
                    break;
                case "CAD":
                    switch (toCurrency) {
                        case "USD":
                            exRate = 0.74034;
                            break;
                        case "CAD":
                            exRate = 1.0;
                            break;
                        case "INR":
                            exRate = 60.9;
                            break;
                        case "PKR":
                            exRate = 212.391;
                            break;
                        case "EUR":
                            exRate = 0.68104;
                            break;
                    }
                    break;
                case "EUR":
                    switch (toCurrency) {
                        case "USD":
                            exRate = 1.08692;
                            break;
                        case "CAD":
                            exRate = 1.46792;
                            break;
                        case "INR":
                            exRate = 89.4093;
                            break;
                        case "PKR":
                            exRate = 311.818;
                            break;
                        case "EUR":
                            exRate = 1.0;
                            break;
                    }
                    break;
                case "INR":
                    switch (toCurrency) {
                        case "USD":
                            exRate = 0.01216;
                            break;
                        case "CAD":
                            exRate = 0.01642;
                            break;
                        case "INR":
                            exRate = 1.0;
                            break;
                        case "PKR":
                            exRate = 3.48726;
                            break;
                        case "EUR":
                            exRate = 0.01118;
                            break;
                    }
                    break;
                case "PKR":
                    switch (toCurrency) {
                        case "USD":
                            exRate = 0.00346;
                            break;
                        case "CAD":
                            exRate = 0.00468;
                            break;
                        case "INR":
                            exRate = 0.28488;
                            break;
                        case "PKR":
                            exRate = 1.0;
                            break;
                        case "EUR":
                            exRate = 0.00319;
                            break;
                    }
            }
            //Apply formula and write final output
            double result = Double.parseDouble(input) * exRate;
            FinalOutput.setText(String.format("%.2f", result));
        }
        catch(NumberFormatException ex) {
            FinalOutput.setText("Invalid input");
            //catch exception in case user inputs text instead of number in input text-field
        }
    }
}
