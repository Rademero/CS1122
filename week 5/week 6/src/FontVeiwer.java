
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class FontVeiwer extends Application {
    private static final int SMALL_SIZE = 24;
    private static final int MEDIUM_SIZE = 36;
    private static final int LARGE_SIZE = 48;
    private Label label;
    private String facename = "Serif";
    private int size = LARGE_SIZE;
    private FontPosture posture = FontPosture.REGULAR;
    private FontWeight weight = FontWeight.NORMAL;

    public void start(Stage primaryStage) {
        Pane pane = createRootPane();
        Scene scene1 = new Scene(pane);
        primaryStage.setScene(scene1);
        primaryStage.setTitle("Font Viewer");
        primaryStage.show();
    }
    private Pane createRootPane(){
        MenuBar bar = new MenuBar();
        label = new Label("Big Java");
        label.setMinSize(400,300);
        VBox pane = new VBox(bar,label);
        Menu fileMenu = new Menu("File");
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(event -> System.exit(0));
        fileMenu.getItems().add(exitItem);
        Menu fontMenu = new Menu("Font");
        bar.getMenus().addAll(fileMenu, fontMenu);
        Menu faceMenu = new Menu("Face");
        for(int i = 0; i < Font.getFontNames().size(); i++){
            faceMenu.getItems().add(createFaceItem(Font.getFontNames().get(i)));
        }
        Menu sizeMenu = new Menu("Size");
        sizeMenu.getItems().addAll(createSizeItem("Small", SMALL_SIZE), createSizeItem("Medium", MEDIUM_SIZE), createSizeItem("Large", LARGE_SIZE));
        Menu styleMenu = new Menu("Style");
        styleMenu.getItems().addAll(createStyleItem("Plain", FontPosture.REGULAR, FontWeight.NORMAL),
                createStyleItem("Bold", FontPosture.REGULAR, FontWeight.BOLD), createStyleItem("Italic", FontPosture.ITALIC,
                        FontWeight.NORMAL), createStyleItem("Bold Italic", FontPosture.ITALIC, FontWeight.BOLD));
        fontMenu.getItems().addAll(faceMenu,sizeMenu,styleMenu);
        updateFont();
        return pane;
    }

    private MenuItem createFaceItem(String facenameTemp) {
        MenuItem item = new MenuItem(facenameTemp);
        item.setOnAction(event -> {
            facename = facenameTemp;
            updateFont();
        });
        return item;
    }

    private MenuItem createSizeItem(String name, int sizeTemp) {
        MenuItem item = new MenuItem(name);
        item.setOnAction(event -> {
            size = sizeTemp;
            updateFont();
        });
        return item;
    }

    private MenuItem createStyleItem(String name, FontPosture newPosture, FontWeight newWeight) {
        MenuItem item = new MenuItem(name);
        item.setOnAction(event -> {
            posture = newPosture;
            weight = newWeight;
            updateFont();
        });
        return item;
    }

    private void updateFont(){
        label.setFont(Font.font(facename,weight,posture,size));
    }
}
