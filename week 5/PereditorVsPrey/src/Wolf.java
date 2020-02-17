/*
 * Michael Romero
 * Cs1122
 * Predator V.S Prey
 *Set the base properties of the wolves
 * This differs to my user notes
 * */

import java.util.ArrayList;

public class Wolf extends Animal {
//constructor
    public Wolf(Simulator simulator) {
        super(simulator);
    }
//tells the wolf to eat
    public void eat() {
        int wolfX = getLocationX();
        int wolfY = getLocationY();
        // Determine if there is a Moose on the same area as the wolf
        for (int i = 0; i < getSimulator().getCurrentMoose().size(); i++) {
            Moose moose = getSimulator().getCurrentMoose().get(i);
            int mooseX = moose.getLocationX();
            int mooseY = moose.getLocationY();
            if (mooseX == wolfX & mooseY == wolfY) {
                moose.setEnergy(0);
                moose.die();//removes the moose
                this.setEnergy(this.getEnergy() + getSimulator().getEnergyGainFromEatingMoose());
                return;
            }
        }

    }
//makes new wolf if it has the required energy
    public Wolf reproduce() {
        if ((getEnergy() >= 300) && (getSimulator().getMaxX()*getSimulator().getMaxY() >= getSimulator().getCurrentWolfs().size()+getSimulator().getCurrentMoose().size())){
            setEnergy(getSimulator().getInitialEnergy());
            Wolf wolf = new Wolf(getSimulator());
            return wolf;
        }
        return null;
    }
    //calls for the wolf to be removed
    public void die() {
        ArrayList<Wolf> removeWolf;
        if (getEnergy() <= 0) {
            removeWolf = getSimulator().getCurrentWolfs();
            removeWolf.remove(this);
            getSimulator().setCurrentWolfs(removeWolf);
        }
    }
    //makes the wolf move
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
