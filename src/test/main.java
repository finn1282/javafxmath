package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class main extends Application{

    private static final Scene gradientscene = gradientstage.showstage();
    private static final Scene graphscene = graphstage.showstage();
    private static final Scene lcmscene = lcmstage.showstage();
    private static final Scene gcdscene = gcdstage.showstage();
    private static final Scene quadscene = quadstage.showstage();
    private static final Scene simeqscene = simeqstage.showstage();
    private static final Scene indicescene = indicestage.showstage();
    private static final Scene avrgscene = avrgstage.showstage();
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
            } else if (selected == "Calculate LCM") {
                primaryStage.setScene(lcmscene);
            } else if (selected == "Calculate Quadratic Equations") {
                primaryStage.setScene(quadscene);
            } else if (selected == "Calculate Simultaneous Equations") {
                primaryStage.setScene(simeqscene);
            } else if (selected == "Calculate Indice") {
                primaryStage.setScene(indicescene);
            } else if (selected == "Calculate Average") {
                primaryStage.setScene(avrgscene);
            } 
        });
        gradientstage.selectgradientbutton.setOnAction(e -> {
            String selected = (String) gradientstage.comboboxgradient.getValue();
            if (selected == "Calculate Points") {
                primaryStage.setScene(gradientscene);
            } else if (selected == "Calculate GCD") {
                primaryStage.setScene(gcdscene);
            } else if (selected == "Calculate LCM") {
                primaryStage.setScene(lcmscene);
            } else if (selected == "Calculate Quadratic Equations") {
                primaryStage.setScene(quadscene);
            } else if (selected == "Calculate Simultaneous Equations") {
                primaryStage.setScene(simeqscene);
            } else if (selected == "Calculate Indice") {
                primaryStage.setScene(indicescene);
            } else if (selected == "Calculate Average") {
                primaryStage.setScene(avrgscene);
            } 
        });
        quadstage.selectquadbutton.setOnAction(e -> {
            String selected = (String) quadstage.comboboxquad.getValue();
            if (selected == "Calculate Points") {
                primaryStage.setScene(gradientscene);
            } else if (selected == "Calculate GCD") {
                primaryStage.setScene(gcdscene);
            } else if (selected == "Calculate LCM") {
                primaryStage.setScene(lcmscene);
            } else if (selected == "Calculate Quadratic Equations") {
                primaryStage.setScene(quadscene);
            } else if (selected == "Calculate Simultaneous Equations") {
                primaryStage.setScene(simeqscene);
            } else if (selected == "Calculate Indice") {
                primaryStage.setScene(indicescene);
            } else if (selected == "Calculate Average") {
                primaryStage.setScene(avrgscene);
            } 
        });
        lcmstage.selectlcmbutton.setOnAction(e -> {
            String selected = (String) lcmstage.comboboxlcm.getValue();
            if (selected == "Calculate Points") {
                primaryStage.setScene(gradientscene);
            } else if (selected == "Calculate GCD") {
                primaryStage.setScene(gcdscene);
            } else if (selected == "Calculate LCM") {
                primaryStage.setScene(lcmscene);
            } else if (selected == "Calculate Quadratic Equations") {
                primaryStage.setScene(quadscene);
            } else if (selected == "Calculate Simultaneous Equations") {
                primaryStage.setScene(simeqscene);
            } else if (selected == "Calculate Indice") {
                primaryStage.setScene(indicescene);
            } else if (selected == "Calculate Average") {
                primaryStage.setScene(avrgscene);
            } 
        });
        simeqstage.selectsimeqbutton.setOnAction(e -> {
            String selected = (String) simeqstage.comboboxsimeq.getValue();
            if (selected == "Calculate Points") {
                primaryStage.setScene(gradientscene);
            } else if (selected == "Calculate GCD") {
                primaryStage.setScene(gcdscene);
            } else if (selected == "Calculate LCM") {
                primaryStage.setScene(lcmscene);
            } else if (selected == "Calculate Quadratic Equations") {
                primaryStage.setScene(quadscene);
            } else if (selected == "Calculate Simultaneous Equations") {
                primaryStage.setScene(simeqscene);
            } else if (selected == "Calculate Indice") {
                primaryStage.setScene(indicescene);
            } else if (selected == "Calculate Average") {
                primaryStage.setScene(avrgscene);
            } 
        });
        indicestage.selectindicebutton.setOnAction(e -> {
            String selected = (String) indicestage.comboboxindice.getValue();
            if (selected == "Calculate Points") {
                primaryStage.setScene(gradientscene);
            } else if (selected == "Calculate GCD") {
                primaryStage.setScene(gcdscene);
            } else if (selected == "Calculate LCM") {
                primaryStage.setScene(lcmscene);
            } else if (selected == "Calculate Quadratic Equations") {
                primaryStage.setScene(quadscene);
            } else if (selected == "Calculate Simultaneous Equations") {
                primaryStage.setScene(simeqscene);
            } else if (selected == "Calculate Indice") {
                primaryStage.setScene(indicescene);
            } else if (selected == "Calculate Average") {
                primaryStage.setScene(avrgscene);
            } 
        });
        avrgstage.selectavrgbutton.setOnAction(e -> {
            String selected = (String) avrgstage.comboboxavrg.getValue();
            if (selected == "Calculate Points") {
                primaryStage.setScene(gradientscene);
            } else if (selected == "Calculate GCD") {
                primaryStage.setScene(gcdscene);
            } else if (selected == "Calculate LCM") {
                primaryStage.setScene(lcmscene);
            } else if (selected == "Calculate Quadratic Equations") {
                primaryStage.setScene(quadscene);
            } else if (selected == "Calculate Simultaneous Equations") {
                primaryStage.setScene(simeqscene);
            } else if (selected == "Calculate Indice") {
                primaryStage.setScene(indicescene);
            } else if (selected == "Calculate Average") {
                primaryStage.setScene(avrgscene);
            } 
        });


        primaryStage.setScene(gradientscene);
        primaryStage.show();
    }
}

// gcdstage, gradientstage, quadstage, lcmstage, simeqstage, indicestage, avrgstage
/*
    "Calculate Points",
    "Calculate LCM",
    "Calculate GCD",
    "Calculate Quadratic Equations",
    "Calculate Simultaneous Equations",
    "Calculate Indice",
    "Calculate Average"
*/