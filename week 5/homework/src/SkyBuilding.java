import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

//Michael Romero
//CS 1122
//Week 5 Ex
public class SkyBuilding extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = new Pane();


        Line line = new Line(150,150,150, 700);
        line.setStroke(Color.BLACK);
        Line line2 = new Line(500,150,500, 700);
        line.setStroke(Color.BLACK);
        Line line3 = new Line(150,150,500, 150);
        line.setStroke(Color.BLACK);
        Line line4 = new Line(150,700,500, 700);
        line.setStroke(Color.BLACK);
        Line line5 = new Line(150,150,200, 75);
        line.setStroke(Color.BLACK);
        Line line6 = new Line(500,150,550, 75);
        line.setStroke(Color.BLACK);
        Line line7 = new Line(200,75,550, 75);
        line.setStroke(Color.BLACK);
        Line line8 = new Line(550,75,550, 625);
        line.setStroke(Color.BLACK);
        Line line9 = new Line(500,700,550, 626);
        line.setStroke(Color.BLACK);
        Line line10 = new Line(525,115,525, 665);
        line10.setStroke(Color.AQUA);
        Line line11 = new Line(250,150,250, 700);
        line11.setStroke(Color.AQUA);
        Line line12 = new Line(350,150,350, 700);
        line12.setStroke(Color.AQUA);
        Line line13 = new Line(425,150,425, 700);
        line13.setStroke(Color.AQUA);
        Line line14 = new Line(150,250,500, 250);
        line14.setStroke(Color.AQUA);
        Line line15 = new Line(150,350,500, 350);
        line15.setStroke(Color.AQUA);
        Line line16 = new Line(150,450,500, 450);
        line16.setStroke(Color.AQUA);
        Line line17 = new Line(150,550,500, 550);
        line17.setStroke(Color.AQUA);
        Line line18 = new Line(150,650,500, 650);
        line18.setStroke(Color.AQUA);
        Line line19 = new Line(500,250,550, 175);
        line19.setStroke(Color.AQUA);
        Line line20 = new Line(500,350,550, 275);
        line20.setStroke(Color.AQUA);
        Line line21 = new Line(500,450,550, 375);
        line21.setStroke(Color.AQUA);
        Line line22 = new Line(500,550,550, 475);
        line22.setStroke(Color.AQUA);
        Line line23 = new Line(500,650,550, 575);
        line23.setStroke(Color.AQUA);
        Line line24 = new Line(250,125,250, 75);
        Line line25 = new Line(300,125,300, 75);
        Line line26 = new Line(250,125,300, 125);
        Line line27 = new Line(250,75,300, 75);
        Line line28 = new Line(250,75,265, 60);
        Line line29 = new Line(300,75,315, 60);
        Line line30 = new Line(265,60,315, 60);
        Line line31 = new Line(315,60,315, 110);
        Line line32 = new Line(300, 125,315, 110);


        root.getChildren().addAll(line,line2,line3,line4,line5,line6,line7,line8,line9,line10,line11,line12,line13,line14,line15,line16,line17,line18);
        root.getChildren().addAll(line19,line20,line21,line22,line23,line24,line25,line26,line27,line28,line29,line30,line31,line32);
        Scene scene = new Scene(root,800,900);
        primaryStage.setTitle("My Building");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
