# Othello in Java
A Java implementation of the classic board game Othello (Reversi), featuring an AI opponent driven by the Minimax algorithm.

## Features
* Single-player mode against an AI opponent.
* Adjustable difficulty levels based on search depth.
* Full implementation of Othello game rules and logic.

## Technical Implementation
The project is built using Object-Oriented Programming principles and consists of 9 core classes that handle the game state, board updates, and move validation.

## AI Algorithm
* The artificial intelligence is implemented using the Minimax algorithm with Alpha-Beta Pruning.
* Search Depth: The difficulty level determines how many moves ahead the AI calculates.
* Heuristic Evaluation: The AI evaluates potential board states using a scoring function that considers corner occupancy, edge stability, and the number of available moves (mobility).

## How to Run
1) Clone the repository to your local machine.
2) Navigate to the project directory.
3) Compile the source files:
```javac *.java```
4) Run the application:
```java Main```
