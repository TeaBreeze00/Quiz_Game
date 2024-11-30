package P5;

import P4.Game;

//Features:
//	  - We have from 1 to 3 players
//	  - We have many questions grouped in 3 categories . Each player chooses a category before being asked. 
//	  - Each player may be asked more than one question from different categories. 
//	  - User can play many rounds of the game. 
//	 
//	 Focus: 
//	 	- 2-D arrays 
//	 
//	 Aim:
//	 	- Build more complex programs that involves the use of 2-D arrays
//


public class Main {				
	static Game game;			
	
	//Two arrays for questions and answers (both are global, i.e., accessible by all code in the class).
	//Replace array values with real questions/answers
	static String[][] questions = {/*Animal*/{"How many noses does a slug have?", "Name a mammal that can’t jump.", "What is the fastest land animal?", "What is the fastest aquatic animal?", "What was the lifespan of a Tyrannosaurus Rex?", "What is the sweet food made by bees?", "Which mammal lives the longest?", "On a common ladybug, what color are its spots?", "How many legs does a lobster have?"},
	                                /*General*/{"What does “www” stand for in a website browser?", "How long is an Olympic swimming pool (in meters)?", "Which country do cities of Perth, Adelade & Brisbane belong to?","What geometric shape is generally used for stop signs?", "What is \"cynophobia\"?", "What punctuation mark ends an imperative sentence?", "Who named the Pacific Ocean?", "How many languages are written from right to left?", "What is the name of the man who launched eBay back in 1995?"},
	                                /*Movie*/{"What are the dying words of Charles Foster Kane in Citizen Kane?", " Who played Mrs. Robinson in The Graduate?", ": What was the first feature-length animated movie ever released?"," In The Matrix, does Neo take the blue pill or the red pill?", "For what movie did Tom Hanks score his first Academy Award nomination?", "What 1927 musical was the first “talkie”?", "What’s the name of the skyscraper in Die Hard?", "What flavor of Pop Tarts does Buddy the Elf use in his spaghetti in Elf? ", "What pop vocal group performs at the wedding in Bridesmaids?"}};
	static String[][] answers =   {/**/{"Four",   "Elephant",   "Cheetah",   "sailfish",   "20",   "Honey",   "Whale",   "Black",   "10"},
			                       /**/{"World Wide Web", "50", "Australia","Octagon", "Fear of dogs", "exclamation point", "Ferdinand Magellan", "12", "Pierre Omidyar"},
			                       /**/{"Rosebud", "Anne Bancroft", "Snow White and the Seven Dwarfs","Red", "Big", "The Jazz Singer", "Nakatomi Plaza", "Chocolate", "Wilson Phillips"}};
	
	public static void main(String[] args) {
		String ans;
		do{								
			//Reset the game
			game = new Game();			
			
			//Get number of players (from 1 to 3)
			int numPlayers = game.askForInt("How many players", 1, 3);

			//Add up to 3 players to the game
			for (int i = 0; i < numPlayers; i++) {
				String name = game.askForText("What is player " + i + " name?");
				game.addPlayer(name);				
			}
			

			shuffleQuestions(questions, answers);
			
			
			int maxRounds = questions[0].length/numPlayers;
			int numRounds = game.askForInt("How many rounds?(each payer gets one question per round)", 1, maxRounds);

			
			for(int i = 0; i<numRounds; i++) {
				
				int c1 = 0;
				int c2 = 0;
				int c3 = 0;
				
				for (int j = 0; j < numPlayers; j++) {
					game.setCurrentPlayer(j);
					int categories = game.askForInt("Choose a category 1-Animal 2-General 3-Movie", 1, 3);
					
					if(c1< questions[categories-1].length || c2< questions[categories-1].length || c3< questions[categories-1].length) {
						if((categories-1) == 0) {
							String answer = game.askForText(questions[0][c1]);
							if(answers[0][c1].equalsIgnoreCase(answer)) {
								game.correct();
								c1++;
							}else{
								game.incorrect();
							}
						}
						
						if((categories-1) == 1) {
							String answer = game.askForText(questions[1][c2]);
							if(answers[1][c2].equalsIgnoreCase(answer)) {
								game.correct();
								c2++;
							}else{
								game.incorrect();
							}
						}
						
						if((categories-1) == 2) {
							String answer = game.askForText(questions[2][c3]);
							if(answers[2][c1].equalsIgnoreCase(answer)) {
								game.correct();
								c3++;
							}else{
								game.incorrect();
							}
						}
						
					}else {
						categories = game.askForInt("Choose another category 1-Animal 2-General 3-Movie", 1, 3);
						
						if((categories-1) == 0) {
							String answer = game.askForText(questions[0][c1]);
							if(answers[0][c1].equalsIgnoreCase(answer)) {
								game.correct();
								c1++;
							}else{
								game.incorrect();
							}
						}
						
						if((categories-1) == 1) {
							String answer = game.askForText(questions[1][c2]);
							if(answers[1][c2].equalsIgnoreCase(answer)) {
								game.correct();
								c2++;
							}else{
								game.incorrect();
							}
						}
						
						if((categories-1) == 2) {
							String answer = game.askForText(questions[2][c3]);
							if(answers[2][c1].equalsIgnoreCase(answer)) {
								game.correct();
								c3++;
							}else{
								game.incorrect();
							}
						}
					}

				}
			}

				
			//Do you want to play again? make sure you get valid input
			ans = game.askForText("Play again? (Y/N)"); 
			while(ans != null && !ans.toUpperCase().equals("Y") && !ans.toUpperCase().equals("N"))
				ans = game.askForText("Invalid input. Play again? (Y/N)");
		}while(ans.toUpperCase().equals("Y"));	//play again if the user answers "Y" or "y"

		System.exit(1); 	//This statement terminates the program
		
	}
	
	public static void shuffleQuestions(String[][]x, String[][]y) {
		String[][] tempQues = new String[x.length][x[0].length];
		String[][] tempAns = new String[y.length][y[0].length];
		
		for(int r = 0; r<x.length; r++) {
			
			for(int c =  0; c<x[0].length; c++) {
				
				int rand = (int)(Math.random()*x[0].length);
				tempQues[r][c] = x[r][c];
				x[r][c] = x[r][rand];
				x[r][rand] = tempQues[r][c];
				
				tempAns[r][c] = x[r][c];
				y[r][c] = y[r][rand];
				y[r][rand] = tempAns[r][c];
				
			}
			
		}
	}
		
}
