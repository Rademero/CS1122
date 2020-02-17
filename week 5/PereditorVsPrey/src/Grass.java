/*
 * Michael Romero
 * Cs1122
 * Predator V.S Prey
 *This sets up the actions of the grass
 *
 * */

import java.util.ArrayList;

public class Grass {
    private Simulator simulator;
    private int locationX;
    private int locationY;
    private double CurrentGrowth;
    // CONSTRUCTOR
    public Grass(Simulator simulator) {
        this.simulator = simulator;
        locationX = simulator.randomInt(simulator.getMaxX());
        locationY = simulator.randomInt(simulator.getMaxY());
        CurrentGrowth = simulator.getGrassGrowthRate();
    }
    // METHODS
    //Makes the grass "grow" so it can spread
    public void grow() {
        double currentGrass = getCurrentGrowth();
        currentGrass += simulator.getGrassGrowthRate();
        setCurrentGrowth(currentGrass);
    }
    //sets the spread of the grass
    public void spread() {
        if (getCurrentGrowth() >= 10) {
            setCurrentGrowth(2);
            //sets all to false before checking th position
            boolean isLeft = false;
            boolean isRight = false;
            boolean isAbove = false;
            boolean isBelow = false;
            boolean leftUp = false;
            boolean rightUp = false;
            boolean leftDown = false;
            boolean rightDown = false;

            Grass newGrass = new Grass(simulator);
            int xPos = getLocationX(); // x location of original grass
            int yPos = getLocationY(); // y location of original grass

            //checks to see if surrounding tiles are filled with grass
            for (int j = 0; j < simulator.getCurrentGrass().size(); j++) {
                Grass grass = simulator.getCurrentGrass().get(j);
                if (xPos + 1 == grass.getLocationX() & yPos == grass.getLocationY()) {
                    isRight = true;
                }if (xPos - 1 == grass.getLocationX() & yPos == grass.getLocationY()) {
                    isLeft = true;
                }if (yPos - 1 == grass.getLocationY() & xPos == grass.getLocationX()) {
                    isAbove = true;
                }if (yPos + 1 == grass.getLocationY() & xPos == grass.getLocationX()) {
                    isBelow = true;
                }if (xPos + 1 == grass.getLocationX() & yPos - 1 == grass.getLocationY()) {
                    rightUp = true;
                }if (xPos + 1 == grass.getLocationX() & yPos + 1 == grass.getLocationY()) {
                    rightDown = true;
                }if (xPos - 1 == grass.getLocationX() & yPos - 1 == grass.getLocationY()) {
                    leftUp = true;
                }if (xPos - 1 == grass.getLocationX() & yPos + 1 == grass.getLocationY()) {
                    leftDown = true;
                }
            }
            //if there is no grass in one of the surrounding spaces it is filled
            if (isAbove == false) {
                if (yPos != 1) {
                    newGrass.setLocationX(xPos);
                    newGrass.setLocationY(yPos - 1);
                    ArrayList<Grass> temp = simulator.getCurrentGrass();
                    temp.add(newGrass);
                    simulator.setCurrentGrass(temp);
                }
            }if (isBelow == false) {
                if (yPos != simulator.getMaxY()) {
                    newGrass.setLocationX(xPos);
                    newGrass.setLocationY(yPos + 1);
                    ArrayList<Grass> temp = simulator.getCurrentGrass();
                    temp.add(newGrass);
                    simulator.setCurrentGrass(temp);
                }
            }if (isRight == false) {
                if (xPos != simulator.getMaxX()) {
                    newGrass.setLocationX(xPos + 1);
                    newGrass.setLocationY(yPos);
                    ArrayList<Grass> temp = simulator.getCurrentGrass();
                    temp.add(newGrass);
                    simulator.setCurrentGrass(temp);
                }
            }if (isLeft == false) {
                if (xPos != 1) {
                    newGrass.setLocationX(xPos - 1);
                    newGrass.setLocationY(yPos);
                    ArrayList<Grass> temp = simulator.getCurrentGrass();
                    temp.add(newGrass);
                    simulator.setCurrentGrass(temp);
                }
            }if (rightUp == false) {
                if (xPos != simulator.getMaxX() & yPos != 1) {
                    newGrass.setLocationX(xPos + 1);
                    newGrass.setLocationY(yPos - 1);
                    ArrayList<Grass> temp = simulator.getCurrentGrass();
                    temp.add(newGrass);
                    simulator.setCurrentGrass(temp);
                }
            }if (rightDown == false) {
                if (xPos != simulator.getMaxX() & yPos != simulator.getMaxY()) {
                    newGrass.setLocationX(xPos + 1);
                    newGrass.setLocationY(yPos + 1);
                    ArrayList<Grass> temp = simulator.getCurrentGrass();
                    temp.add(newGrass);
                    simulator.setCurrentGrass(temp);
                }
            }if (leftUp == false) {
                if (xPos != 1 & yPos != 1) {
                    newGrass.setLocationX(xPos - 1);
                    newGrass.setLocationY(yPos - 1);
                    ArrayList<Grass> temp = simulator.getCurrentGrass();
                    temp.add(newGrass);
                    simulator.setCurrentGrass(temp);
                }
            }if (leftDown == false) {
                if (xPos != 1 & yPos != simulator.getMaxY()) {
                    newGrass.setLocationX(xPos - 1);
                    newGrass.setLocationY(yPos + 1);
                    ArrayList<Grass> temp = simulator.getCurrentGrass();
                    temp.add(newGrass);
                    simulator.setCurrentGrass(temp);
                }
            }
        }
    }
//Removes the length of the grass if it needs to be eaten
    public void getEaten() {
        if (getCurrentGrowth() <= 0) {
            ArrayList<Grass> temp;
            temp = simulator.getCurrentGrass();
            temp.remove(this);
            simulator.setCurrentGrass(temp);
        } else {
            double eaten = getCurrentGrowth();
            eaten -= simulator.getEnergyGainFromEatingGrass();
            setCurrentGrowth(eaten);
        }
    }
    // GETTERS AND SETTERS
    public int getLocationX() {
        return locationX;
    }
    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }
    public int getLocationY() {
        return locationY;
    }
    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }
    public double getCurrentGrowth() {
        return CurrentGrowth;
    }
    public void setCurrentGrowth(double currentGrowth) {
        this.CurrentGrowth = currentGrowth;
    }
}