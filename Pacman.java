// Player will have to locate the pacman manually by allocate X & Y.
// Player able to choose which direction that the pacman face (North, South, East, West)
// Player able to choose what action need to do next. (Change Pacman direction, move pacman by 1 step, gets report and Quit the simulation)
// Pacman will not go out of the 5x grid dimension as set.


import java.util.Scanner;
import java.util.regex.Pattern; 

public class Pacman {
	static Scanner sc = new Scanner(System.in);
	private static PacmanMap pacmanMap;

	public static void main(String args[]){
		pacmanMap = new PacmanMap();
		userstartLocation();
	}
	public static void userstartLocation(){
		System.out.println("Please choose where you want the Pacman start.");
		System.out.println("Please select Pacman's Location X:");
		int pacmanX = validatePacmanLoc();
		System.out.println("Please select Pacman's Location Y:");
		int pacmanY = validatePacmanLoc();
		System.out.println("Please select Pacman's Direction:");
		System.out.println("North - N");
		System.out.println("South - S");
		System.out.println("East - E");
		System.out.println("West - W");
		sc.nextLine();
		String pacmanF = validateDirection();
		pacmanMap.SetPacmanStart(pacmanX, pacmanY,convertLocation(pacmanF));
		System.out.println("PLACE: "+pacmanX+", "+pacmanY+", "+pacmanMap.printDirection());
		UserAction();
		pacmanMap.getDimension();
	}
	public static void UserAction() {
		
		String option = "";
		while(!option.matches("q|Q")){
			pacmanAction();
			option = chooseOption();
			pacmanMap.userInput(option);
			pacmanMap.getDimension();
		}
		
	}
	
	public static String chooseOption() {
		String option = "";
		while(!option.matches("l|r|m|p|q|L|R|M|P|Q")) {
			option=sc.nextLine();
			if(!option.matches("l|r|m|p|q|L|R|M|P|Q")){
				System.out.println("Please press the right option: ");
				System.out.println("L - LEFT");
				System.out.println("R - RIGHT");
				System.out.println("M - MOVE");
				System.out.println("P - REPORT");
				System.out.println("Q - QUIT SIMULATION");
			}
			else {
				continue;
			}
		}
		return option.toUpperCase();
	}
	
	public static void pacmanAction() {
		System.out.println("Please press the direction you want the pacman go: ");
		System.out.println("L - Left - Turn 90 degree left");
		System.out.println("R - Right - Turn 90 degree right");
		System.out.println("M - Move - Move one step forward");
		System.out.println("P - Report Current Location & Direction");
		System.out.println("Q - Exit Pacman Simulation");
	}
	
	public static int validatePacmanLoc() {
		int input = -1;
		System.out.println("Please select number between 0-4: ");
		while(input<0  || input >=5)
		{
			while (!sc.hasNextInt()) 
			{
				System.out.println("Please enter a valid number.");
				sc.next();
			}
			input=sc.nextInt();
			if(input<0 || input>=5)
			{
				System.out.println("Grid Out of Range. Please choose between 0 - 4");
			}
			else {continue;}
		}
		return input;
	}
	
	public static String validateDirection() {
		String input = "";
		System.out.println("Please choose the Pacman's direction: ");
		while(!input.matches("n|s|e|w|N|S|E|W")) {
			while (!sc.hasNext()) 
			{
				System.out.println("Please choose between ");
				System.out.println("N- North");
				System.out.println("S- South");
				System.out.println("E- East");
				System.out.println("W- West");
				sc.next();
			}
			input=sc.nextLine();
			if(!input.matches("n|s|e|w|N|S|E|W")) {
				System.out.println("Please choose between ");
				System.out.println("N- North");
				System.out.println("S- South");
				System.out.println("E- East");
				System.out.println("W- West");
			}
			else {
				continue;
			}
		}
		return input;
	}
	
	public static int convertLocation(String F) {
		F = F.toUpperCase();
		int face = 0;
		switch(F) {
		case "N": face = 1;break;
		case "S": face = 2;break;
		case "E": face = 3;break;
		case "W": face = 4;break;

		}
		return face;
	}
}