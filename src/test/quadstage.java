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

public class quadstage extends Stage {
    private static double a;
    private static double b;
    private static double c;
    private static GridPane quadinputsbox = new GridPane();
    private static GridPane quadoutputsbox = new GridPane();
    private static GridPane quaderrorbox = new GridPane();
    public static Button selectquadbutton = new Button("Select");
        public static ObservableList<String> options = 
        FXCollections.observableArrayList(
        "Calculate Points",
        "Calculate LCM",
        "Calculate GCD",
        "Calculate Quadratic Equations",
        "Calculate Simultaneous Equations"
    );
    public static ComboBox comboboxquad = new ComboBox(options);
    
    public static Scene showstage() {
        quadinputsbox.add(new Label("a:"), 0, 0);
        quadinputsbox.add(new Label("b:"), 0, 1);
        quadinputsbox.add(new Label("c:"), 0, 2);
        TextField avalue = new TextField();
        TextField bvalue = new TextField();
        TextField cvalue = new TextField();
        avalue.setPromptText("e.g. [a]x^2+bx+c=0");
        //avalue.getParent().requestFocus();
        bvalue.setPromptText("e.g. ax^2+[b]x+c=0");
        //bvalue.getParent().requestFocus();
        cvalue.setPromptText("e.g. ax^2+bx+[c]=0");
        //cvalue.getParent().requestFocus();
        quadinputsbox.add(avalue, 1, 0);
        quadinputsbox.add(bvalue, 1, 1);
        quadinputsbox.add(cvalue, 1, 2);

        Button Calculate = new Button("Calculate");
        quadinputsbox.add(Calculate, 1, 4);

        quadoutputsbox.add(new Label("Result:"), 0, 0);
        quadoutputsbox.add(new Label("or"), 1, 1);
        TextField resultfirstx = new TextField();
        TextField resultsecondx = new TextField();
        resultfirstx.setEditable(false);
        quadoutputsbox.add(resultfirstx, 1, 0);
        resultsecondx.setEditable(false);
        quadoutputsbox.add(resultsecondx, 1, 2);

        Label error = new Label();
        Label errorresult = new Label();
        quaderrorbox.add(error, 0, 0);
        quaderrorbox.add(errorresult, 1, 0);
    
        Calculate.setOnAction(e -> {
            try {
                error.setText(" ");
                errorresult.setText(" ");
                a = Double.valueOf(avalue.getText());
                b = Double.valueOf(bvalue.getText());
                c = Double.valueOf(cvalue.getText());
                double[] result = getquad.CalQuad(a, b, c);
                double result1 = result[0];
                double result2 = result[1];
                resultfirstx.setText(String.valueOf(result1));
                resultsecondx.setText(String.valueOf(result2));
            } catch(Exception E) {
                System.out.println("smtg went wrong quad");
                resultfirstx.setText(" ");
                resultsecondx.setText(" ");
                error.setText("Error:");
                if (checkinput.checkempty(avalue.getText())) {
                    System.out.println("blank");
                    errorresult.setText("One or more of the boxes is blank");
                } else if (!checkinput.checkletter(avalue.getText())) {
                    System.out.println("letter");
                    errorresult.setText("One or more of the boxes is a letter");
                } else {
                    errorresult.setText("Please check your input");
                }
                if (checkinput.checkempty(bvalue.getText())) {
                    System.out.println("blank");
                    errorresult.setText("One or more of the boxes is blank");
                } else if (!checkinput.checkletter(bvalue.getText())) {
                    System.out.println("letter");
                    errorresult.setText("One or more of the boxes is a letter");
                } else {
                    errorresult.setText("Please check your input");
                }
                if (checkinput.checkempty(cvalue.getText())) {
                    System.out.println("blank");
                    errorresult.setText("One or more of the boxes is blank");
                } else if (!checkinput.checkletter(cvalue.getText())) {
                    System.out.println("letter");
                    errorresult.setText("One or more of the boxes is a letter");
                } else {
                    errorresult.setText("Please check your input");
                }
            }
        });
        
        GridPane selections = new GridPane();
        comboboxquad.getSelectionModel().selectFirst();
        selections.add(comboboxquad, 0, 0);
        selections.add(selectquadbutton, 1, 0);
        VBox quad = new VBox();
        quad.getChildren().addAll(quadinputsbox, quadoutputsbox, quaderrorbox, selections);
        Scene Quad = new Scene(quad);
        return Quad;
    }
}
