import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


// All members Matias Hajdinjak
//Zong Deng
//Michael Romero
public class ButtonViewer2 extends Application {
    @Override
        public void start(Stage primaryStage) throws Exception{
        final int[] count2 = {0,0};
            Button button1 = new Button("Click me!");
        button1.setOnAction(event ->{
         //Code to run throught    });

        Button button2 = new Button("Click me!");
        button2.setLayoutX(400);
        button2.setLayoutY(400);
        button2.setOnAction(event ->{
            count2[1]++;
            System.out.println("Button2 clicked " + count2[1] + " times");});
            Pane root1 = new Pane()
                root1.getChildren().addAll(button1,button2);
            Scene scene = new Scene(root1,800,600);
            primaryStage.setTitle("button Viewer");
            primaryStage.setScene(scene);
            primaryStage.show();

        }
    }

