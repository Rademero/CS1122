/*
* Michael Romero
* Cs1122
* Predator V.S Prey
*This will call on all moments/ actions of animals and grass
* Also makes a new simulator
* This differs from my user notes
* */

import java.util.ArrayList;

public class Run {
   private static Simulator simulator;
//allows the Gui to call on actions of animals or grass
    //@return returns the main simulator of the project
    public Simulator main()
    {
         simulator = new Simulator() {
            @Override
            //Moves every animal in the array lists
            public void animalsMove() {
                for (Wolf wolf : getCurrentWolfs()) {
                    wolf.move();//every wolf moves
                }
                for (Moose moose : getCurrentMoose()) {
                    moose.move();//every  moose moves
                }
            }

            @Override
            //Calls for animal death
            public void animalsDie() {
                for(int i = 0; i < getCurrentWolfs().size(); i++){
                    Wolf wolf = getCurrentWolfs().get(i);
                    wolf.die();//wolf dies
                }
                for(int i = 0; i < getCurrentMoose().size(); i++){
                    Moose moose = getCurrentMoose().get(i);
                    moose.die();//moose dies
                }
            }

            @Override
            //calls for the eat methods
            public void animalsEat() {
                for(int i = 0; i < getCurrentWolfs().size(); i++){
                    Wolf wolf = getCurrentWolfs().get(i);
                    wolf.eat();//calls for wolf eat
                }
                for(int i = 0; i < getCurrentMoose().size(); i++){
                    Moose moose = getCurrentMoose().get(i);
                    moose.eat();//calls for moose eat
                }
            }

            @Override
            //makes new animal if it can reproduce
            public void animalsReproduce() {
                for(int i = 0; i < getCurrentWolfs().size(); i++){
                    Wolf wolf = getCurrentWolfs().get(i);
                    Wolf newWolf = wolf.reproduce();
                    if (newWolf != null) {
                        ArrayList<Wolf> temp = getCurrentWolfs();
                        temp.add(newWolf);
                        setCurrentWolfs(temp);//adds wolf to current population
                    }
                }
                for(int i = 0; i < getCurrentMoose().size(); i++){
                    Moose moose = getCurrentMoose().get(i);
                    Moose newMoose = moose.reproduce();
                    if (newMoose != null) {
                        ArrayList<Moose> temp = getCurrentMoose();
                        temp.add(newMoose);
                        setCurrentMoose(temp);//adds new moose to current population
                    }
                }

            }
            @Override
            //calls for the grass to grow and spread
            public void grassGrows() {
                for(int i = 0; i < getCurrentGrass().size(); i++){
                    Grass grass = getCurrentGrass().get(i);
                    grass.grow();
                    grass.spread();
                }
            }
            @Override
            public void run() {
                //Gui now handles this
            }
        };
        // create the initial set of wolfs and moose and populates the world with grass
        for (int i = 0; i < simulator.getInitialMoose(); i++) {
            Moose moose = new Moose(simulator);
            ArrayList<Moose> initialWolfs = simulator.getCurrentMoose();
            initialWolfs.add(moose);
        }
        for (int i = 0; i < simulator.getInitialWolves(); i++) {
            Wolf wolf = new Wolf(simulator);
            ArrayList<Wolf> initialWolfs = simulator.getCurrentWolfs();
            initialWolfs.add(wolf);
        }
        for (int i = 1; i <= simulator.getInitialGrass(); i++) {
                Grass grass = new Grass(simulator);
                ArrayList<Grass> setGrass;
                setGrass = simulator.getCurrentGrass();
                setGrass.add(grass);
                simulator.setCurrentGrass(setGrass);
        }
        return simulator;
    }

}
