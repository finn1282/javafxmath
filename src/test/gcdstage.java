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
import static test.gradientstage.ShowGraph;


public class gcdstage {
    private static GridPane gcdinputbox = new GridPane();
    private static GridPane gcdoutputbox = new GridPane();
    private static GridPane gcderrorbox = new GridPane();
    public static Button selectgcdbutton = new Button("Select");
    public static ObservableList<String> options = 
        FXCollections.observableArrayList(
        "Calculate Points",
        "Calculate GCD",
        "Calculate Quadratic Equations"
    );
    public static ComboBox comboboxgcd = new ComboBox(options);
    
    public static Scene showstage() {
        gcdinputbox.add(new Label("Input:"), 0, 0);
        TextField input = new TextField();
        gcdinputbox.add(input, 1, 0);
        input.setPromptText("e.g. 1, 2, 3, 4");
        input.getParent().requestFocus();
        Button Calculate = new Button("Calculate");
        gcdinputbox.add(Calculate, 1, 1);
        
        gcdoutputbox.add(new Label("GCD:"), 0, 0);
        TextField result = new TextField();
        gcdoutputbox.add(result, 1, 0);
        result.setEditable(false);
        
        Label error = new Label();
        Label errorresult = new Label();
        gcderrorbox.add(error, 0, 0);
        gcderrorbox.add(errorresult, 1, 0);
        
        Calculate.setOnAction(e -> {
           try{
               error.setText(" ");
               errorresult.setText(" ");
               String inputs = input.getText();
               result.setText(String.valueOf(findgcd.calgcd(inputs)));
           } catch(Exception er) {
               System.out.println("smtg went wrong gcd");
               ShowGraph.setVisible(false);
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
        comboboxgcd.getSelectionModel().selectFirst();
        selections.add(comboboxgcd, 0, 0);
        selections.add(selectgcdbutton, 1, 0);
        VBox gcd = new VBox();
        gcd.getChildren().addAll(gcdinputbox, gcdoutputbox, gcderrorbox, selections);
        Scene GCD = new Scene(gcd);
        return GCD;
    }
}
