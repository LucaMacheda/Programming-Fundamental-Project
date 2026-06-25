# Programming-Fundamental-Project

# Simple Tic-Tac-Toe Game with Java Swing, Login, and Statistics

## Student Information
Name: Luca Macheda  
Student ID: 599252026 
Class: Q  

## Project Description
This project is a simple Tic-Tac-Toe game built using Java Swing.  
The application includes login, game statistics, and Top 5 scorer feature.

## Features
- Login using database
- Play Tic-Tac-Toe using Swing GUI
- Record wins, losses, draws, and score
- Display personal statistics
- Display Top 5 scorers using JTable

## Database
Database used: MySQL

## How to Create the Database
1. Open MySQL.
2. Create a database named `game_project`.
3. Run the SQL script in `database/schema.sql`.

## How to Run
1. Create the database.
2. Import `schema.sql`.
3. Open the Java project in your IDE.
4. Add MySQL JDBC driver to the project.
5. Configure `DatabaseManager.java`.
6. Run `Main.java`.

## Class Explanation
### Main
Starts the program and opens the login window.

### DatabaseManager
Handles JDBC database connection.

### Player
Stores player data such as id, username, wins, losses, draws, and score.

### PlayerService
Handles login, retrieving player data, updating statistics, and retrieving Top 5 scorers.

### GameLogic
Handles valid move checking, winner checking, draw checking, and computer moves.

### LoginFrame
Swing window for entering username and password.

### MainMenuFrame
Swing window for opening the main menu after login.

### GameFrame
Swing window for playing Tic-Tac-Toe.

### StatisticsFrame
Swing window for displaying the current player's statistics.

### TopScorersFrame
Swing window for displaying Top 5 scorers using JTable.

## GitHub Repository Link
https://github.com/LucaMacheda/Programming-Fundamental-Project.git
