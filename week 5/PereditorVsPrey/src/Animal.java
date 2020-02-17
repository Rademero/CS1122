/*
 * Michael Romero
 * Cs1122
 * Predator V.S Prey
 *This sets up the base properties of the animals
 * */

public abstract class Animal {
    // -----------------------------------------------------------------------
    // INSTANCE VARIABLES
    // -----------------------------------------------------------------------
    // Every animal gets a copy of the running simulation
    // This provides access to the simulation settings
    private Simulator simulator;
    // The location of the animal
    private int locationX;
    private int locationY;
    // The energy maintained by the animal
    // If energy < 0.0, the animal dies.
    private double energy;

    // -----------------------------------------------------------------------
    // ABSTRACT METHODS
    // -----------------------------------------------------------------------

    /**
     * Increases the animal's energy by consuming a food source.
     * Moose consumes grass if present in the same location. Decreasing the grass
     * by grassGrowthRate.
     * Wolf consumes moose if in the same location. Killing the moose.
     */
    public abstract void eat();

    /**
     * If the animal's energy > 200.0, the spawn a new animal.
     * Both animals get half the total energy.
     *
     * @return the new animal
     */
    public abstract Animal reproduce();

    /**
     * Animals with energy < 0.0 die and are removed from the game.
     *
     * @return the dead animal or null if animal survives.
     */
    public abstract void die();

    /**
     * Animal moves to an adjacent area.
     * This subtracts movementCost from energy
     */
    public abstract void move();

    // -----------------------------------------------------------------------
    // CONSTRUCTOR
    // -----------------------------------------------------------------------

    /**
     * Animals are spawned at a random location with the energy specified by the simulator
     *
     * @param simulator - Contains initial settings
     */
    public Animal(Simulator simulator) {
        this.simulator = simulator;
        locationX = simulator.randomInt(simulator.getMaxX());
        locationY = simulator.randomInt(simulator.getMaxY());
        energy = simulator.getInitialEnergy();
    }

    // -----------------------------------------------------------------------
    // CONCRETE METHODS
    // -----------------------------------------------------------------------

    /**
     * A Handy toString method for debugging.
     *
     * @return Stringified representation of the animal.
     */
    public String toString() {
        return String.format("<%s(%d,%d): %f>", this.getClass().getName(), getLocationX(), getLocationY(), getEnergy());
    }

    // -----------------------------------------------------------------------
    // GETTERS AND SETTERS
    // -----------------------------------------------------------------------
    public Simulator getSimulator() {
        return simulator;
    }

    public void setSimulator(Simulator simulator) {
        this.simulator = simulator;
    }

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

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }

    public static void main(String[] args) {
        int random = (int) (Math.random()*3) -1;
        System.out.println(random);
    }
}