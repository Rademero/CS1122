/*
 * Michael Romero
 * Cs1122
 * Predator V.S Prey
 *Set the base properties of the moose
 *This differs to my user notes
 * */
import java.util.ArrayList;
public class Moose extends Animal {
//constructor
    public Moose(Simulator simulator) {
        super(simulator);
    }
    //Calls for the moose to eat grass
    public void eat() {
        int mooseX = getLocationX();
        int mooseY = getLocationY();
        //gos through every grass object and checks to see if there is one in the area for the moose to eat
        for (int i = 0; i < getSimulator().getCurrentGrass().size(); i++) {
            Grass grass = getSimulator().getCurrentGrass().get(i);
            int grassX = grass.getLocationX();
            int grassY = grass.getLocationY();
            //if the moose finds grass then it eats it and its energy gos up
            if ((grassX == mooseX & grassY == mooseY) && (grass.getCurrentGrowth() > 0)) {
                grass.getEaten();
                setEnergy(getEnergy() + getSimulator().getEnergyGainFromEatingGrass());
            }
        }
    }
    //makes a new moose
    public Moose reproduce() {
        if ((getEnergy() >= 310)&&(getSimulator().getMaxX()*getSimulator().getMaxY() >= getSimulator().getCurrentWolfs().size()+getSimulator().getCurrentMoose().size())){
            setEnergy(getSimulator().getInitialEnergy());
            Moose moose = new Moose(getSimulator());
            return moose;
        }
        return null;
    }
    //removes a moose
    public void die() {
        ArrayList<Moose> removeMoose;
        if (getEnergy() <= 0) {
            removeMoose = getSimulator().getCurrentMoose();
            removeMoose.remove(this);
            getSimulator().setCurrentMoose(removeMoose);
        }
    }
    //tells the moose to move
    @Override
    public void move() {
        int xPos = getLocationX();
        int ypos = getLocationY();
        if (xPos == 0) {
            setLocationX(xPos + 1);
        } else if (xPos == getSimulator().getMaxX()) {
            setLocationX(xPos - 1);
        } else {
            int randomx = (int) (Math.random()*3) -1;

            setLocationX(xPos + randomx);
        }
        if (ypos == 0) {
            setLocationY(ypos + 1);
        } else if (ypos == getSimulator().getMaxY()) {
            setLocationY(ypos - 1);
        } else {
            int randomy = (int) (Math.random()*3) -1;

            setLocationY(ypos + randomy);
        }
        setEnergy(getEnergy() - getSimulator().getMovementCost());
    }
}