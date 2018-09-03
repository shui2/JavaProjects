package game.core;

import java.util.*;

public class Game {
	
	private Scanner sc = new Scanner(System.in);
	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> list = new ArrayList<>();
	private int numOfGuesses = 0;
	private String guesses = "";
	
	public static void main(String[] args) {
		Game game = new Game();
		game.setUpGame();
		game.startPlaying();
	}
	
	private void setUpGame() {
		System.out.println("\n============== Welcome to the 'Sink a DotCom' game ==============\n");
		System.out.println("In this game, your goal is to sink all Dot Coms randomly placed on 7x7 grid.\nDotComs are ranked by (A-G) and (0-6).\nAdditionaly, you can type in 'info' to see how many DotComs have been hit,\nand 'guesses' to see all the guesses you made.\nAt the end of the game, you will be given a score rating.\nGood luck!\n");
		
		DotCom a = new DotCom("g2a.com");
		DotCom b = new DotCom("example.com");
		DotCom c = new DotCom("monty.com");
		
		list.add(a);
		list.add(b);
		list.add(c);
		
		for (DotCom i : list) {
			i.setLocationCells(helper.placeDotCom(3));
		}	
	}
	
	private void startPlaying() {
		while(!list.isEmpty()) {
			System.out.print("Enter a guess: ");
			String answer = sc.nextLine().toLowerCase();
			
			if (answer.equals("info")) {
				System.out.println();
				for (DotCom i : list) {
					System.out.println(i);
				}
				continue;
			}
			
			if (answer.equals("guesses")) {
				System.out.println("\nGuesses made: " + guesses + "\n");
				continue;
			}
			checkUserGuess(answer);
		}
		
		finishGame();
	}
	
	private void checkUserGuess(String guess) {
		numOfGuesses++;
		
		if (!guesses.contains(guess.toUpperCase())) {
			guesses += guess.toUpperCase() + " ";
		}
		
		String result = "miss";
		
		for (DotCom i : list) {
			result = i.checkYourself(guess);
			
			if (result.equals("kill")) {
				list.remove(i);
				System.out.println("Ouch! You sunk " + i.getName() + " :(");
				break;
			} else if (result.equals("hit")) {
				break;
			}
		}
		
		System.out.println(result);
	}
	
	private void finishGame() {
		System.out.println("\nGame over");
		System.out.println("Number of guesses: " + numOfGuesses);
		
		System.out.print("Performance rating: ");
		if (numOfGuesses < 10) {
			System.out.println("Perfect!");
		} else if (numOfGuesses < 15) {
			System.out.println("Great!");
		} else if (numOfGuesses < 30) {
			System.out.println("Average");
		} else {
			System.out.println("Boo!");
		}
	}
}

