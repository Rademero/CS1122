public class Animal {
    public Animal(float energy) {
        this.energy = energy;
    }

    private float energy;

    public float getEnergy() {
        return energy;
    }

    public void setEnergy(float energy) {
        this.energy = energy;
    }
    public boolean isDead(){
        if (energy < 0){
            return true;
        }
        return false;
    }
}
