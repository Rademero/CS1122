/*
*This program will allow a user to choose different font types, depending on the fonts available on the users computer
*
* @author Lindsay Kulpa
*
* CS 1122 Spring 2019
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Exercise2 extends Application {
    private static final int SMALL_SIZE = 24;
    private static final int MEDIUM_SIZE = 36;
    private static final int LARGE_SIZE = 48;
    private Label sample;
    private String facename = "Serif";
    private int size = LARGE_SIZE;
    private FontPosture posture = FontPosture.REGULAR;
    private FontWeight weight = FontWeight.NORMAL;

    public void start(Stage primaryStage) {
        Pane root = createRootPane();
        Scene scene1 = new Scene(root);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("FontViewer");
        primaryStage.show();
    }

    private MenuItem createFaceItem(String newFacename) {
        MenuItem item = new MenuItem(newFacename);
        item.setOnAction(event -> {
            facename = newFacename;
            updateSample();
        });
        return item;
    }

    private MenuItem createSizeItem(String name, int newSize) {
        MenuItem item = new MenuItem(name);
        item.setOnAction(event -> {
            size = newSize;
            updateSample();
        });
        return item;
    }

    private MenuItem createStyleItem(String name, FontPosture newPosture, FontWeight newWeight) {
        MenuItem item = new MenuItem(name);
        item.setOnAction(event -> {
            posture = newPosture;
            weight = newWeight;
            updateSample();
        });
        return item;
    }

    private Pane createRootPane(){
        MenuBar bar = new MenuBar();
        sample = new Label("Big Java");
        sample.setMinSize(400,300);
        VBox pane = new VBox(bar,sample);
        Menu fileMenu = new Menu("File");
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(event -> System.exit(0));
        fileMenu.getItems().add(exitItem);

        Menu fontMenu = new Menu("Font");
        bar.getMenus().addAll(fileMenu, fontMenu);

        Menu faceMenu = new Menu("Face");
        for(int a = 0; a < Font.getFontNames().size(); a++){
        faceMenu.getItems().add(createFaceItem(Font.getFontNames().get(a)));
        }

        Menu sizeMenu = new Menu("Size");
        sizeMenu.getItems().addAll(
                createSizeItem("Small", SMALL_SIZE),
                createSizeItem("Medium", MEDIUM_SIZE),
                createSizeItem("Large", LARGE_SIZE));

        Menu styleMenu = new Menu("Style");
        styleMenu.getItems().addAll(
                createStyleItem("Plain", FontPosture.REGULAR, FontWeight.NORMAL),
                createStyleItem("Bold", FontPosture.REGULAR, FontWeight.BOLD),
                createStyleItem("Italic", FontPosture.ITALIC, FontWeight.NORMAL),
                createStyleItem("Bold Italic", FontPosture.ITALIC, FontWeight.BOLD));

        fontMenu.getItems().addAll(faceMenu,sizeMenu,styleMenu);

        updateSample();
        return pane;
    }

    private void updateSample(){
        sample.setFont(Font.font(facename,weight,posture,size));
    }
}
