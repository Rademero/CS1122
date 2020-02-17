/*
 * Michael Romero
 * Cs1122
 * Predator V.S Prey
 *This will cause the code to run as well as return information back to the user with 2 graphs
 * */
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Program3Gui extends Application {
    private LineChart<Number, Number> lineChartWolf;//graph for wolfs
    private LineChart<Number, Number> lineChartMoose;//graph for moose
    private XYChart.Series<Number, Number> WolfSe;//data series for wolfs
    private XYChart.Series<Number, Number> Moose;//data series for moose
    private NumberAxis xAxisMoose;//x axis for moose
    private NumberAxis xAxisWolf;//x axis for wolfs
    private Timeline animation;//introduces a timeline
    private double sequence = 0;//count for simulator and iteration count for the graph
    private Simulator sim;
    private int minMoose;
    private int MaxMoose;
    private int minWolf;
    private int MaxWolf;

    public Program3Gui() {
        //Please run for more than 400 ticks to see a big the wolf population change

        // create timeline to add the data
        animation = new Timeline();
        animation.getKeyFrames().add(new KeyFrame(Duration.millis(100),(ActionEvent actionEvent) -> plotTime()));//sets the timeline speed and frame
        animation.setCycleCount(Animation.INDEFINITE);//runs the program indefinitely

        //initialises all values, and make the main simulator
        Run run = new Run();
         sim = run.main();// initializes the simulator
        minMoose = sim.getInitialMoose();
        MaxMoose = sim.getInitialMoose();
        minWolf = sim.getInitialWolves();
        MaxWolf = sim.getInitialWolves();
    }
//Starts the main portion of program/ sets the Gui title
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createGui()));
        primaryStage.setTitle("Predator vs prey");
        primaryStage.show();

        play();

    }
//Launches the entire program
    public static void main(String[] args) {
        launch(args);
    }

//sets up all Gui graphs and layout options
    //@return returns a Parent or screen display field
    public Parent createGui() {
//Sets x and y axis
        xAxisMoose = new NumberAxis();
        xAxisWolf = new NumberAxis();
        final NumberAxis Wolf = new NumberAxis();
        lineChartWolf = new LineChart<>(xAxisWolf, Wolf);
        final NumberAxis moose = new NumberAxis();
        lineChartMoose = new LineChart<>(xAxisMoose, moose);

        // setup chart
        lineChartWolf.setAnimated(false);
        lineChartWolf.setLegendVisible(false);
        lineChartWolf.setTitle("Wolf");
        lineChartMoose.setAnimated(false);
        lineChartMoose.setLegendVisible(false);
        lineChartMoose.setTitle("Moose");
        xAxisMoose.setLabel("days since project start");
        xAxisMoose.setForceZeroInRange(true);
        xAxisWolf.setLabel("days since project start");
        xAxisWolf.setForceZeroInRange(true);
        Wolf.setLabel("Wolves Population");
        Wolf.setTickLabelFormatter(new NumberAxis.DefaultFormatter(Wolf, "  ", null));
        moose.setLabel("Moose Population");
        moose.setTickLabelFormatter(new NumberAxis.DefaultFormatter(moose, "    ", null));

        // add starting data
        WolfSe = new XYChart.Series<>();
        WolfSe.setName("Wolf");
        Moose = new XYChart.Series<>();
        Moose.setName("Moose");

        // create some starting data
        WolfSe.getData().add(new XYChart.Data<Number, Number>(++sequence, sim.getCurrentWolfs().size()));
        Moose.getData().add(new XYChart.Data<Number, Number>(++sequence, sim.getCurrentMoose().size()));


        lineChartWolf.getData().addAll(WolfSe);
        lineChartMoose.getData().addAll(Moose);
//adds both charts to an Hbox to show
        HBox hBox = new HBox();
        hBox.getChildren().addAll(lineChartWolf,lineChartMoose);
        hBox.setSpacing(30);
        return hBox;
    }
//calls for tick to run an iteration of the simulator
    //also adds values to the graph
    private void plotTime() {
        sim.tick();//runs tick
        //check max and min populations
        if (sim.getCurrentMoose().size() < minMoose){
            minMoose = sim.getCurrentMoose().size();
        }else if(sim.getCurrentMoose().size() >MaxMoose){
            MaxMoose = sim.getCurrentMoose().size();
        }
        if (sim.getCurrentWolfs().size() < minWolf){
            minWolf = sim.getCurrentWolfs().size();
        }else if(sim.getCurrentWolfs().size() > MaxWolf){
            MaxWolf = sim.getCurrentWolfs().size();
        }
        //returns text information to the user
        System.out.println("Tick Number: " + sequence);
        System.out.println("There are " + sim.getCurrentMoose().size() + " Moose");
        System.out.println("There are " + sim.getCurrentWolfs().size() + " Wolves\n");
        System.out.println("Max Wolves: " + MaxWolf + " Min Wolves: " + minWolf);
        System.out.println("Max Moose: " + MaxMoose + " Min Moose: " + minMoose);
        //Gets values for the graphs
        WolfSe.getData().add(new XYChart.Data<Number, Number>(++sequence, sim.getCurrentWolfs().size()));
        Moose.getData().add(new XYChart.Data<Number, Number>(++sequence, sim.getCurrentMoose().size()));

//Checks to see if the simulations needs to be stopped
        if(sim.getCurrentWolfs().size() == 0 || sim.getCurrentMoose().size() ==0){
            stop();
        }


    }
//Plays the animation of the graphs
    public void play() {
        animation.play();
    }
//stops the animation and simulator
    @Override
    public void stop() {
        animation.pause();
    }
}