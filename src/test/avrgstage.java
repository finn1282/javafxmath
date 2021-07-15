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


public class avrgstage {
    private static GridPane avrginputbox = new GridPane();
    private static GridPane avrgoutputbox = new GridPane();
    private static GridPane avrgerrorbox = new GridPane();
    public static Button selectavrgbutton = new Button("Select");
    public static ObservableList<String> options = 
        FXCollections.observableArrayList(
        "Calculate Points",
        "Calculate LCM",
        "Calculate avrg",
        "Calculate Quadratic Equations",
        "Calculate Simultaneous Equations",
        "Calculate Indice",
        "Calculate Average"
    );
    public static ComboBox comboboxavrg = new ComboBox(options);
    
    public static Scene showstage() {
        avrginputbox.add(new Label("Input:"), 0, 0);
        TextField input = new TextField();
        avrginputbox.add(input, 1, 0);
        input.setPromptText("e.g. 1, 2, 3, 4");
        input.getParent().requestFocus();
        Button Calculate = new Button("Calculate");
        avrginputbox.add(Calculate, 1, 1);
        
        avrgoutputbox.add(new Label("mean:"), 0, 0);
        avrgoutputbox.add(new Label("median:"), 0, 1);
        avrgoutputbox.add(new Label("mode:"), 0, 2);
        TextField mean = new TextField();
        TextField median = new TextField();
        TextField mode = new TextField();
        avrgoutputbox.add(mean, 1, 0);
        avrgoutputbox.add(median, 1, 1);
        avrgoutputbox.add(mode, 1, 2);
        mean.setEditable(false);
        median.setEditable(false);
        mode.setEditable(false);
        
        Label error = new Label();
        Label errorresult = new Label();
        avrgerrorbox.add(error, 0, 0);
        avrgerrorbox.add(errorresult, 1, 0);
        
        Calculate.setOnAction(e -> {
           try{
               error.setText(" ");
               errorresult.setText(" ");
               String inputs = input.getText();
               mean.setText(String.valueOf(getavrg.calmean(inputs)));
               median.setText(String.valueOf(getavrg.calmedian(inputs)));
               mode.setText(String.valueOf(getavrg.calmode(inputs)));
           } catch(Exception er) {
               System.out.println("smtg went wrong avrg");
               mean.setText(" ");
               median.setText(" ");
               mode.setText(" ");
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
        comboboxavrg.getSelectionModel().selectFirst();
        selections.add(comboboxavrg, 0, 0);
        selections.add(selectavrgbutton, 1, 0);
        VBox avrg = new VBox();
        avrg.getChildren().addAll(avrginputbox, avrgoutputbox, avrgerrorbox, selections);
        Scene Avrg = new Scene(avrg);
        return Avrg;
    }
}
