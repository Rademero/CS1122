import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

//Michael Romero
//CS 1122
//Week 5 Ex

public class GraphEx extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        final BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis); // number alows all types of numbers
        barChart.setTitle("Longest Bridge");
        yAxis.setLabel("Bridge Length");
        xAxis.setTickLabelsVisible(false);

        XYChart.Data<String,Number>  dataElement = new XYChart.Data<String, Number>("Brooklyn",1595 );
        XYChart.Data<String,Number>  dataElement2 = new XYChart.Data<String, Number>("Golden Gate",4200);
        XYChart.Data<String,Number>  dataElement3 = new XYChart.Data<String, Number>("Delaware Memorial",2150);
        XYChart.Data<String,Number>  dataElement4 = new XYChart.Data<String, Number>("Mackinac",3800);

        XYChart.Series series = new XYChart.Series();
        XYChart.Series series2 = new XYChart.Series();
        XYChart.Series series3 = new XYChart.Series();
        XYChart.Series series4 = new XYChart.Series();

        series.getData().add(dataElement);
        series.setName("Brooklyn");
        series2.getData().add(dataElement2);
        series2.setName("Golden Gate");
        series3.getData().add(dataElement3);
        series3.setName("Delaware Memorial");
        series4.getData().add(dataElement4);
        series4.setName("Mackinac");


        barChart.getData().addAll(series,series2,series3,series4);

        root.getChildren().add(barChart);
        Scene scene = new Scene(root,800,600);
        primaryStage.setTitle("Longest Bridge");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
