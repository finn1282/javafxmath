package test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class lcmstage {
    private static GridPane lcminputbox = new GridPane();
    private static GridPane lcmoutputbox = new GridPane();
    private static GridPane lcmerrorbox = new GridPane();
    public static Button selectlcmbutton = new Button("Select");
    public static ObservableList<String> options = 
        FXCollections.observableArrayList(
        "Calculate Points",
        "Calculate LCM",
        "Calculate GCD",
        "Calculate Quadratic Equations",
        "Calculate Simultaneous Equations"
    );
    public static ComboBox comboboxlcm = new ComboBox(options);
    
    public static Scene showstage() {
        lcminputbox.add(new Label("Input:"), 0, 0);
        TextField input = new TextField();
        lcminputbox.add(input, 1, 0);
        input.setPromptText("e.g. 1, 2, 3, 4");
        input.getParent().requestFocus();
        Button Calculate = new Button("Calculate");
        lcminputbox.add(Calculate, 1, 1);
        
        lcmoutputbox.add(new Label("LCM:"), 0, 0);
        TextField result = new TextField();
        lcmoutputbox.add(result, 1, 0);
        result.setEditable(false);
        
        Label error = new Label();
        Label errorresult = new Label();
        lcmerrorbox.add(error, 0, 0);
        lcmerrorbox.add(errorresult, 1, 0);
        
        Calculate.setOnAction(e -> {
           try{
               error.setText(" ");
               errorresult.setText(" ");
               String inputs = input.getText();
               result.setText(String.valueOf(findlcm.callcm(inputs)));
           } catch(Exception er) {
               System.out.println("smtg went wrong gcd");
               result.setText(" ");
               error.setText("Error:");
                if (checkinput.checkempty(input.getText())) {
                    System.out.println("blank");
                    errorresult.setText("The input is blank");
                } else if (!checkinput.checkletter(input.getText())) {
                    System.out.println("letter");
                    errorresult.setText("The input contains a letter");
                } else {
                    errorresult.setText("Please check your input");
                }
           }
        });
        
        GridPane selections = new GridPane();
        comboboxlcm.getSelectionModel().selectFirst();
        selections.add(comboboxlcm, 0, 0);
        selections.add(selectlcmbutton, 1, 0);
        VBox lcm = new VBox();
        lcm.getChildren().addAll(lcminputbox, lcmoutputbox, lcmerrorbox, selections);
        Scene LCM = new Scene(lcm);
        return LCM;
    }
}
