import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Test extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        Pane pane = new FlowPane();
        Button bt1 = new Button("Java");
        Button bt2 = new Button("Java");
        Button bt3 = new Button("Java");
        Button bt4 = new Button("Java");
        pane.getChildren().addAll(bt1, bt2, bt3, bt4);

        Scene scene = new Scene(pane, 200, 250);
        primaryStage.setTitle("Test"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited JavaFX
     * support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}