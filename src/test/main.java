package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class main extends Application{

    private static final Scene gradientscene = gradientstage.showstage();
    private static final Scene graphscene = graphstage.showstage();
    private static final Scene gcdscene = gcdstage.showstage();
    private static final Scene quadscene = quadstage.showstage();
    private static int[] xarray = gradientstage.xarray;
    private static int[] yarray = gradientstage.yarray;
    private static XYChart.Series series = graphstage.series;
    

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculate");
       
        gradientstage.ShowGraph.setOnAction(e ->{
            try {
                series.getData().add(new XYChart.Data( xarray[0], yarray[0]));
                series.getData().add(new XYChart.Data( xarray[1], yarray[1]));
                series.setName(gradientstage.equation);
                primaryStage.setScene(graphscene);
            } catch (Exception er) {
                System.out.println("wrong graph problem 1");
            }
        });

        graphstage.backgraph.setOnAction(e -> {
            try{
                primaryStage.setScene(gradientscene);
            } catch (Exception er) {
                System.out.println("wrong graph problem 3");
            }
        });
        
        gcdstage.selectgcdbutton.setOnAction(e -> {
            String selected = (String) gcdstage.comboboxgcd.getValue();
            if (selected == "Calculate Points") {
                primaryStage.setScene(gradientscene);
            } else if (selected == "Calculate GCD") {
                primaryStage.setScene(gcdscene);
            } else if (selected == "Calculate Quadratic Equations") {
                primaryStage.setScene(quadscene);
            }
        });
        gradientstage.selectgradientbutton.setOnAction(e -> {
            String selected = (String) gradientstage.comboboxgradient.getValue();
            if (selected == "Calculate Points") {
                primaryStage.setScene(gradientscene);
            } else if (selected == "Calculate GCD") {
                primaryStage.setScene(gcdscene);
            } else if (selected == "Calculate Quadratic Equations") {
                primaryStage.setScene(quadscene);
            }
        });
        quadstage.selectquadbutton.setOnAction(e -> {
            String selected = (String) quadstage.comboboxquad.getValue();
            if (selected == "Calculate Points") {
                primaryStage.setScene(gradientscene);
            } else if (selected == "Calculate GCD") {
                primaryStage.setScene(gcdscene);
            } else if (selected == "Calculate Quadratic Equations") {
                primaryStage.setScene(quadscene);
            }
        });

        primaryStage.setScene(gradientscene);
        primaryStage.show();
    }
}

// gcdstage, gradientstage, quadstage
/*
    "Calculate Points",
    "Calculate GCD",
    "Calculate Quadratic Equations"
*/