import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

// All members Matias Hajdinjak
//Zong Deng
//Michael Romero

public class InClassChart extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = new Pane();
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        TextField tx = new TextField();
        TextField tx2 = new TextField();
        HBox hbox = new HBox();
        hbox.setLayoutX(500);
        hbox.setLayoutY(500);
        hbox.getChildren().add(tx);
        HBox hbox2 = new HBox();
        hbox2.setLayoutX(200);
        hbox2.setLayoutY(500);
        hbox2.getChildren().addAll(tx2);
        Label nameLable = new Label("name");
        nameLable.setLayoutX(150);
        nameLable.setLayoutY(500);
        Label nameLable2 = new Label("value");
        nameLable2.setLayoutX(450);
        nameLable2.setLayoutY(500);


        final BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis); // number alows all types of numbers
        barChart.setTitle("bar Chart");
        xAxis.setLabel("X-axias");
        yAxis.setLabel("Y-axies");

        Button button1 = new Button("Click me!");
        button1.setOnAction(event ->{
            XYChart.Data<String,Number>  dataElement = new XYChart.Data<String, Number>(tx2.getText(),Integer.parseInt(tx.getText()));
            XYChart.Series series = new XYChart.Series();//New Series will change color
            series.getData().add(dataElement);
            series.setName(hbox.getAccessibleText());
            barChart.getData().addAll(series);
        });

        button1.setLayoutX(400);
        button1.setLayoutY(400);



        Scene scene = new Scene(root, 800, 600);

        root.getChildren().addAll(barChart,button1,hbox,hbox2,nameLable,nameLable2);
        primaryStage.setTitle("My JavaFx Application");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
