# Quiz Game Java Program

## Overview

This Java program is a simple yet engaging quiz game where players are asked a series of questions and awarded points based on their answers. The game can be played by multiple players, each competing to achieve the highest score by answering questions correctly.

## Features

- **Multiple Players**: Support for multiple players to participate in the quiz.
- **Question Bank**: A set of predefined questions stored within the program.
- **Scoring System**: Points are awarded for correct answers, and scores are tallied to determine the winner.
- **User Interaction**: Players interact with the game through a command-line interface.
- **Feedback**: Immediate feedback is provided on whether the answer is correct or incorrect.

## How to Play

1. **Start the Game**: Run the program from the command line.
2. **Enter Player Names**: Players are prompted to enter their names to begin the game.
3. **Answer Questions**: Players take turns answering questions presented by the game.
4. **Receive Points**: Points are awarded for each correct answer. No points are deducted for incorrect answers.
5. **View Scores**: After all questions have been answered, the scores are displayed, and the player with the highest score wins.

## Program Structure

- **Main Class**: The main class initializes the game and controls the flow of play.
- **Player Class**: Stores player information such as name and score.
- **Question Class**: Represents a quiz question, including the question text and correct answer.
- **Quiz Logic**: Handles the presentation of questions, collection of answers, and updating of scores.

## Example Usage

To run the program, compile the Java files and execute the main class. Players will be prompted to enter their names, and the game will proceed to ask questions in turn.

```bash
javac QuizGame.java
java QuizGame
```

### Sample Output

```
Welcome to the Quiz Game!
Enter the number of players: 2
Enter name for player 1: Alice
Enter name for player 2: Bob

Alice, it's your turn.
Question: What is the capital of France?
Answer: Paris
Correct! You earn 1 point.

Bob, it's your turn.
Question: What is the largest planet in our solar system?
Answer: Jupiter
Correct! You earn 1 point.

Final Scores:
Alice: 1
Bob: 1
It's a tie!
```

## Customization

- **Adding Questions**: Modify the `Question` class to add more questions to the quiz.
- **Adjusting Points**: Change the scoring logic if different point values are desired.
- **User Interface**: Enhance the user interface for a more interactive experience, possibly by adding a graphical interface.

## Requirements

- **Java Development Kit (JDK)**: Ensure JDK is installed to compile and run the program.
- **Text Editor/IDE**: Use any text editor or integrated development environment (IDE) to edit and compile the code.

## Conclusion

This quiz game is a fun and educational tool that can be used in various settings, such as classrooms or social gatherings. It provides a straightforward way to test knowledge and compete in a friendly manner. Feel free to expand and customize the game to suit your specific needs.
