import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Cars extends Application {

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        Pane pane = new Pane();

            Image pic1 = new Image(new FileInputStream("Beetle.svg.png"));
            Image pic2 = new Image(new FileInputStream("Taxi_picture.png"));

        ImageView iv1 = new  ImageView(pic1);
        ImageView iv2 = new  ImageView(pic2);
        iv1.setX(50);
        iv1.setY(50);
        iv1.setFitHeight(150);
        iv1.setFitWidth(150);
        iv2.setX(600);
        iv2.setY(450);
        iv2.setFitWidth(150);
        iv2.setFitHeight(150);
        pane.getChildren().addAll(iv1,iv2);
        Scene scene = new Scene(pane,800,600);
        primaryStage.setTitle("car");
        primaryStage.setScene(scene);
        primaryStage.show();
        Bounds bounds = pane.getBoundsInLocal(); //https://docs.oracle.com/javase/8/javafx/api/javafx/geometry/Bounds.html is where I found the bounds
        //I thought of bounds and timberlines from video game programming
        Timeline tl = new Timeline(new KeyFrame(Duration.seconds(5), new KeyValue(iv1.layoutXProperty(), bounds.getMaxX() + iv1.getFitWidth())));//Time lines for animation bounds gets x locations
        Timeline t2 = new Timeline(new KeyFrame(Duration.seconds(5), new KeyValue(iv2.layoutXProperty(), -bounds.getMaxX() - iv2.getFitWidth())));
        //https://docs.oracle.com/javase/8/javafx/api/javafx/animation/Timeline.html is where I found timelines
        tl.setCycleCount(3);
        tl.play();
        t2.setCycleCount(3);
        t2.play();
    }
}
