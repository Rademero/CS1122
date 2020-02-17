import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class InClassGraph extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = new Pane();
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        final BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis); // number alows all types of numbers
        barChart.setTitle("bar Chart");
        xAxis.setLabel("X-axias");
        yAxis.setLabel("Y-lables");
        yAxis.setTickLabelsVisible(true);

        XYChart.Data<String,Number>  dataElement = new XYChart.Data<String, Number>("Detroit",417);
        XYChart.Data<String,Number>  dataElement2 = new XYChart.Data<String, Number>("Lansing",700);
        XYChart.Data<String,Number>  dataElement3 = new XYChart.Data<String, Number>("Carlotte",600);
//You can inport import javafx.scene.chart.XYChart.Data; and just use data insdead of XYChart.Data same with serise
        XYChart.Series series = new XYChart.Series();//New Series will change color
        XYChart.Series series2 = new XYChart.Series();//New Series will change color
        series.getData().add(dataElement);
        series.setName("Detroit");
        series.getData().add(dataElement2);
        series.setName("Lansing");
        series2.getData().add(dataElement3);
        series2.setName("Charlotte");

        barChart.getData().addAll(series);
        barChart.getData().add(series2);


        Scene scene = new Scene(root, 800, 600);

        root.getChildren().add(barChart);
        primaryStage.setTitle("My JavaFx Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
