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

public class gradientstage extends Stage {
    
    public static double gradient;
    public static double yint;
    public static String equation;
    private static Double x1;
    private static Double y1;
    private static Double x2;
    private static Double y2;
    public static int[] xarray = new int[4];
    public static int[] yarray = new int[4];
    private static GridPane gradientinputsbox = new GridPane();
    private static GridPane gradientoutputsbox = new GridPane();
    private static GridPane gradienterrorbox = new GridPane();
    public static Button ShowGraph = new Button("Show Graph");
    public static Button selectgradientbutton = new Button("Select");
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
    public static ComboBox comboboxgradient = new ComboBox(options);
        
    public static Scene showstage() {
        gradientinputsbox.add(new Label("x1:"), 0, 0);
        gradientinputsbox.add(new Label("y1:"), 0, 1);
        gradientinputsbox.add(new Label("x2:"), 0, 2);
        gradientinputsbox.add(new Label("y2:"), 0, 3);
        TextField firstxValue = new TextField();
        TextField firstyValue = new TextField();
        TextField secondxValue = new TextField();
        TextField secondyValue = new TextField();
        firstxValue.setPromptText("e.g. ([x], y)");
        //firstxValue.getParent().requestFocus();
        firstyValue.setPromptText("e.g. (x, [y])");
        //firstyValue.getParent().requestFocus();
        secondxValue.setPromptText("e.g. ([x], y)");
        //secondxValue.getParent().requestFocus();
        secondyValue.setPromptText("e.g. (x, [y])");
        //secondyValue.getParent().requestFocus();
        gradientinputsbox.add(firstxValue, 1, 0);
        gradientinputsbox.add(firstyValue, 1, 1);
        gradientinputsbox.add(secondxValue, 1, 2);
        gradientinputsbox.add(secondyValue, 1, 3);

        Button Calculate = new Button("Calculate");
        gradientinputsbox.add(Calculate, 1, 4);
        gradientinputsbox.add(ShowGraph, 2, 4);
        ShowGraph.setVisible(false);

        gradientoutputsbox.add(new Label("Result:"), 0, 0);
        gradientoutputsbox.add(new Label("Gradient:"), 0, 1);
        gradientoutputsbox.add(new Label("y-int:"), 0, 2);
        gradientoutputsbox.add(new Label("Equation:"), 0, 3);
        TextField resultValueG = new TextField();
        TextField resultValueY = new TextField();
        TextField resultEquation = new TextField();
        resultValueG.setEditable(false);
        gradientoutputsbox.add(resultValueG, 1, 1);
        resultValueY.setEditable(false);
        gradientoutputsbox.add(resultValueY, 1, 2);
        resultEquation.setEditable(false);
        gradientoutputsbox.add(resultEquation, 1, 3);

        Label error = new Label();
        Label errorresult = new Label();
        gradienterrorbox.add(error, 0, 0);
        gradienterrorbox.add(errorresult, 1, 0);
        
        Calculate.setOnAction(e -> {
            try {
                error.setText(" ");
                errorresult.setText(" ");
                x1 = Double.valueOf(firstxValue.getText());
                y1 = Double.valueOf(firstyValue.getText());
                x2 = Double.valueOf(secondxValue.getText());
                y2 = Double.valueOf(secondyValue.getText());
                xarray[0] = (int) Math.round(x1);
                yarray[0] = (int) Math.round(y1);
                xarray[1] = (int) Math.round(x2);
                yarray[1] = (int) Math.round(y2);
                gradient = getgradient.CalGradient(x1, y1, x2, y2);
                yint = getyint.CalYInt(x1, y1, x2, y2);
                equation = "y="+gradient+"*x+"+yint;
                resultValueG.setText(String.valueOf(gradient));
                resultValueY.setText(String.valueOf(yint));
                resultEquation.setText(equation);
                ShowGraph.setVisible(true);
            } catch(Exception er) {
                System.out.println("smtg went wrong gradientS");
                ShowGraph.setVisible(false);
                resultValueG.setText(" ");
                resultValueY.setText(" ");
                resultEquation.setText(" ");
                error.setText("Error:");
                if (checkinput.checkempty(firstxValue.getText())) {
                    System.out.println("blank");
                    errorresult.setText("One or more of the boxes is blank");
                } else if (!checkinput.checkletter(firstxValue.getText())) {
                    System.out.println("letter");
                    errorresult.setText("One or more of the boxes is a letter");
                } else {
                    errorresult.setText("Please check your input");
                }
                if (checkinput.checkempty(firstyValue.getText())) {
                    System.out.println("blank");
                    errorresult.setText("One or more of the boxes is blank");
                } else if (!checkinput.checkletter(firstyValue.getText())) {
                    System.out.println("letter");
                    errorresult.setText("One or more of the boxes is a letter");
                } else {
                    errorresult.setText("Please check your input");
                }
                if (checkinput.checkempty(secondxValue.getText())) {
                    System.out.println("blank");
                    errorresult.setText("One or more of the boxes is blank");
                } else if (!checkinput.checkletter(secondxValue.getText())) {
                    System.out.println("letter");
                    errorresult.setText("One or more of the boxes is a letter");
                } else {
                    errorresult.setText("Please check your input");
                }
                if (checkinput.checkempty(secondyValue.getText())) {
                    System.out.println("blank");
                    errorresult.setText("One or more of the boxes is blank");
                } else if (!checkinput.checkletter(secondyValue.getText())) {
                    System.out.println("letter");
                    errorresult.setText("One or more of the boxes is a letter");
                } else {
                    errorresult.setText("Please check your input");
                }
            }
        });
        
        GridPane selections = new GridPane();
        comboboxgradient.getSelectionModel().selectFirst();
        selections.add(comboboxgradient, 0, 0);
        selections.add(selectgradientbutton, 1, 0);
        VBox gradient = new VBox();
        gradient.getChildren().addAll(gradientinputsbox, gradientoutputsbox, gradienterrorbox, selections);
        Scene Gradient = new Scene(gradient);
        return Gradient;
    }
}
