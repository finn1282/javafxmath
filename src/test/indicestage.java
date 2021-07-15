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
import javafx.stage.Stage;

public class indicestage extends Stage {
    
    private static int n1;
    private static int cox1;
    private static int c1;
    private static int n2;
    private static int cox2;
    private static int c2;
    private static GridPane indiceinputsbox = new GridPane();
    private static GridPane indiceoutputsbox = new GridPane();
    private static GridPane indiceerrorbox = new GridPane();
    public static Button selectindicebutton = new Button("Select");
        public static ObservableList<String> options = 
        FXCollections.observableArrayList(
        "Calculate Points",
        "Calculate LCM",
        "Calculate GCD",
        "Calculate Quadratic Equations",
        "Calculate Simultaneous Equations",
        "Calculate Indice",
        "Calculate Average"
    );
    public static ComboBox comboboxindice = new ComboBox(options);
        
    public static Scene showstage() {
        indiceinputsbox.add(new Label("n1:"), 0, 0);
        indiceinputsbox.add(new Label("x-coeffecient1:"), 0, 1);
        indiceinputsbox.add(new Label("constant1:"), 0, 2);
        indiceinputsbox.add(new Label("n2:"), 0, 3);
        indiceinputsbox.add(new Label("x-coeffecient2:"), 0, 4);
        indiceinputsbox.add(new Label("constant2:"), 0, 5);
        TextField firstnValue = new TextField();
        TextField firstcoxValue = new TextField();
        TextField firstconValue = new TextField();
        TextField secondnValue = new TextField();
        TextField secondcoxValue = new TextField();
        TextField secondconValue = new TextField();
        firstnValue.setPromptText("e.g. [n]^(x+con)");
        firstcoxValue.setPromptText("e.g. n^([]x+con");
        firstconValue.setPromptText("e.g. n^(x+[con])");
        secondnValue.setPromptText("e.g. [n]^(x+con)");
        secondcoxValue.setPromptText("e.g. n^([]x+con");
        secondconValue.setPromptText("e.g. n^(x+[con]");
        indiceinputsbox.add(firstnValue, 1, 0);
        indiceinputsbox.add(firstcoxValue, 1, 1);
        indiceinputsbox.add(firstconValue, 1, 2);
        indiceinputsbox.add(secondnValue, 1, 3);
        indiceinputsbox.add(secondcoxValue, 1, 4);
        indiceinputsbox.add(secondconValue, 1, 5);

        Button Calculate = new Button("Calculate");
        indiceinputsbox.add(Calculate, 1, 6);

        indiceoutputsbox.add(new Label("Result:"), 0, 0);
        indiceoutputsbox.add(new Label("X:"), 0, 1);
        TextField resultValuex = new TextField();
        resultValuex.setEditable(false);
        indiceoutputsbox.add(resultValuex, 1, 1);

        Label error = new Label();
        Label errorresult = new Label();
        indiceerrorbox.add(error, 0, 0);
        indiceerrorbox.add(errorresult, 1, 0);
        
        Calculate.setOnAction(e -> {
            try {
                error.setText(" ");
                errorresult.setText(" ");
                n1 = Integer.valueOf(firstnValue.getText());
                cox1 = Integer.valueOf(firstcoxValue.getText());
                c1 = Integer.valueOf(firstconValue.getText());
                n2 = Integer.valueOf(secondnValue.getText());
                cox2 = Integer.valueOf(secondcoxValue.getText());
                c2 = Integer.valueOf(secondconValue.getText());
                double result = getindice.calindc(n1, cox1, c1, n2, cox2, c2);
                resultValuex.setText(String.valueOf(result));
            } catch(Exception er) {
                System.out.println("smtg went wrong simeq");
                resultValuex.setText(" ");
                error.setText("Error:");
                if (checkinput.checkempty(firstnValue.getText())) {
                    System.out.println("blank");
                    errorresult.setText("One or more of the boxes is blank");
                } else if (!checkinput.checkletter(firstnValue.getText())) {
                    System.out.println("letter");
                    errorresult.setText("One or more of the boxes is a letter");
                } else {
                    errorresult.setText("Please check your input");
                }
                if (checkinput.checkempty(firstcoxValue.getText())) {
                    System.out.println("blank");
                    errorresult.setText("One or more of the boxes is blank");
                } else if (!checkinput.checkletter(firstcoxValue.getText())) {
                    System.out.println("letter");
                    errorresult.setText("One or more of the boxes is a letter");
                } else {
                    errorresult.setText("Please check your input");
                }
                if (checkinput.checkempty(firstconValue.getText())) {
                    System.out.println("blank");
                    errorresult.setText("One or more of the boxes is blank");
                } else if (!checkinput.checkletter(firstconValue.getText())) {
                    System.out.println("letter");
                    errorresult.setText("One or more of the boxes is a letter");
                } else {
                    errorresult.setText("Please check your input");
                }
                if (checkinput.checkempty(secondnValue.getText())) {
                    System.out.println("blank");
                    errorresult.setText("One or more of the boxes is blank");
                } else if (!checkinput.checkletter(secondnValue.getText())) {
                    System.out.println("letter");
                    errorresult.setText("One or more of the boxes is a letter");
                } else {
                    errorresult.setText("Please check your input");
                }
                if (checkinput.checkempty(secondcoxValue.getText())) {
                    System.out.println("blank");
                    errorresult.setText("One or more of the boxes is blank");
                } else if (!checkinput.checkletter(secondcoxValue.getText())) {
                    System.out.println("letter");
                    errorresult.setText("One or more of the boxes is a letter");
                } else {
                    errorresult.setText("Please check your input");
                }
                if (checkinput.checkempty(secondconValue.getText())) {
                    System.out.println("blank");
                    errorresult.setText("One or more of the boxes is blank");
                } else if (!checkinput.checkletter(secondconValue.getText())) {
                    System.out.println("letter");
                    errorresult.setText("One or more of the boxes is a letter");
                } else {
                    errorresult.setText("Please check your input");
                }
            }
        });
        
        GridPane selections = new GridPane();
        comboboxindice.getSelectionModel().selectFirst();
        selections.add(comboboxindice, 0, 0);
        selections.add(selectindicebutton, 1, 0);
        VBox indice = new VBox();
        indice.getChildren().addAll(indiceinputsbox, indiceoutputsbox, indiceerrorbox, selections);
        Scene Indice = new Scene(indice);
        return Indice;
    }
}

