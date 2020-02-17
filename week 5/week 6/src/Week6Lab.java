// IMPORTS
// These are some classes that may be useful for completing the project.
// You may have to add others.
//Michael Romero
//Matias Hajdinjak
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebHistory.Entry;
import javafx.stage.Stage;
import javafx.concurrent.Worker.State;
import javafx.concurrent.Worker;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * The main class for Week6Lab. Week6Lab constructs the JavaFX window and
 * handles interactions with the dynamic components contained therein.
 * Michael Romero
 * cs1122
 *
 */
public class Week6Lab extends Application {
    // INSTANCE VARIABLES
    // These variables are included to get you started.
    private Stage stage = null;
    private BorderPane borderPane = null;
    private WebView view = null;
    private WebEngine webEngine = null;
    private TextField statusbar = null;
    private TextField tx = null;

    // HELPER METHODS
    /**
     * Retrieves the value of a command line argument specified by the index.
     *
     * @param index - position of the argument in the args list.
     * @return The value of the command line argument.
     */
    private String getParameter( int index ) {
        Parameters params = getParameters();
        List<String> parameters = params.getRaw();
        return !parameters.isEmpty() ? parameters.get(index) : "";
    }

    /**
     * Creates a WebView which handles mouse and some keyboard events, and
     * manages scrolling automatically, so there's no need to put it into a ScrollPane.
     * The associated WebEngine is created automatically at construction time.
     *
     * @return browser - a WebView container for the WebEngine.
     */
    private WebView makeHtmlView( ) {
        view = new WebView();
        webEngine = view.getEngine();
        return view;
    }

    /**
     * Generates the status bar layout and text field.
     *
     * @return statusbarPane - the HBox layout that contains the statusbar.
     */
    private HBox makeStatusBar( ) {
        HBox statusbarPane = new HBox();
        statusbarPane.setPadding(new Insets(5, 4, 5, 4));
        statusbarPane.setSpacing(10);
        statusbarPane.setStyle("-fx-background-color: #336699;");
        statusbar = new TextField();
        HBox.setHgrow(statusbar, Priority.ALWAYS);
        statusbarPane.getChildren().addAll(statusbar);
        return statusbarPane;
    }

    // REQUIRED METHODS
    /**
     * The main entry point for all JavaFX applications. The start method is
     * called after the init method has returned, and after the system is ready
     * for the application to begin running.
     *
     * NOTE: This method is called on the JavaFX Application Thread.
     *
     * @param primaryStage - the primary stage for this application, onto which
     * the application scene can be set.
     */
    @Override
    public void start(Stage primaryStage) {
        // Build your window here.
        borderPane = new BorderPane();
        view = makeHtmlView();
        HBox statusHbox =makeStatusBar();
        HBox toolBarHb = new HBox();


        tx = new TextField();
        toolBarHb.getChildren().add(tx);
        Button Back = new Button();//Back
        Back.setText("<---");
        Button Forward = new Button();
        Forward.setText("---> ");//Forward
        Button Help = new Button();
        Help.setText("?");//Help
        HBox toolBar = new HBox();
        toolBar.getChildren().addAll(Back,Forward,toolBarHb);
        toolBar.getChildren().addAll(Help);
        toolBar.setSpacing(10);




       tx.setOnAction(event -> {
           if (tx.getText().startsWith("http")){
               webEngine.load(tx.getText());
           }
           else {
               webEngine.load("http://" + tx.getText());
           }

       });

       Back.setOnAction(event -> {
           try {
               webEngine.getHistory().go(-1);
           }catch (Exception e){
              statusbar.setText("Sorry but no previous link");
           }

       });
        Forward.setOnAction(event -> {
           try {
               webEngine.getHistory().go(1);
           }catch (Exception e){
               statusbar.setText("Sorry but no other link");
           }
       });

        Help.setOnAction(event -> {
           webEngine.loadContent("<HTML>><HEAD><TITLE><HELP</TITLE></HEAD><BODY><H1></BODY>This is the help page</H1></BODY></HTML>");
       });
        webEngine.load("http://www.mtu.edu");

        webEngine.setOnStatusChanged(e ->{
            statusbar.setText(e.getData());
        });


        webEngine.getLoadWorker().stateProperty().addListener(
                new ChangeListener<State>() {
            @Override
            public void changed(ObservableValue<? extends State> observable, State oldValue, State newValue) {
                if (newValue == State.SUCCEEDED){
                    tx.setText(webEngine.getLocation());
                }

            }
        }
        );


        borderPane.setTop(toolBar);
        borderPane.setCenter(view);
        borderPane.setBottom(statusHbox);
        toolBar.setHgrow(toolBarHb, Priority.ALWAYS);
        toolBar.setHgrow(tx, Priority.ALWAYS);



        Scene scene = new Scene(borderPane,800,600);
        primaryStage.setTitle("Web");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main( ) method is ignored in JavaFX applications.
     * main( ) serves only as fallback in case the application is launched
     * as a regular Java application, e.g., in IDEs with limited FX
     * support.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
