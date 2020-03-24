package Race;
//SHAMIM BABUL
//PROJECT 2

//Run the simulation from here.
public class RunSimulation {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//change the track numbers here;
		int track=70;
		//Simulation pictures were meant for 1280x720 pixels frame
		//I didn't have time to use any other resolution and it will mess
		//up the graphics of where hare,tortoise and the entire texts.
		//The simulation will run fine . The console will output the same race as the graphics.
		//Change the timer by changing the delay amount in the Simulation.java run function
		// Simulation sim=new Simulation(); // constructor works fine;
		Simulation sim=new Simulation("Hare vs Tortoise Race",1280,720,track);
		sim.start();


	}
}
