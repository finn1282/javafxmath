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

public class simeqstage extends Stage {
    
    private static double xres;
    private static double yres;
    private static int x1;
    private static int y1;
    private static int x2;
    private static int y2;
    private static int res1;
    private static int res2;
    private static GridPane simeqinputsbox = new GridPane();
    private static GridPane simeqoutputsbox = new GridPane();
    private static GridPane simeqerrorbox = new GridPane();
    public static Button selectsimeqbutton = new Button("Select");
        public static ObservableList<String> options = 
        FXCollections.observableArrayList(
        "Calculate Points",
        "Calculate LCM",
        "Calculate GCD",
        "Calculate Quadratic Equations",
        "Calculate Simultaneous Equations"
    );
    public static ComboBox comboboxsimeq = new ComboBox(options);
        
    public static Scene showstage() {
        simeqinputsbox.add(new Label("x1:"), 0, 0);
        simeqinputsbox.add(new Label("y1:"), 0, 1);
        simeqinputsbox.add(new Label("result:"), 0, 2);
        simeqinputsbox.add(new Label("x2:"), 0, 3);
        simeqinputsbox.add(new Label("y2:"), 0, 4);
        simeqinputsbox.add(new Label("result:"), 0, 5);
        TextField firstxValue = new TextField();
        TextField firstyValue = new TextField();
        TextField firstresultValue = new TextField();
        TextField secondxValue = new TextField();
        TextField secondyValue = new TextField();
        TextField secondresultValue = new TextField();
        firstxValue.setPromptText("e.g. ([x], y)");
        firstyValue.setPromptText("e.g. (x, [y])");
        firstresultValue.setPromptText("e.g. (x, [y])");
        secondxValue.setPromptText("e.g. ([x], y)");
        secondyValue.setPromptText("e.g. (x, [y])");
        secondresultValue.setPromptText("e.g. (x, [y])");
        simeqinputsbox.add(firstxValue, 1, 0);
        simeqinputsbox.add(firstyValue, 1, 1);
        simeqinputsbox.add(firstresultValue, 1, 2);
        simeqinputsbox.add(secondxValue, 1, 3);
        simeqinputsbox.add(secondyValue, 1, 4);
        simeqinputsbox.add(secondresultValue, 1, 5);

        Button Calculate = new Button("Calculate");
        simeqinputsbox.add(Calculate, 1, 6);

        simeqoutputsbox.add(new Label("Result:"), 0, 0);
        simeqoutputsbox.add(new Label("X:"), 0, 1);
        simeqoutputsbox.add(new Label("Y:"), 0, 2);
        TextField resultValuex = new TextField();
        TextField resultValuey = new TextField();
        resultValuex.setEditable(false);
        simeqoutputsbox.add(resultValuex, 1, 1);
        resultValuey.setEditable(false);
        simeqoutputsbox.add(resultValuey, 1, 2);

        Label error = new Label();
        Label errorresult = new Label();
        simeqerrorbox.add(error, 0, 0);
        simeqerrorbox.add(errorresult, 1, 0);
        
        Calculate.setOnAction(e -> {
            try {
                error.setText(" ");
                errorresult.setText(" ");
                x1 = Integer.valueOf(firstxValue.getText());
                y1 = Integer.valueOf(firstyValue.getText());
                x2 = Integer.valueOf(secondxValue.getText());
                y2 = Integer.valueOf(secondyValue.getText());
                res1 = Integer.valueOf(firstresultValue.getText());
                res2 = Integer.valueOf(secondresultValue.getText());
                double[] result = getsimeq.calsimeq(x1, y1, x2, y2, res1, res2);
                resultValuex.setText(String.valueOf(result[0]));
                resultValuey.setText(String.valueOf(result[1]));
            } catch(Exception er) {
                System.out.println("smtg went wrong simeq");
                resultValuex.setText(" ");
                resultValuey.setText(" ");
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
        comboboxsimeq.getSelectionModel().selectFirst();
        selections.add(comboboxsimeq, 0, 0);
        selections.add(selectsimeqbutton, 1, 0);
        VBox gradient = new VBox();
        gradient.getChildren().addAll(simeqinputsbox, simeqoutputsbox, simeqerrorbox, selections);
        Scene Gradient = new Scene(gradient);
        return Gradient;
    }
}
