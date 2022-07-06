# Mancala Game
<img width="822" alt="image" src="https://user-images.githubusercontent.com/54305314/177436705-c0885208-84fb-4517-86bd-0c776c23b789.png">
This is team Designer101's final project for CS151: Object-Oriented Design at San Jose State University with Professor Suneuy Kim during Spring 2021. Mancala is a turn-based strategy board game played with small stones, beans, or seeds and rows of holes or pits in the board. The objective is to capture all or some set of the opponent's pieces. The goal of this project is to create a 2D implementation of the board game using the model, view, and contoller (MVC) patterns shown in class.

### Team Members
- Berlun Devera
- Brandon Russell
- Sweta Pradhan

## Project Breakdown

### Project Program
2-Player Mancala board game with each player taking turns using the mouse
### Initial Game Screen
<img width="370" alt="Screen Shot 2022-07-05 at 5 11 17 PM" src="https://user-images.githubusercontent.com/54305314/177450438-dbc191c7-9774-4b21-b242-a14eb62fb8a0.png">

- Two buttons displayed for game board style selection
- Different styles can include the shape and color of pits and Mancalas
### Initial Board State
- Program displays empty game board in selected style
- Program then asks player for the number of stones/pit; 3 or 4 allowed
  - Each pit will start with that number of stones
  - Mancalas remain empty
### Gameplay
1. Player picks pit by selecting it with mouse
2. Program then updates game board according to the game rule
   - Stones of pit are picked up and then, moving counter-clockwise starting with the next pit, one stone is placed in each pit until the stones run out
     - This includes the current players Mancala pit; opponent’s Mancala pit is skipped over
3. Player then has the option to undo their choice
   - Changes the board state back to the previous state
   - Can only use undo function after a choice has been made
   - Max 3 undos per turn
### Notes
  - Must use the MVC pattern for game program
  - Must use the Strategy pattern to plug in a style of the game board
  - Must draw a Mancala board, pits, and stones
    -  Allowed to use images for visualization
  - Each pit must be labeled A1-A6 and B1-B6
  - Manacalas labeled Mancala A and Mancala B
