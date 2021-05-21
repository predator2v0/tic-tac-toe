import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	static char[][] gameBoard = { 
			{ ' ', '|', ' ', '|', ' ' }, 
			{ '-', '+', '-', '+', '-' }, 
			{ ' ', '|', ' ', '|', ' ' },
			{ '-', '+', '-', '+', '-' }, 
			{ ' ', '|', ' ', '|', ' ' } };
	static ArrayList<Integer> userPosition = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPosition = new ArrayList<Integer>();
//	main method starts
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int userChoice, cpuChoice;
		Random rand = new Random();
		printGameBoard();
		while (true) {
			System.out.println("enter a value between 1-9: ");
			userChoice = sc.nextInt();
			while(userPosition.contains(userChoice) || cpuPosition.contains(userChoice)) {
				System.out.println("position already taken..enter a valid position: ");
				userChoice = sc.nextInt();
			}
			placeChoice(userChoice, "user");
			checkWinner();
			cpuChoice = rand.nextInt(9) + 1;
			while(userPosition.contains(cpuChoice) || cpuPosition.contains(cpuChoice)) {
				System.out.println("position already taken..enter a valid position: ");
				cpuChoice = rand.nextInt(9)+1;
			}
			placeChoice(cpuChoice, "cpu");
			checkWinner();
			printGameBoard();
		}
	}
//	method to print the game board.
	public static void printGameBoard() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(gameBoard[i][j]);
			}
			System.out.println();
		}
	}
//	method to update the user input and cpu placement on the board.
	public static void placeChoice(int choice, String user) {
		char choiceValue = 'X';
		if (user == "user") {
			choiceValue = 'X';
			userPosition.add(choice);
		} else if(user == "cpu"){
			choiceValue = 'O';
			cpuPosition.add(choice);
		}
		switch (choice) {
			case 1:
				gameBoard[0][0] = choiceValue;
				break;
			case 2:
				gameBoard[0][2] = choiceValue;
				break;
			case 3:
				gameBoard[0][4] = choiceValue;
				break;
			case 4:
				gameBoard[2][0] = choiceValue;
				break;
			case 5:
				gameBoard[2][2] = choiceValue;
				break;
			case 6:
				gameBoard[2][4] = choiceValue;
				break;
			case 7:
				gameBoard[4][0] = choiceValue;
				break;
			case 8:
				gameBoard[4][2] = choiceValue;
				break;
			case 9:
				gameBoard[4][4] = choiceValue;
				break;
			default:
				System.exit(0);
		}
	}
	
//	check the winner of the game.
	public static void checkWinner() {
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List botRow = Arrays.asList(7,8,9);
		List leftCol = Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List rightCol = Arrays.asList(3,6,9);
		List leftCross = Arrays.asList(1,5,9);
		List RightCross = Arrays.asList(3,5,7);
		
		List<List> winningCondition = new ArrayList<>();
		winningCondition.add(topRow);
		winningCondition.add(midRow);
		winningCondition.add(botRow);
		winningCondition.add(leftCol);
		winningCondition.add(midCol);
		winningCondition.add(rightCol);
		winningCondition.add(leftCross);
		winningCondition.add(RightCross);
		
		for(List l: winningCondition) {
			if(userPosition.containsAll(l)) {
				System.out.println("Congratulations!! user wins :) ");
				System.exit(0);
			}else if(cpuPosition.containsAll(l)){
				System.out.println("CPU wins!! :(");
				System.exit(0);
			}else if(userPosition.size() + cpuPosition.size() == 9) {
				System.out.println("Match Draw!!");
				System.exit(0);
			}
		}
		
	}

}
