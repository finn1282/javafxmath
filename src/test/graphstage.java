package test;

import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class graphstage {
    private static GridPane graphexitbutton = new GridPane();
    public static Button backgraph = new Button("Back");
    private static int[] xarray = gradientstage.xarray;
    private static int[] yarray = gradientstage.yarray;
    public static XYChart.Series series = new XYChart.Series();
    
    public static Scene showstage() {
        graphexitbutton.add(backgraph, 0, 0);
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
        
        VBox graph = new VBox();
        VBox.setVgrow(lineChart, Priority.ALWAYS);
        graph.getChildren().addAll(lineChart, graphexitbutton);

        Scene Graph = new Scene(graph);
        
        lineChart.getData().add(series);
        
        return Graph;
    }
}
